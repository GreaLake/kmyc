package com.example.kmyc.service.impl;

import com.example.kmyc.dao.HeroDao;
import com.example.kmyc.dao.impl.HeroDaoImpl;
import com.example.kmyc.domain.Hero;
import com.example.kmyc.service.HeroService;

import java.util.Date;
import java.util.List;

/**
 * 烈士业务层实现类
 */
public class HeroServiceImpl implements HeroService {

    private HeroDao heroDao = new HeroDaoImpl();

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
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertHero(String name, String sex, String politic, String troop, String post,
                           Long region, Date born, Date sacrifice, Long inputer) {
        Boolean flag = false;
        Integer count = heroDao.insertHero(name, sex, politic, troop, post, region, born, sacrifice, inputer);
        if (1 == count){
            flag = true;
        }
        return flag;
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
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateHero(Long id, String name, String sex, String politic, String troop, String post,
                              Long region, Date born, Date sacrifice) {
        Boolean flag = false;
        Integer count = heroDao.updateHero(id,name, sex, politic, troop, post, region, born, sacrifice);
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 删除烈士
     * @param id 编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteHero(Long id) {
        Boolean flag = false;
        Integer count = heroDao.deleteHero(id);
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 根据条件查询烈士
     * @param id
     * @return
     */
    @Override
    public List<Hero> listHero(Long id) {
        List<Hero> heroes = heroDao.listHero(id);
        return heroes;
    }
}
