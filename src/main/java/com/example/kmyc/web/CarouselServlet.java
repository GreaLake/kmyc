package com.example.kmyc.web;

import com.example.kmyc.domain.Carousel;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.CarouselService;
import com.example.kmyc.service.impl.CarouselServiceImpl;
import com.example.kmyc.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    Map<String,Object> info = null;
    public void saveCarousel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层方法录入数据
        Boolean flag = carouselService.insertCarousel((String) info.get("name"),
                (String) info.get("group"), Long.valueOf(info.get("image").toString()),
                Long.valueOf(info.get("inputer").toString()));
        // 封装成返回结果
        Result result = new Result(200,flag,"/saveCarousel");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void updateCarousel(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层修改数据
        Boolean flag = carouselService.updateCarousel(Long.valueOf(info.get("id").toString()),
                (String) info.get("name"), (String) info.get("group"),
                Long.valueOf(info.get("image").toString()));
        // 封装成返回结果
        Result result = new Result(200,flag,"/updateCarousel");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void deleteCarousel(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层修改数据
        Boolean flag = carouselService.deleteCarousel(Long.valueOf(info.get("id").toString()));
        // 封装成返回结果
        Result result = new Result(200,flag,"/deleteCarousel");
        // 将输出结果序列化
        mapper4Json(response,result);
    }
    public void listByGroup(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 接收参数
        info = getParam4Service(request);
        // 调用业务层查询数据
        List<Carousel> carousels = carouselService.listCarouselByGroup(info.get("group").toString());
        // 封装成返回结果
        Result result = new Result(200, carousels, "/listByGroup");
        // 将输出结果序列化
        mapper4Json(response, result);
    }
}
