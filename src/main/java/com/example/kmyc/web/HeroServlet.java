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
    Map<String,Object> info = null;
    public void saveHero(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = heroService.insertHero((String) info.get("name"),
                (String) info.get("sex"),(String) info.get("politic"),
                (String) info.get("troop"),(String) info.get("post"),
                Long.valueOf( info.get("region").toString()),
                (Date) info.get("born"),(Date) info.get("sacrifice"),
                Long.valueOf(info.get("inputer").toString()));
        Result result = new Result(200,flag,"/saveHero");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void updateHero(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来修改数据
        Boolean flag = heroService.updateHero((Long) info.get("id"),
                (String) info.get("name"), (String) info.get("sex"),
                (String) info.get("politic"),(String) info.get("troop"),
                (String) info.get("post"),(Long) info.get("region"),
                (Date) info.get("born"),(Date) info.get("sacrifice"));
        // 封装成返回结果
        Result result = new Result(200,flag,"/updateHero");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void deleteHero(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法来修改数据
        Boolean flag = heroService.deleteHero(Long.valueOf(info.get("id").toString()));
        // 封装成返回结果
        Result result = new Result(200,flag,"/deleteHero");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void listHero(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        // 调用业务层方法来查询数据
        List<Hero> heroes = heroService.listHero((Long) info.get("id"));
        // 封装成返回结果
        Result result = new Result(200, heroes, "/listHero");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
}
