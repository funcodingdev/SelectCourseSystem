package com.sc.domain;

/**
 * @Author: fangju
 * @Date: 2019/5/25 11:55
 * 课程实体类
 */
public class Course {
    private String number;//课程号
    private String name;//课程名
    private Integer credit;//学分
    private Integer period;//总学时
    private Integer theory;//理论学时
    private Integer experiment;//实验学时

    public Course() {
    }

    public Course(String number, String name, Integer credit, Integer period, Integer theory, Integer experiment) {
        this.number = number;
        this.name = name;
        this.credit = credit;
        this.period = period;
        this.theory = theory;
        this.experiment = experiment;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getTheory() {
        return theory;
    }

    public void setTheory(Integer theory) {
        this.theory = theory;
    }

    public Integer getExperiment() {
        return experiment;
    }

    public void setExperiment(Integer experiment) {
        this.experiment = experiment;
    }

    @Override
    public String toString() {
        return "Course{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", credit='" + credit + '\'' +
                ", period=" + period +
                ", theory=" + theory +
                ", experiment=" + experiment +
                '}';
    }
}
