package com.sc.domain;

/**
 * @Author: fangju
 * @Date: 2019/5/25 11:59
 * 教学任务实体类
 */
public class TeachingTask {
    private String teachingTaskNum;//教学任务号
    private String courseNum;//课程号
    private String teacherNum;//教师编号
    private String location;//上课地点
    private Integer totalNum;//选课人数

    public TeachingTask() {
    }

    public String getTeachingTaskNum() {
        return teachingTaskNum;
    }

    public void setTeachingTaskNum(String teachingTaskNum) {
        this.teachingTaskNum = teachingTaskNum;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
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
                ", courseNum='" + courseNum + '\'' +
                ", teacherNum='" + teacherNum + '\'' +
                ", location='" + location + '\'' +
                ", totalNum=" + totalNum +
                '}';
    }
}
