package com.tt.spring.test;

import com.tt.spring.bean.factory.BeanFactory;
import com.tt.spring.bean.DefaultListableBeanFactory;
import com.tt.spring.po.Student;
import org.junit.Test;

/**
 * @author lizhuo
 * @Description: Test case
 * @date 2019-11-29 08:57
 */
public class TestSpringFramework {

	@Test
	public void test() {
		String location = "beans.xml";
		BeanFactory beanFactory = new DefaultListableBeanFactory(location);
		Student student = beanFactory.getBean("student");
	}

}
