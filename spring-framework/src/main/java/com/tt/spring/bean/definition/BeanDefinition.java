package com.tt.spring.bean.definition;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhuo
 * @Description:
 * @date 2019-11-29 11:42
 */
public class BeanDefinition {
	private String clazzName;
	private String beanName;
	private String initMethod;
	private String scope;

	private static final String SCOPE_SINGLETON = "singleton";
	private static final String SCOPE_PROTOTYPE = "prototype";

	/**
	 * bean中的属性信息
	 */
	private List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();
	private List<PropertyValue> ids = new ArrayList<>();

	public BeanDefinition(String clazzName, String beanName) {
		this.beanName = beanName;
		this.clazzName = clazzName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getInitMethod() {
		return initMethod;
	}

	public void setInitMethod(String initMethod) {
		this.initMethod = initMethod;
	}

	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	public void addPropertyValue(PropertyValue propertyValue) {
		this.propertyValues.add(propertyValue);
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}

	public boolean isSingleton() {
		return SCOPE_SINGLETON.equals(this.scope);
	}

	public boolean isPrototype() {
		return SCOPE_PROTOTYPE.equals(this.scope);
	}

}
