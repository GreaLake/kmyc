package com.example.kmyc.dao.impl;

import com.example.kmyc.dao.NoticeDao;
import com.example.kmyc.domain.Notice;
import com.example.kmyc.utils.DruidUtils;

import java.sql.*;
import java.util.List;

/**
 * 公告物理层实现类
 */
public class NoticeDaoImpl implements NoticeDao {

    /**
     * 添加公告
     * @param content 公告内容
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    @Override
    public Integer insertNotice(String content, Long inputer) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "insert tb_notice(content,inputer) values (?,?)";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,content);
            ps.setLong(2,inputer);
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
     * 更新公告
     * @param id 公告编号
     * @param content 公告内容
     * @return java.lang.Integer
     */
    @Override
    public Integer updateNotice(Long id, String content) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_notice set content = ? where id =?";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,content);
            ps.setLong(2,id);
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
     * 删除公告
     * @param id 公告编号
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteNotice(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_notice set is_delete=1 where id=?";
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
     * 获取全部公告
     * @return java.util.List
     */
    @Override
    public List<Notice> listNotice() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Notice> noticeList = null;
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
                String content = rs.getString("content");
                long inputer = rs.getLong("inputer");
                boolean is_delete = rs.getBoolean("is_delete");
                Date gmt_create = rs.getDate("gmt_create");
                Date gmt_update = rs.getDate("gmt_update");
                // 封装成对象
                Notice notice = new Notice(id,content,inputer,is_delete,gmt_create,gmt_update);
                // 封装成集合
                noticeList.add(notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(rs,ps,conn);
        }
        return noticeList;
    }
}
