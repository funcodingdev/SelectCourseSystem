package com.sc.dao.impl;

import com.sc.dao.IDepartmentDao;
import com.sc.domain.Department;
import com.sc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 11:10
 */
public class DepartmentDaoImpl implements IDepartmentDao {
    @Override
    public List<Department> getAllDepartment() throws SQLException {
        List<Department> departmentList = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from department";
        conn = JDBCUtil.getConn();
        st = conn.createStatement();
        st.execute(sql);
        rs = st.getResultSet();
        departmentList = new ArrayList<>();
        while (rs.next()) {
            Department department = new Department();
            department.setId(rs.getString("d_id"));
            department.setName(rs.getString("d_name"));
            departmentList.add(department);
        }
        JDBCUtil.closeConn(conn, st, rs);
        return departmentList;
    }

    @Override
    public Department getDepartment(String id) throws SQLException {
        return null;
    }

    @Override
    public int insertDepartment(Department department) throws SQLException {
        return 0;
    }

    @Override
    public int updateDepartment(Department department) throws SQLException {
        return 0;
    }

    @Override
    public int deleteDepartment(String id) throws SQLException {
        return 0;
    }
}
