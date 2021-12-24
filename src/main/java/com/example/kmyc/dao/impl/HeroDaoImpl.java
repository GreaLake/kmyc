package com.example.kmyc.dao.impl;

import com.example.kmyc.dao.HeroDao;
import com.example.kmyc.domain.Hero;
import com.example.kmyc.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 烈士物理层实现类
 */
public class HeroDaoImpl implements HeroDao {

    /**
     * 添加烈士
     * @param name 烈士姓名
     * @param sex 烈士性别
     * @param politic 烈士政治面貌
     * @param troop 烈士所属部队
     * @param post 烈士职务
     * @param region 烈士所属籍贯编号
     * @param born 烈士出生日期
     * @param sacrifice 烈士牺牲日期
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    @Override
    public Integer insertHero(String name, String sex, String politic, String troop, String post,
                           Long region, Date born, Date sacrifice, Long inputer) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "insert tb_hero (name,sex,politic,troop,post,region,born,sacrifice,inputer) values (?,?,?,?,?,?,?,?,?)";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setString(2,sex);
            ps.setString(3,politic);
            ps.setString(4,troop);
            ps.setString(5,post);
            ps.setLong(6,region);
            ps.setDate(7, (java.sql.Date) born);
            ps.setDate(8, (java.sql.Date) sacrifice);
            ps.setLong(9,inputer);
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
     * 更新烈士
     * @param id 烈士编号
     * @param name 烈士姓名
     * @param sex 烈士性别
     * @param politic 烈士政治面貌
     * @param troop 烈士所属部队
     * @param post 烈士职务
     * @param region 烈士所属籍贯编号
     * @param born 烈士出生日期
     * @param sacrifice 烈士牺牲日期
     * @return
     */
    @Override
    public Integer updateHero(Long id, String name, String sex, String politic, String troop, String post,
                              Long region, Date born, Date sacrifice) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_hero set name= ? ,sex= ?,politic= ?,troop= ?,post=?,region=?,bron=?,sacrifice=? where id=? ";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setString(1,name);
            ps.setString(2,sex);
            ps.setString(3,politic);
            ps.setString(4,troop);
            ps.setString(5,post);
            ps.setLong(6,region);
            ps.setDate(7, (java.sql.Date) born);
            ps.setDate(8, (java.sql.Date) sacrifice);
            ps.setLong(9,id);
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
     * 删除
     * @param id 编号
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteHero(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "update tb_hero set is_delete=1 where id=? ";
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
     * 根据条件获取烈士信息
     * @param id
     * @return
     */
    @Override
    public List<Hero> listHero(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Hero> heroList = new ArrayList<>();
        try {
            // 获取连接
            conn = DruidUtils.getConnection();
            // 定义sql语句
            String sql = "select name,sex,politic,troop,post,region,bron,sacrifice from tb_hero where id=? ";
            // 获取sql语句的执行对象
            ps = conn.prepareStatement(sql);
            // 设置字段
            ps.setLong(1,id);
            // 执行sql对象
            rs = ps.executeQuery();
            // 获取结果
            while (rs.next()){
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String politic = rs.getString("politic");
                String troop = rs.getString("troop");
                String post = rs.getString("post");
                long region = rs.getLong("region");
                java.sql.Date born = rs.getDate("born");
                java.sql.Date sacrifice = rs.getDate("sacrifice");
                // 封装成对象
                Hero hero = new Hero(id,name,sex,politic,troop,post,region,born,sacrifice,0L,false,null,null);
                // 封装成集合
                heroList.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(ps,conn);
        }
        return heroList;
    }
}
