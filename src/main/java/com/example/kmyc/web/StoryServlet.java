package com.example.kmyc.web;

import com.example.kmyc.domain.Page;
import com.example.kmyc.domain.Story;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.StoryService;
import com.example.kmyc.service.impl.StoryServiceImpl;
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
 * 3 * @Date: 2021/12/24 11:28
 * 4
 */
@WebServlet("/story/*")
public class StoryServlet extends BaseServlet {
    private StoryService storyService = new StoryServiceImpl();
    public void saveStory(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = storyService.insertStory((String) map.get("title"),(String) map.get("content"),Long.valueOf(map.get("inputer").toString()),Long.valueOf(map.get("image").toString()));
        Result result = new Result(200,flag,"/saveStory");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void updateStory(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = storyService.updateStory(Long.valueOf(map.get("id").toString()),(String) map.get("title"),(String) map.get("content"));
        Result result = new Result(200,flag,"/updateStory");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void deleteStory(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = storyService.deleteStory(Long.valueOf(map.get("id").toString()));
        Result result = new Result(200,flag,"/deleteStory");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void listStoryByPage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Page<Story> storyPage = storyService.listStoryByPage(Integer.valueOf(map.get("page").toString()), Integer.valueOf(map.get("size").toString()));
        Result result = new Result(200,storyPage,"/listStoryByPage");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
}
