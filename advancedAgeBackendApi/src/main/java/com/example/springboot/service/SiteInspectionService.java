package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.SiteInspectionMapper;
import com.example.springboot.entity.SiteInspection;
import com.example.springboot.entity.SiteInspectionExample;

@Service
public class SiteInspectionService{
	
	@Autowired
	SiteInspectionMapper siteInspectionMapper;
	
	public int insertSelective(SiteInspection record) {
		return siteInspectionMapper.insertSelective(record);
	}
	
	public List<SiteInspection> selectByExample(SiteInspectionExample example){
		return siteInspectionMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(SiteInspection record) {
		return siteInspectionMapper.updateByPrimaryKeySelective(record);
	}
	
	public SiteInspection selectByPrimaryKey(Integer id) {
		return siteInspectionMapper.selectByPrimaryKey(id);
	}
}