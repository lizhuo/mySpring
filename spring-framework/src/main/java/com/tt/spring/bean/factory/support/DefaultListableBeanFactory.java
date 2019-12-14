package com.tt.spring.bean.factory.support;


import com.tt.spring.bean.definition.BeanDefinition;
import com.tt.spring.bean.factory.registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhuo
 * @Description: Spring最底层工厂类 由他实现Bean的管理
 * **  BeanDefinitionRegistry 接口隔离原则
 * @date 2019-11-29 09:43
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

	/**
	 * 以beanName为Key BeanDefinition为Value的存储集合
	 */
	private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

	public DefaultListableBeanFactory() {
	}

	@Override
	public BeanDefinition getBeanDefinition(String name) {
		return this.beanDefinitions.get(name);
	}

	@Override
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
		this.beanDefinitions.put(name, beanDefinition);
	}

}
