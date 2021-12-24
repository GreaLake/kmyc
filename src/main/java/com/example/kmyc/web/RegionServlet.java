package com.example.kmyc.web;

import com.example.kmyc.domain.Region;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.RegionService;
import com.example.kmyc.service.impl.RegionServiceImpl;
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
 * 3 * @Date: 2021/12/24 11:15
 * 4
 */
@WebServlet("/region/*")
public class RegionServlet extends BaseServlet {
    private RegionService regionService = new RegionServiceImpl();
    Map<String,Object> info = null;
    public void saveRegion(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = regionService.insertRegion((String) info.get("name"),
                Long.valueOf(info.get("father").toString()),
                Long.valueOf(info.get("inputer").toString()));
        Result result = new Result(200,flag,"/saveRegion");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void updateRegion(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = regionService.updateRegion(Long.valueOf(Long.valueOf(info.get("id").toString())),
                (String) info.get("name"),Long.valueOf(info.get("father").toString()));
        Result result = new Result(200,flag,"/updateRegion");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void deleteRegion(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = regionService.deleteRegion(Long.valueOf(info.get("id").toString()));
        Result result = new Result(200,flag,"/deleteRegion");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void listRegionByFather(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        List<Region> regions = regionService.listRegionByFather(Long.
                valueOf(info.get("father").toString()));
        Result result = new Result(200, regions, "/listRegion");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
}
