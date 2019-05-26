package com.sc.dao;

import com.sc.domain.SClass;

import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/26 19:14
 */
public interface IClassDao {
    List<SClass> getAllSClass();
    SClass getSClass(String id);
    int insertSClass(SClass sClass);
    int updateSClass(SClass sClass);
    int deleteSClass(String id);
}
