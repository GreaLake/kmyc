package com.example.kmyc.web;

import com.example.kmyc.domain.Carousel;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.CarouselService;
import com.example.kmyc.service.impl.CarouselServiceImpl;
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
 * 3 * @Date: 2021/12/24 9:18
 * 4
 */
@WebServlet("/carousel/*")
public class CarouselServlet extends BaseServlet {
    private CarouselService carouselService = new CarouselServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 反序列化，把json数据格式转换成object格式
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        // 调用业务层方法录入数据
        Boolean flag = carouselService.insertCarousel((String) map.get("name"), (String) map.get("group"), Long.valueOf(map.get("image").toString()), Long.valueOf(map.get("inputer").toString()));
        // 封装成返回结果
        Result result = new Result(200,flag,"/save");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void update(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 获取字符流读取类
        BufferedReader reader = request.getReader();
        // 反序列化，把josn格式转换成Object格式
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        // 调用业务层修改数据
        Boolean flag = carouselService.updateCarousel(Long.valueOf(map.get("id").toString()), (String) map.get("name"), (String) map.get("group"), Long.valueOf(map.get("image").toString()));
        // 封装成返回结果
        Result result = new Result(200,flag,"/update");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void delete(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 获取字符流读取类
        BufferedReader reader = request.getReader();
        // 反序列化，把josn格式转换成Object格式
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        // 调用业务层修改数据
        Boolean flag = carouselService.deleteCarousel(Long.valueOf(map.get("id").toString()));
        // 封装成返回结果
        Result result = new Result(200,flag,"/delete");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }
    public void listByGroup(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 获取字符流读取类
        BufferedReader reader = request.getReader();
        // 反序列化，把josn格式转换成Object格式
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(reader,Map.class);
        // 调用业务层查询数据
        List<Carousel> carousels = carouselService.listCarouselByGroup(map.get("group").toString());
        // 将输出结果序列化
        String json = mapper.writeValueAsString(carousels);
        // 输出结果
        response.getWriter().print(json);
    }
}
