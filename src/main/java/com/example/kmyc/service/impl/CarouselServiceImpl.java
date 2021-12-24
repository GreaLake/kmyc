package com.example.kmyc.service.impl;

import com.example.kmyc.dao.CarouselDao;
import com.example.kmyc.dao.impl.CarouselDaoImpl;
import com.example.kmyc.domain.Carousel;
import com.example.kmyc.service.CarouselService;

import java.util.List;

/**
 * 轮播图业务层实现类
 */
public class CarouselServiceImpl implements CarouselService {

    private CarouselDao carouselDao = new CarouselDaoImpl();

    /**
     * 添加轮播图
     * @param name 轮播图名
     * @param group 轮播图组
     * @param image 轮播图图片编号
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertCarousel(String name, String group, Long image, Long inputer) {
        Boolean flag = false;
        Integer count = carouselDao.insertCarousel(name, group, image, inputer);
        if(1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 更新轮播图
     * @param id 轮播图编号
     * @param name 轮播图名
     * @param group 轮播图组
     * @param image 轮播图图片编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateCarousel(Long id, String name, String group, Long image) {
        Boolean flag = false;
        Integer count = carouselDao.updateCarousel(id,name,group,image);
        if(1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 删除轮播图
     * @param id 轮播图编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteCarousel(Long id) {
        Boolean flag = false;
        Integer count = carouselDao.deleteCarousel(id);
        if(1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 根据组获取轮播图
     * @param group 组名
     * @return java.util.List
     */
    @Override
    public List<Carousel> listCarouselByGroup(String group) {
        List<Carousel> carousels = carouselDao.listCarouselByGroup(group);
        return carousels;
    }
}
