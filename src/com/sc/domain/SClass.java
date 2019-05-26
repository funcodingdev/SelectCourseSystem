package com.sc.domain;

/**
 * @Author: fangju
 * @Date: 2019/5/26 19:00
 */
public class SClass {
    private String id;//班级编号
    private String name;//班级名
    private Integer totalNum;//班级总人数
    private String deptId;//所属院系编号
    private String deptName;//所属院系名

    public SClass() {
    }

    public SClass(String id, String name, Integer totalNum, String deptId, String deptName) {
        this.id = id;
        this.name = name;
        this.totalNum = totalNum;
        this.deptId = deptId;
        this.deptName = deptName;
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

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", totalNum=" + totalNum +
                ", deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
