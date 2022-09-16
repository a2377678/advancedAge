package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeApplyEmployedSituationMapper;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituation;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituationExample;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituationKey;

@Service
public class AdvancedAgeApplyEmployedSituationService{
	
	@Autowired
	AdvancedAgeApplyEmployedSituationMapper advancedAgeApplyEmployedSituationMapper;
	
	public int insertSelective(AdvancedAgeApplyEmployedSituation record) {
		return advancedAgeApplyEmployedSituationMapper.insertSelective(record);
	}
	
	public AdvancedAgeApplyEmployedSituation selectByPrimaryKey(AdvancedAgeApplyEmployedSituationKey key) {
		return advancedAgeApplyEmployedSituationMapper.selectByPrimaryKey(key);
	}
	
	public List<AdvancedAgeApplyEmployedSituation> selectByExample(AdvancedAgeApplyEmployedSituationExample example){
		return advancedAgeApplyEmployedSituationMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(AdvancedAgeApplyEmployedSituation record) {
		return advancedAgeApplyEmployedSituationMapper.updateByPrimaryKeySelective(record);
	}
}