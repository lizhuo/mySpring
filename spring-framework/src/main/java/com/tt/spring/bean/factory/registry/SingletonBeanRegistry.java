package com.tt.spring.bean.factory.registry;

/**
 * @author lizhuo
 * @Description: 专门负责单例Bean实例的管理
 * @date 2019-12-14 15:15
 */
public interface SingletonBeanRegistry {

	/**
	 * 从注册中心中 获取单例 bean
	 * @param name
	 * @return
	 */
	Object getSingleton(String name);

	/**
	 * 往单例bean 注册中心集合 注册bean
	 * @param name
	 * @param bean
	 */
	void addSingleton(String name, Object bean);

}
