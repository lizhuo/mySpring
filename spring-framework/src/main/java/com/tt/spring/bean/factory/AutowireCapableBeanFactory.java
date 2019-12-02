package com.tt.spring.bean.factory;

import com.tt.spring.definition.BeanDefinition;

/**
 * @author lizhuo
 * @Description: 具备对bean实例进行装配功能 的工厂
 * @date 2019-11-29 11:36
 */
public interface AutowireCapableBeanFactory extends BeanFactory  {

	/**
	 * 创建Bean实例的功能
	 * @param beanDefinition
	 * @return
	 */
	Object createBean(BeanDefinition beanDefinition);

}
