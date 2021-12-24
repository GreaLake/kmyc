package com.example.kmyc.service.impl;

import com.example.kmyc.dao.NoticeDao;
import com.example.kmyc.dao.impl.NoticeDaoImpl;
import com.example.kmyc.domain.Notice;
import com.example.kmyc.service.NoticeService;

import java.util.List;

/**
 * 公告业务层实现类
 */
public class NoticeServiceImpl implements NoticeService {

    private NoticeDao noticeDao = new NoticeDaoImpl();

    /**
     * 添加公告
     * @param content 公告内容
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertNotice(String content, Long inputer) {
        Integer count = noticeDao.insertNotice(content, inputer);
        boolean flag = false ;
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 更新公告
     * @param id 公告编号
     * @param content 公告内容
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateNotice(Long id, String content) {
        Integer count = noticeDao.updateNotice(id,content);
        boolean flag = false ;
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 删除公告
     * @param id 公告编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteNotice(Long id) {
        Integer count = noticeDao.deleteNotice(id);
        boolean flag = false ;
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 获取全部公告
     * @return java.util.List
     */
    @Override
    public List<Notice> listNotice() {
        List<Notice> notices = noticeDao.listNotice();
        return notices;
    }
}
