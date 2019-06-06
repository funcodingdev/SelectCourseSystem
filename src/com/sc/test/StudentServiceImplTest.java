package com.sc.test;

import com.sc.domain.PageBean;
import com.sc.domain.Student;
import com.sc.service.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: fangju
 * @Date: 2019/6/6 10:08
 */
public class StudentServiceImplTest {

    @Test
    public void getPageBean() {
        PageBean<Student> pageBean = ServiceFactory.getStudentService().getPageBean(2);
        System.out.println(pageBean.getList().size());
    }
}