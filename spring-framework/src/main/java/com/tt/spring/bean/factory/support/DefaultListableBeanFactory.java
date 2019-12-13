package com.tt.spring.bean.factory.support;


import com.tt.spring.bean.factory.support.AbstractAutowireCapableBeanFactory;

import java.io.InputStream;

/**
 * @author lizhuo
 * @Description: Spring最底层工厂类 由他实现Bean的管理
 * @date 2019-11-29 09:43
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory {

	public DefaultListableBeanFactory() {
	}

	public DefaultListableBeanFactory(String location) {
		// 将资源抽象为一个接口 通过该接口 可以获取不同地方（网络、文件系统、classpath）的资源
		Resource resource = new ClasspathResource();
		InputStream inputStream =  resource.getResource();
	}

}
