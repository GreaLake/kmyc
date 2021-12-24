package com.example.kmyc.dao.impl;

import com.example.kmyc.dao.InformationDao;
import com.example.kmyc.domain.Image;
import com.example.kmyc.domain.Information;
import com.example.kmyc.utils.DruidUtils;

import java.sql.*;
import java.util.List;

/**
 * 资讯物理层实现类
 */
public class InformationDaoImpl implements InformationDao {

    /**
     * 添加资讯
     * @param title 资讯标题
     * @param content 资讯内容
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    @Override
    public Integer insertInformation(String title, String content, Long inputer) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "insert tb_infromation(title,content,inputer) values (?,?,?)";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,title);
            ps.setString(2,content);
            ps.setLong(3,inputer);
            // 执行sql对象
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 更新资讯
     * @param id 资讯编号
     * @param title 资讯标题
     * @param content 资讯内容
     * @return java.lang.Integer
     */
    @Override
    public Integer updateInformation(Long id, String title, String content) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_information set title =?, contnet=? where id =?";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,title);
            ps.setString(2,content);
            ps.setLong(3,id);
            // 执行sql对象
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 删除资讯
     * @param id 资讯编号
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteInformation(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_infromation is_delete=0 where id=?";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setLong(1,id);
            // 执行sql对象
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(ps,conn);
        }
        return count;
    }

    /**
     * 透过页数获取图片
     * @param start 从第几个数据开始
     * @param size 获取几个数据
     * @return java.util.List
     */
    @Override
    public List<Information> listInformationByPage(Integer start, Integer size) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Information> informationList = null;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "select id,title,content,inputer,is_delete,gmt_create,gmt_update from tb_information limit ?,? where is_delete=0;";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setInt(1,start);
            ps.setInt(2,size);
            // 执行sql对象
            rs = ps.executeQuery();
            // 获取结果
            while (rs.next()){
                long id = rs.getLong("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                long inputer = rs.getLong("inputer");
                boolean is_delete = rs.getBoolean("is_delete");
                Date gmt_create = rs.getDate("gmt_create");
                Date gmt_update = rs.getDate("gmt_update");
                // 封装成对象
                Information information  = new Information(id,title,content,inputer,is_delete,gmt_create,gmt_update);
                // 封装成集合
                informationList .add(information);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(rs,ps,conn);
        }
        return informationList;
    }

    /**
     * 获取全部资讯的数量
     * @return java.lang.Integer
     */
    @Override
    public Integer getInformationCount() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "select count(*)from tb_information where is_delete=0;";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 执行sql对象
            rs = ps.executeQuery();
            // 获取结果
            count = rs.getInt("count");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(rs,ps,conn);
        }
        return count;
    }
}
