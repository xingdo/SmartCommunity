package com.demo.velocity;

import com.demo.utils.EasyuiColumn;
import com.demo.utils.FieldVo;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VelocityMain {

    //模板文件数组定义:
    static String[] templateName = {
             "DomainController.java"
            , "DomainQuery.java", "DomainServiceImpl.java", "IDomainService.java"
    };

    //项目路径：
    static final String controllerFilePath = "E:\\java\\JavaCode\\idea\\SmartCommunity\\Demo_01\\src\\main\\java\\com\\demo\\controller\\";
    static final String queryFilePath = "E:\\java\\JavaCode\\idea\\SmartCommunity\\Demo_01\\src\\main\\java\\com\\demo\\query\\";
    static final String serviceImplFilePath = "E:\\java\\JavaCode\\idea\\SmartCommunity\\Demo_01\\src\\main\\java\\com\\demo\\service\\impl\\";
    static final String serviceFilePath = "E:\\java\\JavaCode\\idea\\SmartCommunity\\Demo_01\\src\\main\\java\\com\\demo\\service\\";

    //生成文件的路径数据定义：这个要和templateName对应起来
    static String[] outFileRootPath = {
             controllerFilePath, queryFilePath
            , serviceImplFilePath,serviceFilePath
    };

    //可能有多个domain需要生成
    static String[] domain = {"Feedback"};

    /**
     * 1：定义模板
     * 2：使用Velocity生成模板：
     * 2.1：初始化Velocity：设置加载方式：classpath下加载
     * 2.2：设置Velocity的上下文
     * 2.3:从classpath下读取模板，输出到文件
     *
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {
        for (String domainMame : domain) {
            // domainName = Employee

            Properties p = new Properties();
            // 2.1：初始化Velocity：设置加载方式：classpath下加载
            // 使用classpath加载：org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
            p.setProperty(Velocity.RESOURCE_LOADER, "class");
            p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            Velocity.init(p);

            //2.2：设置Velocity的上下文
            VelocityContext context = new VelocityContext();
            //  domainName = Employee
            // domainLower= employee
            String domainLower = domainMame.substring(0, 1).toLowerCase() + domainMame.substring(1);
            //使用Department代替模板文件中：Domain
            context.put("Domain", domainMame);
            context.put("domain", domainLower);
            //
            context.put("fieldList",scanDomain(domainMame));

            //遍历模板，每一个模板都生成一个文件
            for (int i=0;i<templateName.length;i++) {
                //2.3:读取模板，输出到文件
                //从classpath下读取模板
                String tempName = templateName[i];

                // i=0==>tempName=domain.js
                String templateFile = "template\\"+tempName;
                // templateFile=template\domain.js
                //根据模板的索引读取对应生成文件的路径：
                String outFilePath = outFileRootPath[i];

                boolean views= outFilePath.contains("views")||outFilePath.contains("js");
                if(views){
                    outFilePath=outFilePath+"\\"+domainLower+"\\";
                }
                String outFile = outFilePath + tempName;
                outFile=outFile.replaceAll("Domain",domainMame).replaceAll("domain",domainLower);

                try {
                    File file = new File(outFile);
                    File parentFile = file.getParentFile();
                    //文件不存在，就创建
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    //文件输出
                    FileWriter fileWriter = new FileWriter(file);
                    Template template = Velocity.getTemplate(templateFile, "utf-8");
                    template.merge(context, fileWriter);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static List<FieldVo> scanDomain(String domainMame) throws ClassNotFoundException {
        List<FieldVo> voList=new ArrayList<>();
        // domainMame=Employee
        String clazzPath="com.demo.domain."+domainMame;
        Class<?> c = Class.forName(clazzPath);

        //获取字段
        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //判断这个字段上是否有EasyuiColumn
            if(declaredField.isAnnotationPresent(EasyuiColumn.class)){
                EasyuiColumn easyuiColumn = declaredField.getAnnotation(EasyuiColumn.class);

                //获取到注解的title的值
                String title = easyuiColumn.title();
                String name = declaredField.getName();

                FieldVo fieldVo=new FieldVo();

                fieldVo.setField(name);
                fieldVo.setTitle(title);

                voList.add(fieldVo);
            }
        }
        for (FieldVo fieldVo : voList) {
            System.out.println(fieldVo);
        }

        return voList;
    }
}
