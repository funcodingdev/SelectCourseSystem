package com.sc.service.impl;

import com.sc.dao.DaoFactory;
import com.sc.dao.ISClassDao;
import com.sc.domain.SClass;
import com.sc.service.ISClassService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 11:54
 */
public class SClassServiceImpl implements ISClassService {
    private ISClassDao sClassDao;
    @Override
    public List<SClass> getAllSClass(String department) {
        sClassDao = DaoFactory.getSClassDao();
        try {
            return sClassDao.getAllSClass(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
