package com.tt.spring.bean.xml;

import com.tt.spring.bean.factory.registry.BeanDefinitionRegistry;
import com.tt.spring.bean.utils.DocumentReader;
import org.dom4j.Document;

import java.io.InputStream;

/**
 * @author lizhuo
 * @Description: 对XML加载 然后获取BeanDefinition信息
 * @date 2019-12-13 11:29
 */
public class XmlBeanDefinitionReader {

	private BeanDefinitionRegistry beanDefinitionRegistry;

	public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
		this.beanDefinitionRegistry = beanDefinitionRegistry;
	}

	public void loadBeanDefinitions(InputStream inputStream) {
		Document document = DocumentReader.createDocument(inputStream);

		XmlBeanDefinitionDocumentReader documentReader = new XmlBeanDefinitionDocumentReader(this.beanDefinitionRegistry);
		documentReader.loadBeanDefinitions(document.getRootElement());
	}

}
