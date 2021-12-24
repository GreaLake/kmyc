package com.example.kmyc.dao.impl;

import com.example.kmyc.dao.ImageDao;
import com.example.kmyc.domain.Image;
import com.example.kmyc.utils.DruidUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片物理层实现类
 */
public class ImageDaoImpl implements ImageDao {

    /**
     * 添加图片
     * @param name 图片名
     * @param path 图片路径
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    @Override
    public Integer insertImage(String name, String path, Long inputer) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "insert tb_image (name,path,inputer) values (?,?,?)";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setString(2,path);
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
     * 更新图片
     * @param id 图片编号
     * @param name 图片名
     * @param path 图片路径
     * @return java.lang.Integer
     */
    @Override
    public Integer updateImage(Long id, String name, String path) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_image set name=?,path=? where id =?";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setString(2,path);
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
     * 删除图片
     * @param id 图片
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteImage(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_image set is_delete=0 where id=?";
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
     * 获取全部图片
     * @return java.util.List
     */
    @Override
    public List<Image> listImage() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Image> imageList = new ArrayList<>();
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "select id,name,path,inputer,is_delete,gmt_create,gmt_update from tb_image";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 执行sql对象
            rs = ps.executeQuery();
            // 获取结果
            while (rs.next()){
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String path = rs.getString("path");
                long inputer = rs.getLong("inputer");
                boolean is_delete = rs.getBoolean("is_delete");
                Date gmt_create = rs.getDate("gmt_create");
                Date gmt_update = rs.getDate("gmt_update");
                // 封装成对象
                Image image = new Image(id,name,path,inputer,is_delete,gmt_create,gmt_update);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(rs,ps,conn);
        }
        return imageList;
    }
}
