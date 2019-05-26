package com.sc.test;

import com.sc.dao.DaoFactory;
import com.sc.domain.Admin;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: fangju
 * @Date: 2019/5/25 16:36
 */
public class AdminDaoImplTest {

    @Test
    public void getAllAdmin() {
        try {
            List<Admin> allAdmin = DaoFactory.getAdminDao().getAllAdmin();
            System.out.println(allAdmin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAdmin() {
        try {
            Admin admin = DaoFactory.getAdminDao().getAdmin("1");
            System.out.println(admin.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertAdmin() {
    }

    @Test
    public void updateAdmin() {
    }

    @Test
    public void deleteAdmin() {
    }

    @Test
    public void findAdmin() {
        try {
            boolean admin = DaoFactory.getAdminDao().findAdmin("1", "12345");
            System.out.println(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}