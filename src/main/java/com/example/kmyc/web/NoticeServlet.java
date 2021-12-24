package com.example.kmyc.web;

import com.example.kmyc.domain.Notice;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.NoticeService;
import com.example.kmyc.service.impl.NoticeServiceImpl;
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
 * 3 * @Date: 2021/12/24 11:06
 * 4
 */
@WebServlet("/notice/*")
public class NoticeServlet extends BaseServlet {
    private NoticeService noticeService = new NoticeServiceImpl();
    public void saveNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = noticeService.insertNotice((String) map.get("content"),Long.parseLong(map.get("inputer").toString()));
        Result result = new Result(200,flag,"/saveNotice");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void updateNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = noticeService.updateNotice(Long.valueOf(map.get("id").toString()),(String) map.get("content"));
        Result result = new Result(200,flag,"/updateNotice");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void deleteNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = noticeService.deleteNotice(Long.valueOf(map.get("id").toString()));
        Result result = new Result(200,flag,"/deleteNotice");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void listNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        List<Notice> notices = noticeService.listNotice();
        // 将输出结果序列化
        String json = mapper.writeValueAsString(notices);
        // 输出结果
        response.getWriter().print(json);
    }
}
