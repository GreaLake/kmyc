package com.example.kmyc.service.impl;

import com.example.kmyc.dao.RegionDao;
import com.example.kmyc.dao.impl.RegionDaoImpl;
import com.example.kmyc.domain.Region;
import com.example.kmyc.service.RegionService;

import java.util.List;

/**
 * 地区业务层实现类
 */
public class RegionServiceImpl implements RegionService {

    private RegionDao regionDao = new RegionDaoImpl();

    /**
     * 添加地区
     * @param name 地区名
     * @param father 上级地区编号
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertRegion(String name, Long father, Long inputer) {
        Integer count = regionDao.addRegion(name, father, inputer);
        Boolean flag = false;
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 更新地区
     * @param id 地区编号
     * @param name 地区名
     * @param father 上级地区编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateRegion(Long id, String name, Long father) {
        Integer count = regionDao.updateRegion(id,name, father);
        Boolean flag = false;
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 删除地区
     * @param id 地区编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteRegion(Long id) {
        Integer count = regionDao.deleteRegion(id);
        Boolean flag = false;
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 根据上级地区编号获取下级地区
     * @param father 上级地区编号
     * @return java.util.List
     */
    @Override
    public List<Region> listRegionByFather(Long father) {
        List<Region> regions = regionDao.listRegionByFather(father);
        return regions;
    }
}
