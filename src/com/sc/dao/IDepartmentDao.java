package com.sc.dao;

import com.sc.domain.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/26 19:17
 */
public interface IDepartmentDao {
    List<Department> getAllDepartment() throws SQLException;

    Department getDepartment(String id) throws SQLException;

    int insertDepartment(Department department) throws SQLException;

    int updateDepartment(Department department) throws SQLException;

    int deleteDepartment(String id) throws SQLException;
}
