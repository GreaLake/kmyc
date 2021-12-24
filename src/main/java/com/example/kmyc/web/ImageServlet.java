package com.example.kmyc.web;

import com.example.kmyc.domain.Image;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.ImageService;
import com.example.kmyc.service.impl.ImageServiceImpl;
import com.example.kmyc.web.base.BaseServlet;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 1.*快乐每一天
 * 2 * @Author: lake
 * 3 * @Date: 2021/12/24 10:18
 * 4
 */
@WebServlet("/image/*")
public class ImageServlet extends BaseServlet {
    private ImageService imageService = new ImageServiceImpl();
    public void saveImage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = imageService.insertImage((String) map.get("name"),(String) map.get("path"),Long.parseLong(map.get("inputer").toString()));
        Result result = new Result(200,flag,"/saveImage");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void updateImage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = imageService.updateImage(Long.parseLong(map.get("id").toString()),(String) map.get("name"),(String) map.get("path"));
        Result result = new Result(200,flag,"/updateImage");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void deleteImage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = imageService.deleteImage(Long.parseLong(map.get("id").toString()));
        Result result = new Result(200,flag,"/deleteImage");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void listImage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        List<Image> images = imageService.listImage();
        // 将输出结果序列化
        String json = mapper.writeValueAsString(images);
        // 输出结果
        response.getWriter().print(json);
    }
}
