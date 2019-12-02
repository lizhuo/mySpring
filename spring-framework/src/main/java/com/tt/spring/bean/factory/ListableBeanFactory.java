package com.tt.spring.bean.factory;

import java.util.List;

/**
 * @author lizhuo
 * @Description: 可以将工厂中的bean或名称进行列表化展示
 * @date 2019-11-29 11:29
 */
public interface ListableBeanFactory extends BeanFactory {

	/**
	 * 根据bean类型，获取它及子类型对应的bean实例集合
	 * @param type
	 * @return
	 */
	List<Object> getBeansByType(Class<?> type);

	/**
	 * 根据bean类型，获取它及子类型对应的bean名称集合
	 * @param type
	 * @return
	 */
	List<Object> getBeanNamesByType(Class<?> type);

}
