package com.tt.spring.bean.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lizhuo
 * @Description: 反射工具类
 * @date 2019-12-14 12:38
 */
public class ReflectUtils {

	/**
	 * 使用构造器创建bean的实例
	 *
	 * @param clazz
	 * @param args
	 * @return
	 */
	public static Object createObject(Class<?> clazz, Object... args) {
		try {
			// TODO 可以根据输入参数获取指定构造参数的构造方法

			Constructor<?> constructor = clazz.getConstructor();
			// 默认调用无参构造进行对象的创建
			return constructor.newInstance(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void setProperty(Object beanInstance, String name, Object valueToUse) {
		try {
			Class<?> clazz = beanInstance.getClass();
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true); // 强制写入
			field.set(beanInstance, valueToUse);  // TODO ?? 类型不一致会发生什么情况
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Class<?> getTypeByFieldName(String beanClassName, String fieldName) {
		try {
			Class<?> clazz = Class.forName(beanClassName);
			Field field = clazz.getDeclaredField(fieldName);
			return field.getType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void invokeMethod(Object beanInstance, String initMethod) {
		try {
			if (initMethod == null || "".equals(initMethod)) {
				return;
			}
			Class<?> clazz = beanInstance.getClass();
			Method method = clazz.getDeclaredMethod(initMethod);
			// 设置允许访问私有方法和变量，此处也称之为暴力破解
			method.setAccessible(true);
			method.invoke(beanInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
