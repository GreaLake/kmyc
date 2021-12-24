package com.example.kmyc.web;

import com.example.kmyc.domain.Information;
import com.example.kmyc.domain.Page;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.InformationService;
import com.example.kmyc.service.impl.InformationServiceImpl;
import com.example.kmyc.web.base.BaseServlet;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * 1.*快乐每一天
 * 2 * @Author: lake
 * 3 * @Date: 2021/12/24 10:44
 * 4
 */
@WebServlet("/information/*")
public class InformationServlet extends BaseServlet {
    private InformationService informationService = new InformationServiceImpl();
    public void saveInformation(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = informationService.insertInformation((String) map.get("title"),(String) map.get("content"),Long.valueOf(map.get("inputer").toString()));
        Result result = new Result(200,flag,"/saveInformation");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void updateInformation(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = informationService.updateInformation(Long.valueOf(map.get("id").toString()),(String) map.get("title"),(String) map.get("content"));
        Result result = new Result(200,flag,"/updateInformation");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public  void deleteInformation(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = informationService.deleteInformation(Long.valueOf(map.get("id").toString()));
        Result result = new Result(200,flag,"/deleteInformation");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public  void listInformation(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Page<Information> informationPage = informationService.listInformationByPage(Integer.valueOf(map.get("page").toString()), Integer.valueOf(map.get("size").toString()));
        Result result = new Result(200,informationPage,"/deleteInformation");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
}
