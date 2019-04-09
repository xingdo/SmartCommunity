package com.demo.controller;

import com.demo.domain.Upload;
import com.demo.service.IUploadSerivce;
import com.demo.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private IUploadSerivce uploadSerivce;

    @RequestMapping("/go")
    public String go() {
        return "upload";
    }

    /*
     * 获取到存入数据库中的文件信息
     * */
    @RequestMapping("/file")
    public ModelAndView listfile(ModelAndView model) {

        HashMap<String, String> fileNameMap = new HashMap<>();

        List<Upload> uploads = uploadSerivce.selectAll();

        for (Upload upload : uploads) {
            fileNameMap.put(upload.getFilename(), upload.getFilepath());
        }
        model.addObject("fileNameMap", fileNameMap);

        model.setViewName("listfile");

        return model;
    }

    //如果直接在本地文件夹中找文件信息，可以通过递归的方法
   /* public void lisfile(File file, Map<String,String> map){
        //判断是文件还是目录
        if(!file.isFile()){
            //所有文件
            File[] files = file.listFiles();
            for (File f : files){
                //递归
                lisfile(f, map);
            }
        }else {
            //文件名
            String realName = file.getName();
            map.put(file.getName(), realName);
        }
    }*/


   /*
   * 文件的批量上传
   * */
    @RequestMapping("/up")
    @ResponseBody
    public AjaxResult upload(@RequestParam("files") MultipartFile[] files, HttpServletRequest request, HttpServletResponse resp) throws Exception {

        request.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //上传的路径
        String realPath = request.getServletContext().getRealPath("/upload");

        //遍历批量上传
        if (files.length > 0 && files != null) {

            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];

                //获取文件格式
                String extention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

                //判断格式
                if (extention.equalsIgnoreCase("docx") || extention.equalsIgnoreCase("avi")
                        || extention.equalsIgnoreCase("txt") || extention.equalsIgnoreCase("jpg")
                        || extention.equalsIgnoreCase("mp4")) {
                    File f = new File(realPath);
                    String fileName = file.getOriginalFilename();
                    //设置上传文件名不重复，通过在文件名后拼接4位uuid
                    String uuidName = UUID.randomUUID().toString().substring(0, 4);

                    StringBuffer concatName = new StringBuffer(fileName);

                    StringBuffer lastName = concatName.insert(fileName.lastIndexOf("."), uuidName);
                    //上传的路径
                    String uploadPath = realPath + File.separator + lastName;

                    if (!f.exists()) {
                        f.mkdir();
                    }

                    //文件的傳輸
                    file.transferTo(new File(uploadPath));
                    //将文件存入数据库
                    Upload upload = new Upload();
                    //设置存入的文件信息就是上传到本地的文件信息
                    upload.setFilepath(uploadPath).setFilename(lastName.toString());

                    uploadSerivce.insert(upload);
                } else {
                    return AjaxResult.getAjaxResult().setLog(false).setMsg("文件类型不正确");
                }
            }
            return AjaxResult.getAjaxResult().setLog(true).setMsg("上传成功");
        } else {
            return AjaxResult.getAjaxResult().setMsg("请选择上传的文件").setLog(false);
        }
    }

    //下载
    @RequestMapping("/download")
    @ResponseBody
    public void download(Upload upload, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String filepath = upload.getFilepath();

        String filename = upload.getFilename();
        req.setCharacterEncoding("UTF-8");
        //声明是一个下载项目
        resp.setContentType("application/x-msdownload");
        //获取下载路径
        String downPath = req.getServletContext().getRealPath("/download");

        resp.setCharacterEncoding("utf-8");

        //设置下载时的文件名

        resp.setHeader("Content-Disposition", "attachment;filename=" + filename);

        File file = new File(downPath);

        if (!file.exists()) {
            file.mkdir();
        }

        InputStream inputStream = new FileInputStream(filepath);

        OutputStream os = resp.getOutputStream();
        //设置缓冲区
        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) > 0) {
            os.write(b, 0, length);
        }
        os.close();
        inputStream.close();
    }
}
