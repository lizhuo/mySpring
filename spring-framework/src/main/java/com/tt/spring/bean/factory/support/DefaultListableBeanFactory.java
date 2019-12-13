package com.tt.spring.bean.factory.support;


import com.tt.spring.bean.definition.BeanDefinition;
import com.tt.spring.bean.factory.registry.BeanDefinitionRegistry;
import com.tt.spring.bean.resource.ClasspathResource;
import com.tt.spring.bean.resource.Resource;
import com.tt.spring.bean.utils.DocumentReader;
import com.tt.spring.bean.xml.XmlBeanDefinitionDocumentReader;
import com.tt.spring.bean.xml.XmlBeanDefinitionReader;
import org.dom4j.Document;

import java.io.InputStream;

/**
 * @author lizhuo
 * @Description: Spring最底层工厂类 由他实现Bean的管理
 * **  BeanDefinitionRegistry 接口隔离原则
 * @date 2019-11-29 09:43
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

	public DefaultListableBeanFactory() {
	}

	@Override
	public Object createBean(BeanDefinition beanDefinition) {
		return null;
	}

	public DefaultListableBeanFactory(String location) {
		// 将资源抽象为一个接口 通过该接口 可以获取不同地方（网络、文件系统、classpath）的资源
		Resource resource = new ClasspathResource(location);
		InputStream inputStream =  resource.getResource();

		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(this);
		xmlBeanDefinitionReader.loadBeanDefinitions(inputStream);
	}

	@Override
	public BeanDefinition getBeanDefinition(String name) {
		return null;
	}

	@Override
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {

	}
}
