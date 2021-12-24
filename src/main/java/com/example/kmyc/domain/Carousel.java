package com.example.kmyc.domain;

import java.util.Date;

/**
 * 轮播图实体类
 */
public class Carousel {

    /**
     * 轮播图编号
     */
    private Long id;

    /**
     * 轮播图名
     */
    private String name;

    /**
     * 轮播图所属组
     */
    private String group;

    /**
     * 轮播图图片编号
     */
    private Long image;

    /**
     * 录入者
     */
    private Long inputer;

    /**
     * 逻辑删除
     */
    private Boolean isDelete;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Long getImage() {
        return image;
    }

    public void setImage(Long image) {
        this.image = image;
    }

    public Long getInputer() {
        return inputer;
    }

    public void setInputer(Long inputer) {
        this.inputer = inputer;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", image=" + image +
                ", inputer=" + inputer +
                ", isDelete=" + isDelete +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }

    public Carousel(Long id, String name, String group, Long image, Long inputer, Boolean isDelete, Date gmtCreate, Date gmtUpdate) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.image = image;
        this.inputer = inputer;
        this.isDelete = isDelete;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
    }
}
