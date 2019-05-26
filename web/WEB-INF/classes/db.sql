drop table student;
drop table teacher;
drop table ADMIN;
drop table Course;
drop table choosecourse;
drop table teachingTask;
-- 学生表
create table Student(
	s_id varchar2(50) not null,-- 学号
	s_name varchar2(50) not null,-- 姓名
	s_sex varchar2(10) not null,-- 性别
	s_age number(2,0) not null,-- 年龄
	s_class varchar2(50) not null,-- 班级
	s_department varchar2(50) not null,-- 院系
	s_phone varchar2(50),-- 手机号
	s_password varchar2(50) not null,-- 密码
	s_image varchar2(50),-- 头像
	primary key(s_id),
	foreign key(s_class) references SClass(s_id)
);
-- 教师表
create table Teacher(
	t_id varchar2(50) not null,-- 教师编号
	t_name varchar2(50) not null,-- 姓名
	t_sex varchar2(10) not null,-- 性别
	t_age number(2,0) not null,-- 年龄
	t_identity varchar2(50) not null,-- 身份
	t_password varchar2(50) not null,-- 密码
	t_image varchar2(50),-- 头像
	primary key(t_id)
);
-- 课程表
create table Course(
	c_number varchar2(50) not null,-- 课程号
	c_name varchar2(50) not null,-- 课程名
	c_credit number(1,0) not null,-- 学分
	c_period number(2,0) not null,-- 总学时
	c_theory number(2,0) not null,-- 理论学时
	c_experiment number(2,0) not null,-- 实验学时
	primary key(c_number)
);

-- 管理员表
create table Admin(
	a_id varchar2(50) not null,-- 管理员id
	a_password varchar2(50) not null,-- 管理员密码
	a_name varchar2(50) not null,-- 管理员姓名
	primary key(a_id)
);
-- 选课表
create table SelectCourse(
	sc_stuId varchar2(50) not null,-- 学号
	sc_teachingTaskNum varchar2(50) not null,-- 教学任务号
	sc_grade number(3,2) not null,-- 成绩
	primary key (sc_teachingTaskNum),
	foreign key (sc_teachingTaskNum) references TeachingTask (tt_TeachingTaskNum) on delete cascade,
	foreign key (sc_stuId) references Student (s_id) on delete cascade
);

-- 教学任务表
create table TeachingTask(
	tt_teachingTaskNum varchar2(50) not null,-- 教学任务号
	tt_courseNum varchar2(50) not null,-- 课程号
	tt_teacherNum VARCHAR2(50) not null,-- 教师编号
	tt_totalNum number(4,0) not null,-- 选课人数
	tt_location varchar2(50) not null,-- 上课地点
	primary key (tt_teachingTaskNum),
	foreign key (tt_courseNum) references Course (c_number) on delete cascade,
	foreign key (tt_teacherNum) references Teacher (t_id) on delete cascade
);
-- 班级表
create table SClass(
	s_id varchar2(10) not null,-- 班级编号
	s_name varchar2(50) not null,-- 班级名
	s_totalNum number(4,0) not null,-- 班级总人数
	s_dept_id varchar2(10) not null,-- 院系编号
	s_dept_name varchar2(50) not null,-- 院系名
	primary key(s_id,s_name),
	foreign key(s_dept_id,s_dept_name) references department(d_id,d_name)
);
-- 院系表
create table Department(
	d_id varchar2(10) not null,-- 院系编号
	d_name varchar2(50) not null,-- 院系名
	primary key(d_id,d_name)
);





