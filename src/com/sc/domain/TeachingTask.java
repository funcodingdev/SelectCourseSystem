package com.sc.domain;

/**
 * @Author: fangju
 * @Date: 2019/5/25 11:59
 * 教学任务实体类
 */
public class TeachingTask {
    private String teachingTaskNum;//教学任务号
    private String courseName;//课程名
    private String teacherNum;//教师编号
    private String teacherName;//教师姓名
    private String location;//上课地点
    private Integer totalNum;//选课人数

    public TeachingTask() {
    }

    public TeachingTask(String teachingTaskNum, String courseName, String teacherNum, String location, Integer totalNum) {
        this.teachingTaskNum = teachingTaskNum;
        this.courseName = courseName;
        this.teacherNum = teacherNum;
        this.location = location;
        this.totalNum = totalNum;
    }

    public String getTeachingTaskNum() {
        return teachingTaskNum;
    }

    public void setTeachingTaskNum(String teachingTaskNum) {
        this.teachingTaskNum = teachingTaskNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "TeachingTask{" +
                "teachingTaskNum='" + teachingTaskNum + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teacherNum='" + teacherNum + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", location='" + location + '\'' +
                ", totalNum=" + totalNum +
                '}';
    }
}
