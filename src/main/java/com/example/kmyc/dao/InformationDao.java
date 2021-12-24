package com.example.kmyc.dao;

import com.example.kmyc.domain.Information;

import java.util.List;

/**
 * 资讯物理层
 */
public interface InformationDao {

    /**
     * 添加资讯
     * @param title 资讯标题
     * @param content 资讯内容
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    public Integer insertInformation(String title,String content,Long inputer);

    /**
     * 更新资讯
     * @param id 资讯编号
     * @param title 资讯标题
     * @param content 资讯内容
     * @return java.lang.Integer
     */
    public Integer updateInformation(Long id ,String title, String content);

    /**
     * 删除资讯
     * @param id 资讯编号
     * @return java.lang.Integer
     */
    public Integer deleteInformation(Long id);

    /**
     * 通过分页查询资讯
     * @param start 从第几个数据开始
     * @param size 获取几个数据
     * @return java.util.List
     */
    public List<Information> listInformationByPage(Integer start, Integer size);

    /**
     * 获取全部资讯的数量
     * @return java.lang.Integer
     */
    public Integer getInformationCount();
}
