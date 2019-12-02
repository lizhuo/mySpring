package com.tt.spring.po;

/**
 * @author lizhuo
 * @Description:
 * @date 2019-11-29 09:01
 */
public class Student {

	private String name;
	private Course course;

	public void initMethod() {
		System.out.println("初始化方法");
	}

	public void destroyMethod() {
		System.out.println("销毁方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
