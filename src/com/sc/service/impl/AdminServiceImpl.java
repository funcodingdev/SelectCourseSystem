package com.sc.service.impl;

import com.sc.dao.DaoFactory;
import com.sc.dao.IAdminDao;
import com.sc.domain.Admin;
import com.sc.service.IAdminService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/25 15:45
 */
public class AdminServiceImpl implements IAdminService {
    private IAdminDao adminDao;

    @Override
    public List<Admin> getAllAdmin() {
        adminDao = DaoFactory.getAdminDao();
        try {
            return adminDao.getAllAdmin();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Admin getAdmin(String id) {
        adminDao = DaoFactory.getAdminDao();
        try {
            return adminDao.getAdmin(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertAdmin(Admin admin) {
        adminDao = DaoFactory.getAdminDao();
        try {
            if (adminDao.insertAdmin(admin) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        adminDao = DaoFactory.getAdminDao();
        try {
            if (adminDao.updateAdmin(admin) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAdmin(String id) {
        adminDao = DaoFactory.getAdminDao();
        try {
            if (adminDao.deleteAdmin(id) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean findAdmin(String username, String password) {
        adminDao = DaoFactory.getAdminDao();
        try {
            return adminDao.findAdmin(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
