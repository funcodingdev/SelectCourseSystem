package com.sc.dao;

import com.sc.domain.Admin;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:40
 */
public interface IAdminDao {
    List<Admin> getAllAdmin() throws SQLException;//获取所有的管理员
    Admin getAdmin(String id) throws SQLException;//获取某个管理员
    int insertAdmin(Admin admin) throws SQLException;//添加管理员
    int updateAdmin(Admin admin) throws SQLException;//修改管理员
    int deleteAdmin(String id) throws SQLException;//删除管理员
    boolean findAdmin(String username,String password) throws SQLException;//查询是否存在该管理员
}
