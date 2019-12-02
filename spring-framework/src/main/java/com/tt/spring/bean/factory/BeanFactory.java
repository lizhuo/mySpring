package com.tt.spring.bean.factory;

/**
 * @author lizhuo
 * @Description: 顶级接口 负责Bean的获取
 * @date 2019-11-29 09:44
 */
public interface BeanFactory {

	/**
	 * 根据Bean的名称获取Bean的实例
	 * @param name
	 * @return
	 */
	Object getBean(String name);

}
