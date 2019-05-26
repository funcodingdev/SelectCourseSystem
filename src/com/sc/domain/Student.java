package com.sc.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author: fangju
 * @Date: 2019/5/25 11:57
 * 学生实体类
 */
public class Student {
    @JSONField(name = "s_id")
    private String id;//学号
    @JSONField(name = "s_name")
    private String name;//姓名
    @JSONField(name = "s_sex")
    private String sex;//性别
    @JSONField(name = "s_age")
    private Integer age;//年龄
    @JSONField(name = "s_class")
    private String sClass;//班级
    @JSONField(name = "s_department")
    private String department;//院系
    @JSONField(name = "s_phone")
    private String phone;//手机号
    @JSONField(name = "s_password")
    private String password;//密码
    @JSONField(name = "s_image")
    private String image;//头像

    public Student() {
    }

    public Student(String id, String name, String sex, Integer age, String sClass, String department, String phone, String password, String image) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sClass = sClass;
        this.department = department;
        this.phone = phone;
        this.password = password;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sClass='" + sClass + '\'' +
                ", department='" + department + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
