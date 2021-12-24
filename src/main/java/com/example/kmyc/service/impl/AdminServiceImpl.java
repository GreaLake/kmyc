package com.example.kmyc.service.impl;

import com.example.kmyc.dao.AdminDao;
import com.example.kmyc.dao.impl.AdminDaoImpl;
import com.example.kmyc.domain.Admin;
import com.example.kmyc.result.Result;
import com.example.kmyc.service.AdminService;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理员业务层实现类
 */
public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    /**
     * 注册
     * @param name 管理员用户名
     * @param password 管理员密码
     * @return java.lang.Boolean
     */
    @Override
    public Boolean adminRegister(String name, String password) {
        return adminDao.insertAdmin(name,password) == 1 ;
    }

    /**
     * 登录
     * @param name 管理员用户名
     * @param password 管理员面貌
     * @return java.lang.Boolean
     */
    @Override
    public Boolean adminLogin(String name, String password) {
        return adminDao.countAdmin(name, password) == 1;
    }

    /**
     * 删除管理员
     * @param id 管理员编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean deleteAdmin(Long id) {
        return adminDao.deleteAdmin(id) == 1;
    }

    /**
     * 恢复管理员
     * @param id 管理员编号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean recoverAdmin(Long id) {
        return adminDao.recoverAdmin(id) == 1;
    }

    /**
     * 更改管理员权限
     * @param id 管理员编号
     * @param role 管理员权限
     * @return java.lang.Boolean
     */
    @Override
    public Boolean adminUpdateRole(Long id, String role) {
        return adminDao.adminUpdateRole(id,role) == 1;
    }

    /**
     * 管理员修改密码
     * @param id 管理员编号
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return java.lang.Boolean
     */
    @Override
    public Boolean adminUpdatePassword(Long id, String oldPassword, String newPassword) {
        return adminDao.adminUpdatePassword(id,oldPassword,newPassword) == 1;
    }

    /**
     * 获取全部管理员信息
     * @return java.util.List
     */
    @Override
    public List<Admin> listAdmin() {
        return adminDao.listAdmin();
    }
}
