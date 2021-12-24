package com.example.kmyc.dao.impl;

import com.example.kmyc.dao.AdminDao;
import com.example.kmyc.domain.Admin;
import com.example.kmyc.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 管理员物理层实现类
 */
public class AdminDaoImpl implements AdminDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    /**
     * 添加管理员
     * @param name 管理员用户名
     * @param password 管理员密码
     * @return java.lang.Integer
     */
    @Override
    public Integer insertAdmin(String name, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "insert tb_admin(name,password) values(?,?)";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setString(2,password);
            // 执行sql语句
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 查询是否存在该管理员
     * @param name 管理员用户名
     * @param password 管理员密码
     * @return java.lang.Integer
     */
    @Override
    public Integer countAdmin(String name, String password) {
        int count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "select count(*) from tb_admin where name= ? and password= ? and is_delete=0";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setString(2,password);
            // 执行sql语句
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            };
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(rs,ps,conn);
        }

        return count;
    }

    /**
     * 删除管理员
     * @param id 管理员编号
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteAdmin(Long id) {
        int count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_admin set is_delete=1 where id =?";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setLong(1,id);
            // 执行sql语句
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 恢复管理员
     * @param id 管理员编号
     * @return java.lang.Integer
     */
    @Override
    public Integer recoverAdmin(Long id) {
        int count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_admin set is_delete=0 where id =?";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setLong(1,id);
            // 执行sql语句
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 更新管理员权限
     * @param id 管理员编号
     * @param role 管理员权限
     * @return java.lang.Integer
     */
    @Override
    public Integer adminUpdateRole(Long id, String role) {
        int count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_admin set role = ? where id =? and is_delete=0";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,role);
            ps.setLong(2,id);
            // 执行sql语句
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 更新密码
     * @param id 管理员编号
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return java.lang.Integer
     */
    @Override
    public Integer adminUpdatePassword(Long id, String oldPassword, String newPassword) {
        int count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_admin set password =? where id =? and password =? ";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,newPassword);
            ps.setLong(2,id);
            ps.setString(3,oldPassword);
            // 执行sql语句
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 获取全部管理员信息
     * @return java.util.List
     */
    @Override
    public List<Admin> listAdmin() {
        List<Admin> admins = new ArrayList<>();
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "select id,name,password,role,is_delete,gmt_create,gmt_update from tb_admin";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 执行sql语句
            rs = ps.executeQuery();
            // 获取结果
            while (rs.next()){
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String role = rs.getString("role");
                boolean is_delete = rs.getBoolean("is_delete");
                Date gmt_create = rs.getDate("gmt_create");
                Date gmt_update = rs.getDate("gmt_update");
                // 封装为对象
                Admin admin = new Admin(id,name,password,role,is_delete,gmt_create,gmt_update);
                // 封装成集合
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(rs,ps,conn);
        }
        return admins;
    }

}
