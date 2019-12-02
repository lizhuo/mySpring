package com.tt.spring.po;

/**
 * @author lizhuo
 * @Description:
 * @date 2019-11-29 08:59
 */
public class Course {

	private String name;
	private Integer age;

	public void init() {
		System.out.println("我是对象初始化方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
