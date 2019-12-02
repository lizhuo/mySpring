package com.tt.spring.definition;

/**
 * @author lizhuo
 * @Description:
 * @date 2019-11-29 11:45
 */
public class TypedStringValue {

	private String value;

	private Class<?> targetType;

	public TypedStringValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Class<?> getTargetType() {
		return targetType;
	}

	public void setTargetType(Class<?> targetType) {
		this.targetType = targetType;
	}

}
