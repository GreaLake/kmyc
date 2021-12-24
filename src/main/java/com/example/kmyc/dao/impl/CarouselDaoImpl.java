package com.example.kmyc.dao.impl;

import com.example.kmyc.dao.CarouselDao;
import com.example.kmyc.domain.Carousel;
import com.example.kmyc.utils.DruidUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 轮播图物理层实现类
 */
public class CarouselDaoImpl implements CarouselDao {

    /**
     * 添加轮播图
     * @param name 轮播图名
     * @param group 轮播图组
     * @param image 轮播图图片编号
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    @Override
    public Integer insertCarousel(String name, String group, Long image, Long inputer) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "insert tb_carousel(name,group,image,inputer)values(?,?,?,?)";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setString(2,group);
            ps.setLong(3,image);
            ps.setLong(4,inputer);
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
     * 更新轮播图
     * @param id 轮播图编号
     * @param name 轮播图名
     * @param group 轮播图组
     * @param image 轮播图图片编号
     * @return java.lang.Integer
     */
    @Override
    public Integer updateCarousel(Long id, String name, String group, Long image) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_carousel set name = ?,group = ?, image = ? where id =?";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setString(2,group);
            ps.setLong(3,image);
            ps.setLong(4,id);
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
     * 删除轮播图
     * @param id 轮播图编号
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteCarousel(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_carousel set is_delete where id =?";
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
     * 根据组获取轮播图
     * @param group 组名
     * @return java.util.List
     */
    @Override
    public List<Carousel> listCarouselByGroup(String group) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Carousel> carousels = new ArrayList<>();
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "select id,name,image,inputer,gmt_create,gmt_update from tb_carousel where group =? and is_delete=0";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,group);
            // 执行sql语句
            rs = ps.executeQuery();
            // 查询结果
            while (rs.next()){
                long id = rs.getLong("id");
                String name = rs.getString("name");
                long image = rs.getLong("image");
                long inputer = rs.getLong("inputer");
                Date gmt_create = rs.getDate("gmt_create");
                Date gmt_update = rs.getDate("gmt_update");
                // 封装对象
                Carousel carousel = new Carousel(id,name,group,image,inputer,false,gmt_create,gmt_update);
                // 封装成集合
                carousels.add(carousel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(rs,ps,conn);
        }
        return carousels;
    }
}
