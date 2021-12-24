package com.example.kmyc.dao;

import com.example.kmyc.domain.Region;

import java.util.List;

/**
 * 地区物理层
 */
public interface RegionDao {

    /**
     * 添加地区
     * @param name 地区名
     * @param father 上级地区编号
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    public Integer addRegion(String name, Long father, Long inputer);

    /**
     * 更新地区
     * @param id 地区编号
     * @param name 地区名
     * @param father 上级地区编号
     * @return java.lang.Integer
     */
    public Integer updateRegion(Long id , String name, Long father);

    /**
     * 删除地区
     * @param id 地区编号
     * @return java.lang.Integer
     */
    public Integer deleteRegion(Long id);

    /**
     * 通过上级地区获取下级地区
     * @param father 上级地区编号
     * @return java.util.List
     */
    public List<Region> listRegionByFather(Long father);

}
