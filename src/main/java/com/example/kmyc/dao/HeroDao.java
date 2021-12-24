package com.example.kmyc.dao;

import com.example.kmyc.domain.Hero;

import java.util.Date;
import java.util.List;

/**
 * 烈士物理层
 */
public interface HeroDao {
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
    public Integer insertHero(String name, String sex, String politic, String troop, String post,
                           Long region, Date born , Date sacrifice, Long inputer);


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
     * @return java.lang.Integer
     */
    public Integer updateHero(Long id, String name, String sex, String politic, String troop, String post,
                              Long region, Date born ,Date sacrifice);

    /**
     * 删除
     * @param id 编号
     * @return java.lang.Integer
     */
    public Integer deleteHero(Long id);

    /**
     * 根据查询烈士
     * @param id
     * @return java.util.List
     */
    public List<Hero> listHero(Long id);
}
