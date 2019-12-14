package com.tt.spring.bean.xml;

import com.tt.spring.bean.definition.BeanDefinition;
import com.tt.spring.bean.definition.PropertyValue;
import com.tt.spring.bean.definition.RuntimeBeanReference;
import com.tt.spring.bean.definition.TypedStringValue;
import com.tt.spring.bean.factory.registry.BeanDefinitionRegistry;
import com.tt.spring.bean.utils.ReflectUtils;
import org.dom4j.Element;

import java.util.List;

/**
 * @author lizhuo
 * @Description: 根据Bean标签定义解析
 * Bean配置文件解析器
 * @date 2019-12-13 09:59
 */
public class XmlBeanDefinitionDocumentReader {

	private BeanDefinitionRegistry beanDefinitionRegistry;

	public XmlBeanDefinitionDocumentReader(BeanDefinitionRegistry beanDefinitionRegistry) {
		this.beanDefinitionRegistry = beanDefinitionRegistry;
	}

	public void loadBeanDefinitions(Element rootElement) {
		List<Element> elements = rootElement.elements();
		for (Element element : elements) {
			// 获取标签名称
			String name = element.getName();
			if ("bean".equals(name)) {
				// 解析默认标签 其实也就是bean标签
				parseDefaultElement(element);
			} else {
				// 解析自定义标签 比如mvc:interceptors标签
				parseCustomElement(element);
			}
		}
	}

	private void parseDefaultElement(Element beanElement) {
		try {
			if (beanElement == null) {
				return;
			}
			String id = beanElement.attributeValue("id"); // 获取ID属性
			String name = beanElement.attributeValue("name"); // 获取name属性
			String clazzName = beanElement.attributeValue("class"); // 获取class属性
			if (clazzName == null || "".equals(clazzName)) {
				return;
			}
			Class<?> clazzType = Class.forName(clazzName);

			String initMethod = beanElement.attributeValue("init-method"); // 获取init-method属性
			String scope = beanElement.attributeValue("scope");// 获取 scope 属性
			scope = scope == null || "".equals(scope) ? "singleton" : scope;

			String beanName = id == null ? name : id;
			beanName = beanName == null ? clazzType.getSimpleName() : beanName;
			// 创建 BeanDefinition 对象
			// 此次可以使用构建者模式进行优化
			BeanDefinition beanDefinition = new BeanDefinition(clazzName, beanName);
			beanDefinition.setInitMethod(initMethod);
			beanDefinition.setScope(scope);

			// 获取 Property 子标签集合
			List<Element> propertyElements = beanElement.elements();
			for (Element properElement : propertyElements) {
				parsePropertyElement(beanDefinition, properElement);
			}

			// 注册 BeanDefinition 信息
			this.beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinition);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void parsePropertyElement(BeanDefinition beanDefinition, Element properElement) {
		if (properElement == null) {
			return;
		}

		String name = properElement.attributeValue("name"); // 获取name属性
		String value = properElement.attributeValue("value"); // 获取value属性
		String ref = properElement.attributeValue("ref"); // 获取ref属性
		// 如果value和ref都有值，则返回
		if (value != null && !"".equals(value) && ref != null && "".equals(ref)) {
			return;
		}

		/**
		 * PropertyValue 就封装着一个property标签信息
		 */
		PropertyValue pv = null;
		if (value != null && !"".equals(value)) {
			// 因为spring配置文件中value是String类型，而对象中的属性值是各种各样的，所以要存储类型
			Class<?> targetFieldType = ReflectUtils.getTypeByFieldName(beanDefinition.getBeanName(), name);

			TypedStringValue typedStringValue = new TypedStringValue(value);
			typedStringValue.setTargetType(targetFieldType);

			pv = new PropertyValue(name, typedStringValue);
			beanDefinition.addPropertyValue(pv);

		} else if (ref != null && !"".equals(ref)) {
			RuntimeBeanReference reference = new RuntimeBeanReference(ref);
			pv = new PropertyValue(name, reference);
			beanDefinition.addPropertyValue(pv);

		} else {
			return;
		}
	}

	private void parseCustomElement(Element element) {
	}

}
