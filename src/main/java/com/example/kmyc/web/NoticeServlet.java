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
    Map<String,Object> info = null;
    public void saveNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = noticeService.insertNotice((String) info.get("content"),
                Long.parseLong(info.get("inputer").toString()));
        Result result = new Result(200,flag,"/saveNotice");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void updateNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = noticeService.updateNotice(Long.valueOf(info.get("id").toString()),
                (String) info.get("content"));
        Result result = new Result(200,flag,"/updateNotice");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void deleteNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = noticeService.deleteNotice(Long.valueOf(info.get("id").toString()));
        // 封装成返回结果
        Result result = new Result(200,flag,"/deleteNotice");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void listNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 调用业务层方法来录入数据
        List<Notice> notices = noticeService.listNotice();
        Result result = new Result(200, notices, "/listNotice");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
}
