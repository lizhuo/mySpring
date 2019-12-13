package com.tt.spring.bean.definition;

/**
 * @author lizhuo
 * @Description: PropertyValue就封装着一个property标签的信息
 * @date 2019-11-29 11:44
 */
public class PropertyValue {

	private String name;

	private Object value;

	public PropertyValue(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
