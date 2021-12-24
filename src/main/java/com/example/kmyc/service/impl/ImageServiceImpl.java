package com.example.kmyc.service.impl;

import com.example.kmyc.dao.ImageDao;
import com.example.kmyc.dao.impl.ImageDaoImpl;
import com.example.kmyc.domain.Image;
import com.example.kmyc.service.ImageService;

import java.util.List;

/**
 * 图片表实现类
 */
public class ImageServiceImpl implements ImageService {

    private ImageDao imageDao = new ImageDaoImpl();

    /**
     * 添加图片
     * @param name 图片名
     * @param path 图片路径
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertImage(String name, String path, Long inputer) {
        Boolean flag = false;
        Integer count = imageDao.insertImage(name, path, inputer);
        if(1 == count){
            flag =true;
        }
        return flag;
    }

    /**
     * 更新图片
     * @param id 图片编号
     * @param name 图片名
     * @param path 图片路径
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateImage(Long id, String name, String path) {
        Boolean flag = false;
        Integer count = imageDao.updateImage(id,name, path);
        if(1 == count){
            flag =true;
        }
        return flag;
    }

    /**
     * 删除图片
     * @param id 图片
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteImage(Long id) {
        Boolean flag = false;
        Integer count = imageDao.deleteImage(id);
        if(1 == count){
            flag =true;
        }
        return flag;
    }

    /**
     * 获取全部图片
     * @return java.util.List
     */
    @Override
    public List<Image> listImage() {
        List<Image> images = imageDao.listImage();
        return images;
    }
}
