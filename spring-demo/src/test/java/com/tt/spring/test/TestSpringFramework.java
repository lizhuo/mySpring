package com.tt.spring.test;

import com.tt.spring.bean.factory.support.DefaultListableBeanFactory;
import com.tt.spring.bean.resource.ClasspathResource;
import com.tt.spring.bean.resource.Resource;
import com.tt.spring.bean.xml.XmlBeanDefinitionReader;
import com.tt.spring.po.Student;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author lizhuo
 * @Description: Test case
 * @date 2019-11-29 08:57
 */
public class TestSpringFramework {

	@Test
	public void test() {

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

		// 将资源抽象为一个接口 通过该接口 可以获取不同地方（网络、文件系统、classpath）的资源
		String location = "beans.xml";
		Resource resource = new ClasspathResource(location);
		InputStream inputStream =  resource.getResource();
		xmlBeanDefinitionReader.loadBeanDefinitions(inputStream);

		Student student = (Student) beanFactory.getBean("student");

	}
}
