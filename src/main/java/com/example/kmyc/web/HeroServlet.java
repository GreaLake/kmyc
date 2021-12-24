package com.example.kmyc.web;

import com.example.kmyc.domain.Hero;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.HeroService;
import com.example.kmyc.service.impl.HeroServiceImpl;
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
 * 3 * @Date: 2021/12/24 9:53
 * 4
 */
@WebServlet("/hero/*")
public class HeroServlet extends BaseServlet {
    private HeroService heroService = new HeroServiceImpl();
    public void saveAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = heroService.insertHero((String) map.get("name"),(String) map.get("sex"),(String) map.get("politic"),(String) map.get("troop"),(String) map.get("post"),Long.valueOf( map.get("region").toString()),(Date) map.get("born"),(Date) map.get("sacrifice"),Long.valueOf(map.get("inputer").toString()));
        Result result = new Result(200,flag,"/save");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void updateAdmin(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = heroService.updateHero((Long) map.get("id"),(String) map.get("name"),(String) map.get("sex"),(String) map.get("politic"),(String) map.get("troop"),(String) map.get("post"),(Long) map.get("region"),(Date) map.get("born"),(Date) map.get("sacrifice"));
        Result result = new Result(200,flag,"/update");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void deleteAdmin(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来录入数据
        Boolean flag = heroService.deleteHero(Long.valueOf(map.get("id").toString()));
        Result result = new Result(200,flag,"/delete");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void listAdmin(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        System.out.println(map);
        // 调用业务层方法来查询数据
        List<Hero> heroes = heroService.listHero((Long) map.get("id"));
        // 将输出结果序列化
        String json = mapper.writeValueAsString(heroes);
        // 输出结果
        response.getWriter().print(json);
    }
}
