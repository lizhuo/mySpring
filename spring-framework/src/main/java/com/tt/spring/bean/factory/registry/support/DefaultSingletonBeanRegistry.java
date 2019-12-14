package com.tt.spring.bean.factory.registry.support;

import com.tt.spring.bean.factory.registry.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhuo
 * @Description: 单例 bean 注册中心
 * ***** 使用类来封装数据 以及 封装对数据的操作
 * @date 2019-12-14 15:22
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

	/**
	 * 专门存储单例bean实例的集合
	 */
	private Map<String, Object> singletons = new HashMap<>();

	@Override
	public Object getSingleton(String name) {
		return this.singletons.get(name);
	}

	@Override
	public void addSingleton(String name, Object bean) {
		this.singletons.put(name, bean);
	}

}
