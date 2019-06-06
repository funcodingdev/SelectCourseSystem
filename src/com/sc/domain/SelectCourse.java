package com.sc.domain;

/**
 * @Author: fangju
 * @Date: 2019/5/25 11:58
 * 选课实体类
 */
public class SelectCourse {
    private String stuId;//学号
    private String teachingTaskNum;//教学任务号信息
    private Double grade;//成绩
    private TeachingTask teachingTask;
    private Student student;

    public SelectCourse() {
    }

    public SelectCourse(String stuId, String teachingTaskNum, Double grade) {
        this.stuId = stuId;
        this.teachingTaskNum = teachingTaskNum;
        this.grade = grade;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getTeachingTaskNum() {
        return teachingTaskNum;
    }

    public void setTeachingTaskNum(String teachingTaskNum) {
        this.teachingTaskNum = teachingTaskNum;
    }

    public TeachingTask getTeachingTask() {
        return teachingTask;
    }

    public void setTeachingTask(TeachingTask teachingTask) {
        this.teachingTask = teachingTask;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "SelectCourse{" +
                "stuId='" + stuId + '\'' +
                ", teachingTaskNum='" + teachingTaskNum + '\'' +
                ", grade=" + grade +
                '}';
    }
}
