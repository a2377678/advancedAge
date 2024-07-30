package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.ExperienceInheritanceSpeakerListMapper;
import com.example.springboot.entity.ExperienceInheritanceSpeakerList;
import com.example.springboot.entity.ExperienceInheritanceSpeakerListExample;
import com.example.springboot.entity.ExperienceInheritanceSpeakerListKey;

@Service
public class ExperienceInheritanceSpeakerListService{
	
	@Autowired
	ExperienceInheritanceSpeakerListMapper experienceInheritanceSpeakerListMapper;
	
	public int insertSelective(ExperienceInheritanceSpeakerList record) {
		return experienceInheritanceSpeakerListMapper.insertSelective(record);
	}
	
	public ExperienceInheritanceSpeakerList selectByPrimaryKey(ExperienceInheritanceSpeakerListKey key) {
		return experienceInheritanceSpeakerListMapper.selectByPrimaryKey(key);
	}
	
	public List<ExperienceInheritanceSpeakerList> selectByExample(ExperienceInheritanceSpeakerListExample example){
		return experienceInheritanceSpeakerListMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(ExperienceInheritanceSpeakerList record) {
		return experienceInheritanceSpeakerListMapper.updateByPrimaryKeySelective(record);
	}
	
	public int deleteByPrimaryKey(ExperienceInheritanceSpeakerListKey key) {
		return experienceInheritanceSpeakerListMapper.deleteByPrimaryKey(key);
	}
	
	public int deleteByExample(ExperienceInheritanceSpeakerListExample example) {
		return experienceInheritanceSpeakerListMapper.deleteByExample(example);
	}
}