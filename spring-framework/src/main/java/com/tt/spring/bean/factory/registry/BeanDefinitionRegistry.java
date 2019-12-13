package com.tt.spring.bean.factory.registry;

import com.tt.spring.bean.definition.BeanDefinition;

/**
 * @author lizhuo
 * @Description: 管理BeanDefinition的注册
 * @date 2019-12-13 11:22
 */
public interface BeanDefinitionRegistry {

	BeanDefinition getBeanDefinition(String name);

	void  registerBeanDefinition(String name, BeanDefinition beanDefinition);

}
