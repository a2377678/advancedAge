package com.example.springboot.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
	Logger logger = LogManager.getLogger(SystemConfig.class);
	private static Properties props ;
	public SystemConfig(){
		try {
			Resource resource = new ClassPathResource("/application.properties");//
			props = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	/**
	* ����ݩ�
	* @param key
	* @return
	*/
	public static String getProperty(String key){
		return props == null ? null : props.getProperty(key);
	}
	/**
	* ����ݩ�
	* @param key �ݩ�key
	* @param defaultValue �ݩ�value
	* @return
	*/
	public static String getProperty(String key,String defaultValue){
		return props == null ? null : props.getProperty(key, defaultValue);
	}
	/**
	* ���properyies�ݩ�
	* @return
	*/
	public static Properties getProperties(){
		return props;
	}
}