package com.example.kmyc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class DruidUtils {
    //1.定义成员变量 Datasource
    private static DataSource ds = null ;
    static {
        try {
            //加载配置文件
            Properties pro = new Properties();
            pro.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取连接池
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接，抛出异常，可以提醒用户
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 获取连接池
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 释放资源
     * 对于Connection连接对象，其实不是关闭连接，而是归还链接
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs , Statement stmt , Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源，针对增删改语句，DML管理语句
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt ,Connection conn){
        close(null,stmt,conn);
    }
}
