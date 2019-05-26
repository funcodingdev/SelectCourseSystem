package com.sc.dao;

import com.sc.domain.Department;

import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/26 19:17
 */
public interface IDepartmentDao {
    List<Department> getAllDepartment();
    Department getDepartment(String id);
    int insertDepartment(Department department);
    int updateDepartment(Department department);
    int deleteDepartment(String id);
}
