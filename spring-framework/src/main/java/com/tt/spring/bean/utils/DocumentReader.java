package com.tt.spring.bean.utils;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * @author lizhuo
 * @Description: XML 解析对象
 * @date 2019-12-13 09:43
 */
public class DocumentReader {

	/**
	 * 创建Document对象
	 *
	 * @param inputStream
	 * @return
	 */
	public static Document createDocument(InputStream inputStream) {
		Document document = null;
		try {
			SAXReader reader = new SAXReader();
			document = reader.read(inputStream);
			return document;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

}
