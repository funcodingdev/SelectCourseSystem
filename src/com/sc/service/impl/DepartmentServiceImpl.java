package com.sc.service.impl;

import com.sc.dao.DaoFactory;
import com.sc.dao.IDepartmentDao;
import com.sc.domain.Department;
import com.sc.service.IDepartmentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 11:19
 */
public class DepartmentServiceImpl implements IDepartmentService {
    private IDepartmentDao departmentDao;

    @Override
    public List<Department> getAllDepartment() {
        departmentDao = DaoFactory.getDepartmentDao();
        try {
            return departmentDao.getAllDepartment();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Department getDepartment(String id) {
        return null;
    }

    @Override
    public boolean insertDepartment(Department department) {
        return false;
    }

    @Override
    public boolean updateDepartment(Department department) {
        return false;
    }

    @Override
    public boolean deleteDepartment(String id) {
        return false;
    }
}
