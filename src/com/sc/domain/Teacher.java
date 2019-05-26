package com.sc.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author: fangju
 * @Date: 2019/5/25 11:58
 * 教师实体类
 */
public class Teacher {
    @JSONField(name = "t_id")
    private String id;//教师编号
    @JSONField(name = "t_name")
    private String name;//姓名
    @JSONField(name = "t_sex")
    private String sex;//性别
    @JSONField(name = "t_age")
    private Integer age;//年龄
    @JSONField(name = "t_identity")
    private String identity;//身份
    @JSONField(name = "t_password")
    private String password;//密码
    @JSONField(name = "t_image")
    private String image;//头像

    public Teacher() {
    }

    public Teacher(String id, String name, String sex, Integer age, String identity, String password, String image) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.identity = identity;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", identity='" + identity + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
