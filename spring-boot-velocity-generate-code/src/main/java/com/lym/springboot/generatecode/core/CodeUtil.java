package com.lym.springboot.generatecode.core;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: in liuyuanming
 * @Description: 代码生成工具类
 * @Date:Created in  2019/4/25/025 9:49
 */
public class CodeUtil {

    public final static String basePath = "E:/WorkSpaces/springbootdemo/spring-boot-velocity-generate-code/code/";

    /**
     * 生成代码
     *
     * @param templateName
     * @param className
     * @param packageName
     * @param map
     * @throws Exception
     */
    public static void generateCode(String templateName, String className, String packageName, Map<String, String> map) throws Exception {
        Template template = null;
        try {
            Properties p = new Properties();
            try {
                // 加载classpath目录下的vm文件
                p.setProperty("file.resource.loader.class",
                        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
                // 定义字符集
                p.setProperty(Velocity.ENCODING_DEFAULT, "utf-8");
                p.setProperty(Velocity.OUTPUT_ENCODING, "utf-8");
                // 初始化Velocity引擎，指定配置Properties
                Velocity.init(p);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            template = Velocity.getTemplate(templateName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Context context = new VelocityContext();
        context.put("packageName", packageName);
        context.put("className", className);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            context.put(entry.getKey(), entry.getValue());
        }
        File fileDir = new File(basePath + packageName.replace('.', '/'));
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        FileOutputStream outStream = new FileOutputStream(new File(fileDir, className + ".java"));
        OutputStreamWriter writer = new OutputStreamWriter(outStream, "UTF-8");
        BufferedWriter sw = new BufferedWriter(writer);
        template.merge(context, sw);
        sw.flush();
        sw.close();
        outStream.close();
    }
}
