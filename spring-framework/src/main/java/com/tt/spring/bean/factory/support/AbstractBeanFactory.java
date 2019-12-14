package com.tt.spring.bean.factory.support;

import com.tt.spring.bean.factory.BeanFactory;

/**
 * @author lizhuo
 * @Description: 定义Bean的获取流程
 * @date 2019-11-29 11:55
 */
public abstract class AbstractBeanFactory implements BeanFactory {

	@Override
	public Object getBean(String name) {
		// TODO 会调用 AbstractAutowireCapableBeanFactory的createBean功能
		return null;
	}

}
