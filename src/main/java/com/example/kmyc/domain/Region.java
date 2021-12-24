package com.example.kmyc.domain;

import java.util.Date;

/**
 * 地区表实体类
 */
public class Region {
    public Region(Long id, String name, Long father, Long inputer, Boolean isDelete, Date gmtCreate, Date gmtUpdate) {
        this.id = id;
        this.name = name;
        this.father = father;
        this.inputer = inputer;
        this.isDelete = isDelete;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
    }

    /**
     * 地区编号
     */
    private Long id;

    /**
     * 地区名
     */
    private String name;

    /**
     * 该地区的上一等级的地区
     */
    private Long father;

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

    public Long getFather() {
        return father;
    }

    public void setFather(Long father) {
        this.father = father;
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
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", father=" + father +
                ", inputer=" + inputer +
                ", isDelete=" + isDelete +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }
}
