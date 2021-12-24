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
    Map<String , Object> info = null;
    public void saveImage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = imageService.insertImage((String) info.get("name"),
                (String) info.get("path"),Long.parseLong(info.get("inputer").toString()));
        // 封装成返回结果
        Result result = new Result(200,flag,"/saveImage");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void updateImage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = imageService.updateImage(Long.parseLong(info.get("id").toString()),
                (String) info.get("name"),(String) info.get("path"));
        // 封装成返回结果
        Result result = new Result(200,flag,"/updateImage");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void deleteImage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = imageService.deleteImage(Long.parseLong(info.get("id").toString()));
        // 封装成返回结果
        Result result = new Result(200,flag,"/deleteImage");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void listImage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 调用业务层方法来录入数据
        List<Image> images = imageService.listImage();
        Result result = new Result(200,images,"/listImage");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
}
