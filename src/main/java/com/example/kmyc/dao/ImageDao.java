package com.example.kmyc.dao;

import com.example.kmyc.domain.Image;

import java.util.List;

/**
 * 图片物理层
 */
public interface ImageDao {

    /**
     * 添加图片
     * @param name 图片名
     * @param path 图片路径
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    public Integer insertImage(String name,String path,Long inputer);

    /**
     * 更新图片
     * @param id 图片编号
     * @param name 图片名
     * @param path 图片路径
     * @return java.lang.Integer
     */
    public Integer updateImage(Long id,String name,String path);

    /**
     * 删除图片
     * @param id 图片
     * @return java.lang.Integer
     */
    public Integer deleteImage(Long id);

    /**
     * 获取全部图片
     * @return java.util.List
     */
    public List<Image> listImage();

}
