package com.tt.spring.bean.factory;


/**
 * @author lizhuo
 * @Description: 具备对bean实例进行装配功能 的工厂
 * @date 2019-11-29 11:36
 */
public interface AutowireCapableBeanFactory extends BeanFactory  {

	/**
	 * 创建Bean实例的功能
	 * 提供创建bean的方式，可以有很多种
	 * @param type
	 * @return
	 */
	Object createBean(Class<?> type);

}
