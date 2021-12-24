package com.example.kmyc.domain;

import java.util.Date;

/**
 * 图片实体类
 */
public class Image {
    public Image(Long id, String name, String path, Long inputer, Boolean isDelete, Date gmtCreate, Date gmtUpdate) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.inputer = inputer;
        this.isDelete = isDelete;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
    }

    /**
     * 图片编号
     */
    private Long id;

    /**
     * 图片名
     */
    private String name;

    /**
     * 图片路径
     */
    private String path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", inputer=" + inputer +
                ", isDelete=" + isDelete +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }
}
