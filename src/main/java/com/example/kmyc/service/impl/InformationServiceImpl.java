package com.example.kmyc.service.impl;

import com.example.kmyc.dao.InformationDao;
import com.example.kmyc.dao.impl.InformationDaoImpl;
import com.example.kmyc.domain.Information;
import com.example.kmyc.domain.Page;
import com.example.kmyc.service.InformationService;

import java.util.List;

/**
 * 资讯业务层实现类
 */
public class InformationServiceImpl implements InformationService {

    private InformationDao informationDao = new InformationDaoImpl();

    /**
     * 添加资讯
     * @param title 资讯标题
     * @param content 资讯内容
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertInformation(String title, String content, Long inputer) {
        Boolean flag = false;
        Integer count = informationDao.insertInformation(title, content, inputer);
        if( 1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 更新资讯
     * @param id 资讯编号
     * @param title 资讯标题
     * @param content 资讯内容
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateInformation(Long id, String title, String content) {
        Boolean flag = false;
        Integer count = informationDao.updateInformation(id,title, content);
        if( 1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 删除资讯
     * @param id 资讯编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteInformation(Long id) {
        Boolean flag = false;
        Integer count = informationDao.deleteInformation(id);
        if( 1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 根据页数查询资讯
     * @param page 第几页
     * @param size 一页的数据大小
     * @return java.util.List
     */
    @Override
    public Page<Information> listInformationByPage(Integer page, Integer size) {
        Integer count = informationDao.getInformationCount();
        Integer start = (page - 1) * size;
        List<Information> informationList = informationDao.listInformationByPage(start,size);
        Page<Information> informationPage = new Page<>(count,page,size,informationList);
        return informationPage;
    }
}
