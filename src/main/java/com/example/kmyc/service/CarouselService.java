package com.example.kmyc.service;

import com.example.kmyc.domain.Carousel;

import java.util.List;

/**
 * 轮播图业务层
 */
public interface CarouselService {

    /**
     * 添加轮播图
     * @param name 轮播图名
     * @param group 轮播图组
     * @param image 轮播图图片编号
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    public Boolean insertCarousel(String name,String group,Long image,Long inputer);

    /**
     * 更新轮播图
     * @param id 轮播图编号
     * @param name 轮播图名
     * @param group 轮播图组
     * @param image 轮播图图片编号
     * @return java.lang.Boolean
     */
    public Boolean updateCarousel(Long id,String name,String group,Long image);

    /**
     * 删除轮播图
     * @param id 轮播图编号
     * @return java.lang.Boolean
     */
    public Boolean deleteCarousel(Long id);

    /**
     * 根据组获取轮播图
     * @param group 组名
     * @return java.util.List
     */
    public List<Carousel> listCarouselByGroup(String group);
}
