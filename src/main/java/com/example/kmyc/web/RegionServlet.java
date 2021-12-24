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
    public void saveRegion(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = regionService.insertRegion((String) map.get("name"),Long.valueOf(map.get("father").toString()),Long.valueOf(map.get("inputer").toString()));
        Result result = new Result(200,flag,"/saveRegion");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void updateRegion(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = regionService.updateRegion(Long.valueOf(Long.valueOf(map.get("id").toString())),(String) map.get("name"),Long.valueOf(map.get("father").toString()));
        Result result = new Result(200,flag,"/updateRegion");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void deleteRegion(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = regionService.deleteRegion(Long.valueOf(map.get("id").toString()));
        Result result = new Result(200,flag,"/deleteRegion");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }public void lsitRegion(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        List<Region> regions = regionService.listRegionByFather(Long.valueOf(map.get("father").toString()));
        // 将输出结果序列化
        String json = mapper.writeValueAsString(regions);
        // 输出结果
        response.getWriter().print(json);
    }
}