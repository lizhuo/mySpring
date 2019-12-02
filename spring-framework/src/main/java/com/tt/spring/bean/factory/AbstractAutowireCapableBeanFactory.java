package com.tt.spring.bean.factory;

import com.tt.spring.definition.BeanDefinition;

/**
 * @author lizhuo
 * @Description: TODO
 * @date 2019-11-29 11:59
 */
public class AbstractAutowireCapableBeanFactory implements AutowireCapableBeanFactory {
	@Override
	public Object createBean(BeanDefinition beanDefinition) {
		return null;
	}

	@Override
	public Object getBean(String name) {
		return null;
	}
}
