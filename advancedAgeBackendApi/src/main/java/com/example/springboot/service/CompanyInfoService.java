package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeApplyMapper;
import com.example.springboot.dao.CompanyInfoMapper;
import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyExample;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.entity.CompanyInfoExample;

@Service
public class CompanyInfoService{
	
	@Autowired
	CompanyInfoMapper companyInfoMapper;
	
	public int insertSelective(CompanyInfo record) {
		return companyInfoMapper.insertSelective(record);
	}
	
	public CompanyInfo selectByPrimaryKey(String seq) {
		return companyInfoMapper.selectByPrimaryKey(seq);
	}
	
	public List<CompanyInfo> selectByExample(CompanyInfoExample example){
		return companyInfoMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(CompanyInfo record) {
		return companyInfoMapper.updateByPrimaryKeySelective(record);
	}
	
	public int updateByExampleSelective(CompanyInfo record,CompanyInfoExample example) {
		return companyInfoMapper.updateByExampleSelective(record, example);
	}
}