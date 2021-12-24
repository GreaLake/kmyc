package com.example.kmyc.dao.impl;

import com.example.kmyc.dao.StoryDao;
import com.example.kmyc.domain.Story;
import com.example.kmyc.utils.DruidUtils;

import java.sql.*;
import java.util.List;

/**
 * 故事物理层实现类
 */
public class StoryDaoImpl implements StoryDao {

    /**
     * 添加故事
     * @param title 故事标题
     * @param content 故事内容
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    @Override
    public Integer insertStory(String title, String content, Long inputer,Long image) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "insert tb_story(title,content,inputer,image)values (?,?,?,?)";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,title);
            ps.setString(2,content);
            ps.setLong(3,inputer);
            ps.setLong(4,image);
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
     * 更新故事
     * @param id 故事编号
     * @param title 故事标题
     * @param content 故事内容
     * @return java.lang.Integer
     */
    @Override
    public Integer updateStory(Long id, String title, String content) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_story set title = ? ,content= ? where id =?";
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
     * 删除故事
     * @param id 故事编号
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteStory(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_story set is_delete=1 where id=?";
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
     * 根据页获取故事数据
     * @param start 从第几个数据开始
     * @param size 获取几个数据
     * @return java.util.List
     */
    @Override
    public List<Story> listStoryByPage(Integer start, Integer size) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Story> storyList = null;
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
                Long image = rs.getLong("image");
                long inputer = rs.getLong("inputer");
                boolean is_delete = rs.getBoolean("is_delete");
                Date gmt_create = rs.getDate("gmt_create");
                Date gmt_update = rs.getDate("gmt_update");
                // 封装成对象
                Story story = new Story(id,title,content,image,inputer,is_delete,gmt_create,gmt_update);
                // 封装成集合
                storyList.add(story);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(rs,ps,conn);
        }
        return storyList;
    }

    /**
     * 获取全部故事数量
     * @return java.lang.Integer
     */
    @Override
    public Integer storyCount() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "select count(*) from tb_story where is_delete=0;";
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
