package com.example.kmyc.service;

import com.example.kmyc.domain.Page;
import com.example.kmyc.domain.Story;

import java.util.List;

/**
 * 故事表业务层
 */
public interface StoryService {

    /**
     * 添加故事
     * @param title 故事标题
     * @param content 故事内容
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    public Boolean insertStory(String title, String content, Long inputer, Long iamge);

    /**
     * 更新故事
     * @param id 故事编号
     * @param title 故事标题
     * @param content 故事内容
     * @return java.lang.Boolean
     */
    public Boolean updateStory(Long id, String title, String content);

    /**
     * 删除故事
     * @param id 故事编号
     * @return java.lang.Boolean
     */
    public Boolean deleteStory(Long id);

    /**
     * 通过页数获取数据
     * @param page 第几页
     * @param size 一页的数据大小
     * @return java.util.List
     */
    public Page<Story> listStoryByPage(Integer page, Integer size);
}
