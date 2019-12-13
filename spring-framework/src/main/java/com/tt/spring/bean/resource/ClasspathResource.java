package com.tt.spring.bean.resource;

import java.io.InputStream;

/**
 * @author lizhuo
 * @Description: TODO
 * @date 2019-12-13 09:34
 */
public class ClasspathResource implements Resource {

	private String location;

	public ClasspathResource(String location) {
		this.location = location;
	}

	@Override
	public InputStream getResource() {
		return this.getClass().getClassLoader().getResourceAsStream(location);
	}

}
