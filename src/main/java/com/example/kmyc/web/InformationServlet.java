package com.example.kmyc.web;

import com.example.kmyc.domain.Information;
import com.example.kmyc.domain.Page;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.InformationService;
import com.example.kmyc.service.impl.InformationServiceImpl;
import com.example.kmyc.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    Map<String,Object> info = null;
    public void saveInformation(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = informationService.insertInformation((String) info.get("title"),
                (String) info.get("content"),Long.valueOf(info.get("inputer").toString()));
        Result result = new Result(200,flag,"/saveInformation");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void updateInformation(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = informationService.updateInformation(Long.valueOf(info.get("id").toString()),
                (String) info.get("title"),(String) info.get("content"));
        Result result = new Result(200,flag,"/updateInformation");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public  void deleteInformation(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = informationService.deleteInformation(Long.valueOf(info.get("id").toString()));
        Result result = new Result(200,flag,"/deleteInformation");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public  void listInformation(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Page<Information> informationPage = informationService
                .listInformationByPage(Integer.valueOf(info.get("page").toString()),
                        Integer.valueOf(info.get("size").toString()));
        Result result = new Result(200,informationPage,"/listInformation");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
}
