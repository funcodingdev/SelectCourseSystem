package com.sc.dao.impl;

import com.sc.dao.ISClassDao;
import com.sc.domain.SClass;
import com.sc.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 11:45
 */
public class SClassDaoImpl implements ISClassDao {
    @Override
    public List<SClass> getAllSClass(String department) throws SQLException {
        List<SClass> sClassList = null;
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "select * from sclass where s_dept_name = ?";
        conn = JDBCUtil.getConn();
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,department);
        psmt.execute();
        rs = psmt.getResultSet();
        sClassList = new ArrayList<>();
        while (rs.next()){
            SClass sClass = new SClass();
            sClass.setName(rs.getString("s_name"));
            sClass.setDeptName(rs.getString("s_dept_name"));
            sClass.setTotalNum(rs.getInt("s_totalNum"));
            sClassList.add(sClass);
        }
        JDBCUtil.closeConn(conn,psmt,rs);
        return sClassList;
    }
}
