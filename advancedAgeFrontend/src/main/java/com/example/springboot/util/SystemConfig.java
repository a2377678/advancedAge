package com.example.springboot.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
	private static Properties props ;
	public SystemConfig(){
		try {
			Resource resource = new ClassPathResource("/application.properties");//
			props = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	* 獲取屬性
	* @param key
	* @return
	*/
	public static String getProperty(String key){
		return props == null ? null : props.getProperty(key);
	}
	/**
	* 獲取屬性
	* @param key 屬性key
	* @param defaultValue 屬性value
	* @return
	*/
	public static String getProperty(String key,String defaultValue){
		return props == null ? null : props.getProperty(key, defaultValue);
	}
	/**
	* 獲取properyies屬性
	* @return
	*/
	public static Properties getProperties(){
		return props;
	}
}