package com.example.kmyc.service;

import com.example.kmyc.domain.Admin;

import java.util.List;

/**
 * 管理员业务层
 */
public interface AdminService {

    /**
     * 管理员注册
     * @param name 管理员用户名
     * @param password 管理员密码
     * @return java.lang.Boolean
     */
    public Boolean adminRegister(String name,String password);

    /**
     * 管理员登录
     * @param name 管理员用户名
     * @param password 管理员面貌
     * @return java.lang.Boolean
     */
    public Boolean adminLogin(String name ,String password);

    /**
     * 管理员删除
     * @param id 管理员编号
     * @return java.lang.Boolean
     */
    public Boolean deleteAdmin(Long id);

    /**
     * 管理员恢复
     * @param id 管理员编号
     * @return java.lang.Boolean
     */
    public Boolean recoverAdmin(Long id);

    /**
     * 管理员修改权限
     * @param id 管理员编号
     * @param role 管理员权限
     * @return java.lang.Boolean
     */
    public Boolean adminUpdateRole(Long id,String role);

    /**
     * 管理员修改密码
     * @param id 管理员编号
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return java.lang.Boolean
     */
    public Boolean adminUpdatePassword(Long id,String oldPassword,String newPassword);

    /**
     * 获取全部管理员数据
     * @return java.util.List
     */
    public List<Admin> listAdmin();
}
