package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListExample;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.AttachmentExample;
import com.example.springboot.entity.AttachmentKey;
import com.example.springboot.entity.Parameter;
import com.example.springboot.entity.ParameterExample;
import com.example.springboot.service.AttachmentService;
import com.example.springboot.service.ParameterService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AttachmentApiController { 
	
	@Autowired
	AttachmentService attachmentService;
	
	AttachmentKey key;
	
	AttachmentExample attachmentExample;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "新增檔案上傳")
	@RequestMapping(value = "/fileUplolad", method = RequestMethod.POST)
	public Attachment fileUplolad(Attachment attachment,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectFile(attachment,token) == null)
		{
			attachmentService.insertSelective(attachment);
		}
		else
		{
			attachmentService.updateByPrimaryKeySelective(attachment);
		}
		return attachment;
	}
	
	@ApiOperation(value = "查詢檔案(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectFile", method = RequestMethod.POST)
	public Attachment selectFile(Attachment attachment,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		
		key = new AttachmentKey();
		key.setFileBelong(attachment.getFileBelong());
		key.setFileBelongId(attachment.getFileBelongId());
		key.setFileName(attachment.getFileName());
		key.setFileType(attachment.getFileType());
		return attachmentService.selectByPrimaryKey(key);
	}
	
	@ApiOperation(value = "查詢檔案(多筆，畫面顯示)")
	@RequestMapping(value = "/selectFiles", method = RequestMethod.POST)
	public List<Attachment> selectFiles(Attachment attachment,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		attachmentExample = new AttachmentExample();
		attachmentExample.createCriteria().andFileBelongEqualTo(attachment.getFileBelong()).andFileBelongIdEqualTo(attachment.getFileBelongId()).andFileTypeEqualTo(attachment.getFileType());
		attachmentExample.setOrderByClause("id asc");
		return attachmentService.selectByExample(attachmentExample);
	}
}