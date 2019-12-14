package com.tt.spring.bean.factory.support;

import com.tt.spring.bean.definition.BeanDefinition;
import com.tt.spring.bean.definition.PropertyValue;
import com.tt.spring.bean.definition.RuntimeBeanReference;
import com.tt.spring.bean.definition.TypedStringValue;
import com.tt.spring.bean.factory.AutowireCapableBeanFactory;
import com.tt.spring.bean.utils.ReflectUtils;

import java.util.List;

/**
 * @author lizhuo
 * @Description:
 * @date 2019-11-29 11:59
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

	@Override
	public Object createBean(BeanDefinition bd) {
		String clazzName = bd.getClazzName();
		Class<?> clazz = resolveClassName(clazzName);

		// 实例化bean 这里只有空对象
		Object singleton = createBeanInstance(clazz);

		// bean的属性填充
		populateSingleton(singleton, bd);

		// 初始化bean
		initBean(singleton, bd);

		return singleton;
	}

	private void initBean(Object singleton, BeanDefinition bd) {
		// TODO 完成Aware 标记接口 的相关处理  spring mvc 代码会用到

		// TODO BeanPostProcessor的前置方法执行
		initMethod(singleton, bd);
		// TODO BeanPostProcessor的后置方法执行 AOP代理对象产生的入口
	}

	/**
	 * afterPropertySet or ReflectUtils 2选1
	 * @param singleton
	 * @param bd
	 */
	private void initMethod(Object singleton, BeanDefinition bd) {
		// TODO InitializingBean 标记接口 的处理 调用的是afterPropertySet方法

		// 完成 init-method 标签属性对应的方法调用
		ReflectUtils.invokeMethod(singleton, bd.getInitMethod());
	}

	private void populateSingleton(Object singleton, BeanDefinition bd) {
		List<PropertyValue> propertyValues = bd.getPropertyValues();
		for (PropertyValue pv : propertyValues) {
			String name = pv.getName();
			// 未处理的 Value 对象
			Object value = pv.getValue();
			// 处理后的 Value 对象
			Object valueToUse = null;

			if (value instanceof TypedStringValue) {
				TypedStringValue typedStringValue = (TypedStringValue) value;
				String stringValue = typedStringValue.getValue();
				// 获取参数类型
				Class<?> targetType = typedStringValue.getTargetType();

				// TODO 建议使用策略模式优化
				if (targetType == Integer.class) {
					valueToUse = Integer.parseInt(stringValue);
				} else if (targetType == String.class) {
					valueToUse = stringValue;
				}

			} else if (value instanceof RuntimeBeanReference) {
				RuntimeBeanReference reference = (RuntimeBeanReference) value;

				// 递归获取制定bean名的实例
				// TODO 此处可能会发生循环依赖问题
				valueToUse = getBean(reference.getRef());

			} else {
				// ... list map
			}

			// 利用反射去设置bean的属性
			ReflectUtils.setProperty(singleton, name, valueToUse);
		}
	}

	private Object createBeanInstance(Class<?> clazz) {
		// TODO 可以使用bean标签的配置选择使用实例工厂去创建Bean
		// TODO 可以使用bean标签的配置选择使用静态工厂去创建Bean

		// 还可以使用构造方法创建bean
		return ReflectUtils.createObject(clazz);
	}

	private Class<?> resolveClassName(String clazzName) {
		try {
			return Class.forName(clazzName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过AbstractAutowireCapableBeanFactory接口对外提供的功能
	 * @param type
	 * @return
	 */
	@Override
	public Object createBean(Class<?> type) {
		return createBean(new BeanDefinition(null,null));
	}

}
