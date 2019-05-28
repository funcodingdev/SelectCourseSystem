package com.sc.service;

import com.sc.domain.SClass;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: fangju
 * @Date: 2019/5/28 11:44
 */
public interface ISClassService {
    List<SClass> getAllSClass(String department);
}
