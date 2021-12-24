package com.example.kmyc.dao;

import com.example.kmyc.domain.Story;

import java.util.List;

/**
 * 故事物理层
 */
public interface StoryDao {

    /**
     * 添加故事
     * @param title 故事标题
     * @param content 故事内容
     * @param inputer 录入者
     * @return java.lang.Integer
     */
    public Integer insertStory(String title, String content, Long inputer,Long image);

    /**
     * 更新故事
     * @param id 故事编号
     * @param title 故事标题
     * @param content 故事内容
     * @return java.lang.Integer
     */
    public Integer updateStory(Long id, String title, String content);

    /**
     * 删除故事
     * @param id 故事编号
     * @return java.lang.Integer
     */
    public Integer deleteStory(Long id);

    /**
     * 通过页数获取数据
     * @param start 从第几个数据开始
     * @param size 获取几个数据
     * @return java.util.List
     */
    public List<Story> listStoryByPage(Integer start, Integer size);

    /**
     * 获取全部故事数量
     * @return java.lang.Integer
     */
    public Integer storyCount();
}
