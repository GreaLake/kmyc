package com.example.kmyc.web;

import com.example.kmyc.domain.Admin;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.AdminService;
import com.example.kmyc.service.impl.AdminServiceImpl;
import com.example.kmyc.web.base.BaseServlet;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
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
 * 3 * @Date: 2021/12/23 11:49
 * 4
 */
@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet {

    private AdminService adminService = new AdminServiceImpl();
    Map<String, Object> info = null;

    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收参数 { name:? ; password:? }
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = adminService.adminRegister((String) info.get("name"),
                (String) info.get("password"));
        Result result = new Result(200, flag, "/register");
        // 序列化,并输出
        mapper4Json(response, result);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收参数 { name:? ; password:? }
        info = getParam4Service(request);
        // 调用业务层方法来录入数据
        Boolean flag = adminService.adminLogin((String) info.get("name"),
                (String) info.get("password"));
        Result result = new Result(200, flag, "/login");
        // 序列化
        mapper4Json(response, result);
    }

    public void deleteAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> admin = mapper.readValue(reader, Map.class);
        System.out.println(admin);
        // 调用业务层方法来录入数据
        Boolean flag = adminService.deleteAdmin(Long.valueOf(admin.get("id").toString()));
        Result result = new Result(200, flag, "/deleteAdmin");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }

    public void recover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> admin = mapper.readValue(reader, Map.class);
        System.out.println(admin);
        // 调用业务层方法来录入数据
        Boolean flag = adminService.recoverAdmin(Long.valueOf(admin.get("id").toString()));
        Result result = new Result(200, flag, "/recover");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }

    public void updateRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> admin = mapper.readValue(reader, Map.class);
        System.out.println(admin);
        // 调用业务层方法来录入数据
        Boolean flag = adminService.adminUpdateRole(Long.parseLong(admin.get("id").toString()), (String) admin.get("role"));
        Result result = new Result(200, flag, "/updateRole");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }

    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> admin = mapper.readValue(reader, Map.class);
        System.out.println(admin);
        // 调用业务层方法来录入数据
        Boolean flag = adminService.adminUpdatePassword(Long.valueOf(admin.get("id").toString()), (String) admin.get("oldPassword"), (String) admin.get("newPassword"));
        Result result = new Result(200, flag, "/updatePassword");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }

    public void listAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收参数
        // 获取字符流 读取类
        BufferedReader reader = request.getReader();
        // 定义线程可变的字符串
        // 反序列化，把json数据转换成object
        ObjectMapper mapper = new ObjectMapper();
        // 调用业务层方法来查询数据
        List<Admin> admins = adminService.listAdmin();
        Result result = new Result(200, admins, "/listAdmin");
        // 将输出结果序列化
        String json = mapper.writeValueAsString(result);
        // 输出结果
        response.getWriter().print(json);
    }

}
