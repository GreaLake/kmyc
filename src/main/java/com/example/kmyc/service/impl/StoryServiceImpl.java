package com.example.kmyc.service.impl;

import com.example.kmyc.dao.StoryDao;
import com.example.kmyc.dao.impl.StoryDaoImpl;
import com.example.kmyc.domain.Page;
import com.example.kmyc.domain.Story;
import com.example.kmyc.service.StoryService;

import java.util.List;

/**
 * 故事业务层实现类
 */
public class StoryServiceImpl implements StoryService {

    private StoryDao storyDao = new StoryDaoImpl();

    /**
     * 添加数据
     * @param title 故事标题
     * @param content 故事内容
     * @param inputer 录入者
     * @return java.lang.Boolean
     */
    @Override
    public Boolean insertStory(String title, String content, Long inputer,Long image) {
        Integer count = storyDao.insertStory(title, content, inputer,image);
        Boolean flag =false;
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 更新数据
     * @param id 故事编号
     * @param title 故事标题
     * @param content 故事内容
     * @return java.lang.Boolean
     */
    @Override
    public Boolean updateStory(Long id, String title, String content) {
        Integer count = storyDao.updateStory(id,title,content);
        Boolean flag =false;
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 删除数据
     * @param id 故事编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteStory(Long id) {
        Integer count = storyDao.deleteStory(id);
        Boolean flag =false;
        if (1 == count){
            flag = true;
        }
        return flag;
    }

    /**
     * 根据页数获取数据
     * @param page 第几页
     * @param size 一页的数据大小
     * @return java.util.List
     */
    @Override
    public Page<Story> listStoryByPage(Integer page, Integer size) {
        Integer count = storyDao.storyCount();
        int start = (count - 1) * size;
        List<Story> stories = storyDao.listStoryByPage(start, size);
        Page<Story> storyPage = new Page<>(count, page, size, stories);
        return storyPage;
    }
}
