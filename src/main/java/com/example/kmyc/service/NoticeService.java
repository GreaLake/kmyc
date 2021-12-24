package com.example.kmyc.service;

import com.example.kmyc.domain.Notice;

import java.util.List;

/**
 * 公告业务层
 */
public interface NoticeService {

    /**
     * 添加公告
     * @param content 公告内容
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    public Boolean insertNotice(String content ,Long inputer);

    /**
     * 更新公告
     * @param id 公告编号
     * @param content 公告内容
     * @return java.lang.Boolean
     */
    public Boolean updateNotice(Long id, String content);

    /**
     * 删除公告
     * @param id 公告编号
     * @return java.lang.Boolean
     */
    public Boolean deleteNotice(Long id);

    /**
     * 获取全部公告
     * @return java.util.List
     */
    public List<Notice> listNotice();

}
