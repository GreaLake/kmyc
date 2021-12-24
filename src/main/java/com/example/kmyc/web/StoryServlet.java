package com.example.kmyc.web;

import com.example.kmyc.domain.Page;
import com.example.kmyc.domain.Story;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.StoryService;
import com.example.kmyc.service.impl.StoryServiceImpl;
import com.example.kmyc.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    Map<String , Object> info = null;
    public void saveStory(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = storyService.insertStory((String) info.get("title"),
                (String) info.get("content"), Long.valueOf(info.get("inputer").toString()),
                Long.valueOf(info.get("image").toString()));
        Result result = new Result(200,flag,"/saveStory");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void updateStory(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = storyService.updateStory(Long.valueOf(info.get("id").toString()),
                (String) info.get("title"),(String) info.get("content"));
        Result result = new Result(200,flag,"/updateStory");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void deleteStory(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = storyService.deleteStory(Long.valueOf(info.get("id").toString()));
        Result result = new Result(200,flag,"/deleteStory");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void listStoryByPage(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Page<Story> storyPage = storyService.listStoryByPage(Integer.valueOf(info.get("page").toString()),
                Integer.valueOf(info.get("size").toString()));
        Result result = new Result(200,storyPage,"/listStoryByPage");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
}
