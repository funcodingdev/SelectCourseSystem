package com.sc.domain;

/**
 * @Author: fangju
 * @Date: 2019/5/26 19:00
 */
public class SClass {
    private String name;//班级名
    private Integer totalNum;//班级总人数
    private String deptName;//所属院系名

    public SClass() {
    }

    public SClass(String name, Integer totalNum, String deptName) {
        this.name = name;
        this.totalNum = totalNum;
        this.deptName = deptName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "SClass{" +
                "name='" + name + '\'' +
                ", totalNum=" + totalNum +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
