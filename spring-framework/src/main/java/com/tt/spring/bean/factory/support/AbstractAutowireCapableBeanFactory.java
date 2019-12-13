package com.tt.spring.bean.factory.support;

import com.tt.spring.bean.factory.AutowireCapableBeanFactory;

/**
 * @author lizhuo
 * @Description:
 * @date 2019-11-29 11:59
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

	@Override
	public Object createBean(BeanDefinition beanDefinition) {
		// TODO  会完成Bean的创建
		return null;
	}

}
