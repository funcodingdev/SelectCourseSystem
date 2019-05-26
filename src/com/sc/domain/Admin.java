package com.sc.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author: fangju
 * @Date: 2019/5/25 11:55
 * 管理员实体类
 */
public class Admin{
    @JSONField(name = "a_id")
    private String id;//管理员编号
    @JSONField(name = "a_password")
    private String password;//密码
    @JSONField(name = "a_name")
    private String name;//姓名
    @JSONField(name = "a_sex")
    private String sex;//性别
    @JSONField(name = "a_age")
    private Integer age;//年龄
    @JSONField(name = "a_image")
    private String image;//头像

    public Admin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", image='" + image + '\'' +
                '}';
    }
}
