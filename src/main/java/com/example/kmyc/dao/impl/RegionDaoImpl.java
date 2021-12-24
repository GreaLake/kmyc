package com.example.kmyc.dao.impl;

import com.example.kmyc.dao.RegionDao;
import com.example.kmyc.domain.Notice;
import com.example.kmyc.domain.Region;
import com.example.kmyc.utils.DruidUtils;

import java.sql.*;
import java.util.List;

/**
 * 地区物理层实现类
 */
public class RegionDaoImpl implements RegionDao {

    /**
     * 添加地区
     * @param name 地区名
     * @param father 上级地区编号
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    @Override
    public Integer addRegion(String name, Long father, Long inputer) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "insert tb_region(name,father,inputer) values (?,?,?)";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setLong(2,father);
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
     * 更新地区
     * @param id 地区编号
     * @param name 地区名
     * @param father 上级地区编号
     * @return java.lang.Integer
     */
    @Override
    public Integer updateRegion(Long id, String name, Long father) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_region set name = ? ,father= ? where id =?";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setLong(2,father);
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
     * 删除地区
     * @param id 地区编号
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteRegion(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_region set is_delete=1 where id=?";
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
     * 根据上级地区获取下级地区
     * @param father 上级地区编号
     * @return java.util.List
     */
    @Override
    public List<Region> listRegionByFather(Long father) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Region> regionsList = null;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "select id,content,inputer,is_delete,gmt_create,gmt_update from tb_notice where is_delete=0;";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 执行sql对象
            rs = ps.executeQuery();
            // 获取结果
            while (rs.next()){
                long id = rs.getLong("id");
                String name = rs.getString("name");
                long inputer = rs.getLong("inputer");
                boolean is_delete = rs.getBoolean("is_delete");
                Date gmt_create = rs.getDate("gmt_create");
                Date gmt_update = rs.getDate("gmt_update");
                // 封装成对象
                Region region = new Region(id,name,father,inputer, is_delete, gmt_create, gmt_update);
                // 封装成集合
                regionsList.add(region);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(rs,ps,conn);
        }
        return regionsList;
    }
}
