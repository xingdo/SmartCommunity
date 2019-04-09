package com.demo.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
* 列出系統中所有可以下載的文件
* 这是不在数据库中拿，而是直接去上传的文件夹中获取
* */
public class ListFileServelt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到上传的文件了目录
        String uploadPath = this.getServletContext().getRealPath("/upload");

        HashMap<String, String> fileNameMap = new HashMap<>();
        lisfile(new File(uploadPath), fileNameMap);

        req.setAttribute("fileNameMap", fileNameMap);
        req.getRequestDispatcher("listfile");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void lisfile(File file, Map<String,String> map){
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
            String realName = file.getName().substring(file.getName().lastIndexOf("/"));
            map.put(file.getName(), realName);
        }
    }
}
