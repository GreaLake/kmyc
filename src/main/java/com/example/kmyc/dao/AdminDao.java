package com.example.kmyc.dao;

import com.example.kmyc.domain.Admin;

import java.util.List;

/**
 * 管理员物理层
 */
public interface AdminDao {
    /**
     * 添加管理员
     * @param name 管理员用户名
     * @param password 管理员密码
     * @return java.lang.Integer
     */
    public Integer insertAdmin(String name,String password);

    /**
     * 查询是否存在该管理员
     * @param name 管理员用户名
     * @param password 管理员面貌
     * @return java.lang.Integer
     */
    public Integer countAdmin(String name ,String password);

    /**
     * 管理员删除
     * @param id 管理员编号
     * @return java.lang.Integer
     */
    public Integer deleteAdmin(Long id);

    /**
     * 管理员恢复
     * @param id 管理员编号
     * @return java.lang.Integer
     */
    public Integer recoverAdmin(Long id);

    /**
     * 管理员修改权限
     * @param id 管理员编号
     * @param role 管理员权限
     * @return java.lang.Integer
     */
    public Integer adminUpdateRole(Long id,String role);

    /**
     * 管理员修改密码
     * @param id 管理员编号
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return java.lang.Integer
     */
    public Integer adminUpdatePassword(Long id,String oldPassword,String newPassword);

    /**
     * 获取全部管理员数据
     * @return java.util.List
     */
    public List<Admin> listAdmin();
}
