package com.example.kmyc.web.base;

import com.alibaba.fastjson.JSON;
import com.example.kmyc.result.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.*快乐每一天
 * 2 * @Author: lake
 * 3 * @Date: 2021/12/23 11:47
 * 4
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码
        resp.setHeader("content-type", "text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        // 1.获取请求路径,请求资源标识符
        String uri = req.getRequestURI();
        // 请求资源定位符
        StringBuffer url = req.getRequestURL();

        // 2.获取方法名称
        String methodName = url.substring(url.lastIndexOf("/") + 1);

        // 3.获取this
        try {
            // 4.先当前对象的字节码，然后获取一个公开的方法
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 5.执行方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Object> getParam4Service(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        String format = "application/json";

        // 获取内容格式
        String contentType = request.getContentType();
        if (contentType != null && !"".equals(contentType)) {
            contentType = contentType.split(",")[0];
        }
        // json格式 json格式需要从request的输入流中解析获取
        if (format.equalsIgnoreCase(contentType)) {
            // 使用 commons-io中 IOUtils 类快速获取输入流内容
            String paramJson = null;
            try {
                paramJson = IOUtils.toString(request.getInputStream(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Map parseObject = JSON.parseObject(paramJson, Map.class);
            params.putAll(parseObject);
        }
        return params;
    }

    // 封装结果并输出
    public void mapper4Json(HttpServletResponse resp, Result result) throws IOException {
        // 将结果序列化
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        // 输出结果
        resp.getWriter().print(json);
    }
}