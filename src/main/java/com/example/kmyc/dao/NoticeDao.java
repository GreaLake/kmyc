package com.example.kmyc.dao;

import com.example.kmyc.domain.Notice;

import java.util.List;

/**
 * 公告物理层
 */
public interface NoticeDao {

    /**
     * 添加公告
     * @param content 公告内容
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    public Integer insertNotice(String content ,Long inputer);

    /**
     * 更新公告
     * @param id 公告编号
     * @param content 公告内容
     * @return java.lang.Integer
     */
    public Integer updateNotice(Long id, String content);

    /**
     * 删除公告
     * @param id 公告编号
     * @return java.lang.Integer
     */
    public Integer deleteNotice(Long id);

    /**
     * 获取全部公告
     * @return java.util.List
     */
    public List<Notice> listNotice();

}
