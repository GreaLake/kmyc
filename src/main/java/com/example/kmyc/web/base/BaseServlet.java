package com.example.kmyc.web.base;

import com.example.kmyc.web.AdminServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 1.*快乐每一天
 * 2 * @Author: lake
 * 3 * @Date: 2021/12/23 11:47
 * 4
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        System.out.println("BaseServlet 的 service方法执行了------");
        // 获取请求路径
        String uri = req.getRequestURI();// 请求资源标识符，范围更大
        StringBuffer url = req.getRequestURL();// 请求资源定位符
        System.out.println(uri+","+url);
        // 2.获取方法名称
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);
        System.out.println(methodName);

        // 3.获取方法要执行的对象
        System.out.println(this);
        try {
            // 4.先获取当前对象的字节码然后获取一个公开的方法
            Method method = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            // 5.执行方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
