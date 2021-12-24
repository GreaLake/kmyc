package com.example.kmyc.domain;

import java.util.Date;

/**
 * 烈士表实体类
 */
public class Hero {

    /**
     * 烈士编号
     */
    private Long id;

    /**
     * 烈士姓名
     */
    private String name;

    /**
     * 烈士性别
     */
    private String sex;

    /**
     * 烈士政治面貌
     */
    private String politic;

    /**
     * 烈士所属部队
     */
    private String troop;

    /**
     * 烈士职务
     */
    private String post;

    /**
     * 烈士所属籍贯地区编号
     */
    private Long region;

    /**
     * 烈士出生日期
     */
    private Date gmtBorn;

    /**
     * 烈士牺牲日期
     */
    private Date gmtSacrifice;

    /**
     * 轮播图录入者
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPolitic() {
        return politic;
    }

    public void setPolitic(String politic) {
        this.politic = politic;
    }

    public String getTroop() {
        return troop;
    }

    public void setTroop(String troop) {
        this.troop = troop;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long region) {
        this.region = region;
    }

    public Date getGmtBorn() {
        return gmtBorn;
    }

    public void setGmtBorn(Date gmtBorn) {
        this.gmtBorn = gmtBorn;
    }

    public Date getGmtSacrifice() {
        return gmtSacrifice;
    }

    public void setGmtSacrifice(Date gmtSacrifice) {
        this.gmtSacrifice = gmtSacrifice;
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
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", politic='" + politic + '\'' +
                ", troop='" + troop + '\'' +
                ", post='" + post + '\'' +
                ", region=" + region +
                ", gmtBorn=" + gmtBorn +
                ", gmtSacrifice=" + gmtSacrifice +
                ", inputer=" + inputer +
                ", isDelete=" + isDelete +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }

    public Hero(Long id, String name, String sex, String politic, String troop, String post, Long region, Date gmtBorn, Date gmtSacrifice, Long inputer, Boolean isDelete, Date gmtCreate, Date gmtUpdate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.politic = politic;
        this.troop = troop;
        this.post = post;
        this.region = region;
        this.gmtBorn = gmtBorn;
        this.gmtSacrifice = gmtSacrifice;
        this.inputer = inputer;
        this.isDelete = isDelete;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
    }
}
