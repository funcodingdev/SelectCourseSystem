package com.sc.domain;

/**
 * @Author: fangju
 * @Date: 2019/5/25 11:58
 * 选课实体类
 */
public class SelectCourse {
    private String stuId;//学号
    private String teachingTaskNum;//教学任务号
    private Double grade;//成绩

    public SelectCourse() {
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getTeachingTaskNum() {
        return teachingTaskNum;
    }

    public void setTeachingTaskNum(String teachingTaskNum) {
        this.teachingTaskNum = teachingTaskNum;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
