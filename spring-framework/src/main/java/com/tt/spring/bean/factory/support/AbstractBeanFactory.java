package com.tt.spring.bean.factory.support;

import com.tt.spring.bean.definition.BeanDefinition;
import com.tt.spring.bean.factory.BeanFactory;
import com.tt.spring.bean.factory.registry.support.DefaultSingletonBeanRegistry;

/**
 * @author lizhuo
 * @Description: 定义Bean的获取流程
 * **** DefaultSingletonBeanRegistry 代码结构原则
 * **** 依赖倒置 && 抽象模版方法
 * @date 2019-11-29 11:55
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

	/**
	 * 制定获取bean的流程
	 * @param name
	 * @return
	 */
	@Override
	public Object getBean(String name) {
		// 从缓存中获取要找的对象
		Object singleton = getSingleton(name);
		if (singleton != null) {
			return singleton;
		}

		// 找不到 则获取制定名称的 BeanDefinition 对象
		// 此处使用抽象模版方法，此处只定流程 不去实现 也不知道如何实现 不是这一层该干的事情 
		BeanDefinition bd = getBeanDefinition(name);

		// 根据 BeanDefinition 对象 判断是单例还是多例(原型 protoType) 单例要缓存 多例直接返回
		if (bd.isSingleton()) {
			// 根据 BeanDefinition 对象 完成 bean 的创建
			singleton = createBean(bd);

			// 缓存已经创建的单例bean实例
			addSingleton(name, singleton);

		} if (bd.isPrototype()) {
			// 根据 BeanDefinition 对象 完成 bean 的创建
			singleton = createBean(bd);
		}

		return singleton;
	}

	protected abstract Object createBean(BeanDefinition bd);

	/**
	 * 如何获取BeanDefinition，交给子类去完成
	 * TODO ?? 与 BeanDefinitionRegistry 方法重名 ??
	 * @param name
	 * @return
	 */
	protected abstract BeanDefinition getBeanDefinition(String name);

}
