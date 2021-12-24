package com.example.kmyc.service;

import com.example.kmyc.domain.Information;
import com.example.kmyc.domain.Page;

import java.util.List;

/**
 * 资讯业务层
 */
public interface InformationService {

    /**
     * 添加资讯
     * @param title 资讯标题
     * @param content 资讯内容
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    public Boolean insertInformation(String title,String content,Long inputer);

    /**
     * 更新资讯
     * @param id 资讯编号
     * @param title 资讯标题
     * @param content 资讯内容
     * @return java.lang.Boolean
     */
    public Boolean updateInformation(Long id ,String title, String content);

    /**
     * 删除资讯
     * @param id 资讯编号
     * @return java.lang.Boolean
     */
    public Boolean deleteInformation(Long id);

    /**
     * 通过分页查询资讯
     * @param page 第几页
     * @param size 一页的数据大小
     * @return java.util.List
     */
    public Page<Information> listInformationByPage(Integer page, Integer size);
}
