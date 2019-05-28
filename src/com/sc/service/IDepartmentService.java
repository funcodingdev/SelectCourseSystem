package com.sc.service;

import com.sc.domain.Department;

import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/26 19:17
 */
public interface IDepartmentService {
    List<Department> getAllDepartment();
    Department getDepartment(String id);
    boolean insertDepartment(Department department);
    boolean updateDepartment(Department department);
    boolean deleteDepartment(String id);
}
