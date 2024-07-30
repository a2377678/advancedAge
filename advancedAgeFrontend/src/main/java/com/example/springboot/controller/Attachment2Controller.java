package com.example.springboot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceipt;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.ExperienceInheritanceSpeakerList;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditure;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSchedule;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudent;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller 
public class Attachment2Controller {
	
	Logger logger = LogManager.getLogger(AttachmentController.class);
	
	CallApi api = new CallApi();
	
	HttpSession session;
	
	@Value("${api_ip}")
	private String ip;
	
	@Value("${file_path}")
	private String localPath;
	
	AdvancedAgeBase base;

	@RequestMapping(value = "/addExperienceInheritanceSpeakerListFromFile", method = RequestMethod.POST)
	public void addExperienceInheritanceSpeakerListFromFile(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			) { 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		String applyId=session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString();
		String planId=session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritancePlanId").toString();
		
		String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		if (!extension.toLowerCase().trim().equals("xlsx") && !extension.toLowerCase().trim().equals("xls"))
        {
			logger.warn("addAdvancedAgeEmploymentListFromFile 檔案格式錯誤");
			checkFile=false;
        }
		if(checkFile) {
			Attachment attach = new Attachment();
			attach.setFileBelong("B");
			attach.setFileBelongId(Integer.valueOf(applyId));
			attach.setFileName(uploadFile.getOriginalFilename());
			attach.setFileFrequency(1);
			attach.setFileType("speakerList");
			attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
			attach.setFileSize((int)uploadFile.getSize());
			attach.setFileStatus(1);
			
			try {
				json = objectMapper.writeValueAsString(attach);
			} catch (JsonProcessingException e1) {
				logger.warn(e1.getMessage());
			}
			
			//檔案上傳
			try {
				SaveFileFromInputStream(uploadFile.getInputStream(),attach.getFilePath(),uploadFile.getOriginalFilename());
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
			
	        String destFileName=localPath+attach.getFilePath()+"/"+uploadFile.getOriginalFilename();
	        
	        File destFile=null;
			try {
				destFile = new File(destFileName).getCanonicalFile();
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
	        try {
				uploadFile.transferTo(destFile);
			} catch (IllegalStateException e) {
				logger.warn(e.getMessage());
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
	        
	        Sheet sheet;
	 
	        Workbook workbook = null;
	        FileInputStream inputStream = null;
	        try {
	            workbook= new XSSFWorkbook(destFile);
	        } catch (IOException ex) {
	        	try {
					inputStream=new FileInputStream(destFileName);
					workbook = new HSSFWorkbook(inputStream);
				} catch (FileNotFoundException e) {
					logger.warn(e.getMessage());
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	            
	        }catch (InvalidFormatException ex) {
	        	try {
					inputStream=new FileInputStream(destFileName);
					workbook = new HSSFWorkbook(inputStream);
				} catch (FileNotFoundException e) {
					logger.warn(e.getMessage());
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }finally {
	        	try {
	        		if(inputStream != null) {
	        			inputStream.close();
	        		}
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }
	        
	        sheet = workbook.getSheetAt(0);
	 
	        int totalRowNum = sheet.getLastRowNum();
	 
	        
	        List<ExperienceInheritanceSpeakerList> list = new ArrayList<ExperienceInheritanceSpeakerList>();
	        ExperienceInheritanceSpeakerList data;
	        try {
		        for(int i=2;i<=totalRowNum;i++){
		        	data = new ExperienceInheritanceSpeakerList();
		            Row row = sheet.getRow(i);
		            if(row!=null && !getCellValue(row.getCell(1)).equals("")){
		                
		                data.setName(getCellValue(row.getCell(1)));
		                if(!getCellValue(row.getCell(2)).replace("/", "").matches("[0-9]{7}")) {
		                	throw new NumberFormatException();
		                }
		                data.setBirthday(getCellValue(row.getCell(2)).replace("/", ""));
		                if(!getCellValue(row.getCell(3)).toString().matches("[a-zA-Z]{1}[0-9]{9}")){
		                	throw new NumberFormatException();
		                }
		                data.setIdentification(getCellValue(row.getCell(3)));
		                if(!getCellValue(row.getCell(5)).replace("/", "").matches("[0-9]{7}")) {
		                	throw new NumberFormatException();
		                }
		                if(getCellValue(row.getCell(4)).equals("勞工保險")){
		                	data.setLaborProtectionTime(getCellValue(row.getCell(5)).replace("/", ""));
		                }
		                else if(getCellValue(row.getCell(4)).equals("職災保險")) {
		                	data.setOccupationalAccidentProtectionTime(getCellValue(row.getCell(5)).replace("/", ""));
		                }else {
		                	throw new NumberFormatException();
		                }
		                
		                if(getCellValue(row.getCell(6)).equals("主管")) {
		                	data.setManager("Y");
		                }else if(getCellValue(row.getCell(6)).equals("非主管")) {
		                	data.setManager("N");
		                }else {
		                	throw new NumberFormatException();
		                }
		                if(getCellValue(row.getCell(7)).equals("三等親內")) {
		                	data.setRelatives("Y");
		                }else if(getCellValue(row.getCell(7)).equals("非三等親")) {
		                	data.setRelatives("N");
		                }else {
		                	throw new NumberFormatException();
		                }
		                if(getCellValue(row.getCell(8)).equals("全時")) {
		                	data.setWorkingHours("A");
		                }else if(getCellValue(row.getCell(8)).equals("部分工時")) {
		                	data.setWorkingHours("P");
		                }else {
		                	throw new NumberFormatException();
		                }
		                if(getCellValue(row.getCell(9)).equals("實務技術指導")) {
		                	data.setExecutionWay("S");
		                }else if(getCellValue(row.getCell(9)).equals("教育訓練課程講授")) {
		                	data.setExecutionWay("C");
		                }else {
		                	throw new NumberFormatException();
		                }
		                list.add(data);
		            }
		            else
		            {
		            	break;
		            }
		        }
	        }catch(NumberFormatException e) {
	        	checkFile=false;
	        	response.setContentType("text/html;charset=UTF-8");
	        	logger.warn(e.getMessage());
				try {
					response.resetBuffer();
					response.getWriter().print("excel fail");
				} catch (IOException e1) {
					logger.warn(e1.getMessage());
				}
	        }
	        if(checkFile)
	        {
	        	logger.info("刪除舊資料");
		        delExperienceInheritanceSpeakerListbyId(request, response, new ExperienceInheritanceSpeakerList(),planId);
		        logger.info("刪除finish");
		        
		        ExperienceInheritanceSpeakerList[] dataList = list.toArray(new ExperienceInheritanceSpeakerList[list.size()]);
		        addExperienceInheritanceSpeakerList(request,response,dataList,planId);
		        //刪除舊檔
				api.httpPost(ip+"deleteFile",json);
				//檔案儲存
				api.httpPost(ip+"fileUplolad",json);
		        try {
					workbook.close();
				} catch (IOException e1) {
					logger.warn(e1.getMessage());
				}
				response.setContentType("text/html;charset=UTF-8");
				try {
					response.resetBuffer();
					response.getWriter().print("success");
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }
		}else {
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.resetBuffer();
				response.getWriter().print("fail");
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	public void delExperienceInheritanceSpeakerListbyId(HttpServletRequest request, HttpServletResponse response
			,ExperienceInheritanceSpeakerList list,String planId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		list.setRetirementAdvancedAgeExperienceInheritancePlanId(Integer.valueOf(planId));
		try {
			json = objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delExperienceInheritanceSpeakerListbyId",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	public void addExperienceInheritanceSpeakerList(HttpServletRequest request, HttpServletResponse response
			,@RequestBody ExperienceInheritanceSpeakerList[] list,String planId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setRetirementAdvancedAgeExperienceInheritancePlanId(Integer.valueOf(planId));
				try {
					json = objectMapper.writeValueAsString(list[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addExperienceInheritanceSpeakerList",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritanceScheduleFromFile", method = RequestMethod.POST)
	public void addRetirementAdvancedAgeExperienceInheritanceScheduleFromFile(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			) { 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		String applyId=session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString();
		
		String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		if (!extension.toLowerCase().trim().equals("xlsx") && !extension.toLowerCase().trim().equals("xls"))
        {
			logger.warn("addRetirementAdvancedAgeExperienceInheritanceScheduleFromFile 檔案格式錯誤");
			checkFile=false;
        }
		if(checkFile) {
			Attachment attach = new Attachment();
			attach.setFileBelong("B");
			attach.setFileBelongId(Integer.valueOf(applyId));
			attach.setFileName(uploadFile.getOriginalFilename());
			attach.setFileFrequency(1);
			attach.setFileType("schedule");
			attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
			attach.setFileSize((int)uploadFile.getSize());
			attach.setFileStatus(1);
			
			try {
				json = objectMapper.writeValueAsString(attach);
			} catch (JsonProcessingException e1) {
				logger.warn(e1.getMessage());
			}
			
			//檔案上傳
			try {
				SaveFileFromInputStream(uploadFile.getInputStream(),attach.getFilePath(),uploadFile.getOriginalFilename());
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
			
	        String destFileName=localPath+attach.getFilePath()+"/"+uploadFile.getOriginalFilename();
	        
	        File destFile=null;
			try {
				destFile = new File(destFileName).getCanonicalFile();
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
	        try {
				uploadFile.transferTo(destFile);
			} catch (IllegalStateException e) {
				logger.warn(e.getMessage());
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
	        
	        Sheet sheet;
	 
	        Workbook workbook = null;
	        FileInputStream inputStream = null;
	        try {
	            workbook= new XSSFWorkbook(destFile);
	        } catch (IOException ex) {
	        	try {
					inputStream=new FileInputStream(destFileName);
					workbook = new HSSFWorkbook(inputStream);
				} catch (FileNotFoundException e) {
					logger.warn(e.getMessage());
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	            
	        }catch (InvalidFormatException ex) {
	        	try {
					inputStream=new FileInputStream(destFileName);
					workbook = new HSSFWorkbook(inputStream);
				} catch (FileNotFoundException e) {
					logger.warn(e.getMessage());
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }finally {
	        	try {
	        		if(inputStream != null) {
	        			inputStream.close();
	        		}
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }
	        
	        sheet = workbook.getSheetAt(0);
	 
	        int totalRowNum = sheet.getLastRowNum();
	 
	        // 縣市列表
	     	JSONArray cityJsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
	        List<RetirementAdvancedAgeExperienceInheritanceSchedule> list = new ArrayList<RetirementAdvancedAgeExperienceInheritanceSchedule>();
	        RetirementAdvancedAgeExperienceInheritanceSchedule data;
	        try {
		        for(int i=2;i<=totalRowNum;i++){
		        	data = new RetirementAdvancedAgeExperienceInheritanceSchedule();
		            Row row = sheet.getRow(i);
		            if(row!=null && !getCellValue(row.getCell(1)).equals("")){
		                
		                if(!getCellValue(row.getCell(1)).replace("/", "").matches("[0-9]{7}")) {
		                	throw new NumberFormatException();
		                }
		                data.setExecutionStartTime(getCellValue(row.getCell(1)).replace("/", ""));
		                if(!getCellValue(row.getCell(2)).replace("/", "").matches("[0-9]{7}")) {
		                	throw new NumberFormatException();
		                }
		                data.setExecutionEndTime(getCellValue(row.getCell(2)).replace("/", ""));
		                JSONObject object;
		                for(int city=0;city<cityJsonArray.toList().size();city++) {
		            		object = cityJsonArray.getJSONObject(city);
		            		if(object.get("name").toString().indexOf(getCellValue(row.getCell(3)))!=-1) {
		            			data.setExecutionCity(object.get("code").toString());
		            			break;
		            		}
		            	}
		                
		                data.setExecutionTime(getCellValue(row.getCell(4)));
		                data.setSubject(getCellValue(row.getCell(5)));
		                data.setIntroduction(getCellValue(row.getCell(6)));
		                data.setSpeakerName(getCellValue(row.getCell(7)));
		                if(!getCellValue(row.getCell(8)).toString().matches("[0-9]+(\\.[0-9]{1})?")) {
		                	throw new NumberFormatException();
		                }
		                data.setTeachingHours(Double.valueOf(getCellValue(row.getCell(8)).toString()));
		                if(!getCellValue(row.getCell(9)).toString().matches("[0-9]+(\\.[0])?")) {
		                	throw new NumberFormatException();
		                }
		                data.setParticipateNumber(Integer.valueOf(getCellValue(row.getCell(9)).replace(".0","")));
		                data.setParticipatePeople(getCellValue(row.getCell(10)));
		                
		                list.add(data);
		            }
		            else
		            {
		            	break;
		            }
		        }
	        }catch(NumberFormatException e) {
	        	checkFile=false;
	        	response.setContentType("text/html;charset=UTF-8");
	        	logger.warn(e.getMessage());
				try {
					response.resetBuffer();
					response.getWriter().print("excel fail");
				} catch (IOException e1) {
					logger.warn(e1.getMessage());
				}
	        }
	        if(checkFile)
	        {
	        	logger.info("刪除舊資料");
	        	delRetirementAdvancedAgeExperienceInheritanceSchedulebyId(request, response, new RetirementAdvancedAgeExperienceInheritanceSchedule(),applyId);
		        logger.info("刪除finish");
		        
		        RetirementAdvancedAgeExperienceInheritanceSchedule[] dataList = list.toArray(new RetirementAdvancedAgeExperienceInheritanceSchedule[list.size()]);
		        addRetirementAdvancedAgeExperienceInheritanceSchedule(request,response,dataList,applyId);
		        //刪除舊檔
				api.httpPost(ip+"deleteFile",json);
				//檔案儲存
				api.httpPost(ip+"fileUplolad",json);
		        try {
					workbook.close();
				} catch (IOException e1) {
					logger.warn(e1.getMessage());
				}
				response.setContentType("text/html;charset=UTF-8");
				try {
					response.resetBuffer();
					response.getWriter().print("success");
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }
		}else {
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.resetBuffer();
				response.getWriter().print("fail");
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	public void delRetirementAdvancedAgeExperienceInheritanceSchedulebyId(HttpServletRequest request, HttpServletResponse response
			,RetirementAdvancedAgeExperienceInheritanceSchedule schedule,String applyId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(applyId));
		try {
			json = objectMapper.writeValueAsString(schedule);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delRetirementAdvancedAgeExperienceInheritanceSchedulebyId",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	public void addRetirementAdvancedAgeExperienceInheritanceSchedule(HttpServletRequest request, HttpServletResponse response
			,@RequestBody RetirementAdvancedAgeExperienceInheritanceSchedule[] schedule,String applyId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<schedule.length;i++)
			{
				schedule[i].setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(applyId));
				try {
					json = objectMapper.writeValueAsString(schedule[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addRetirementAdvancedAgeExperienceInheritanceSchedule",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/addRetirementAdvancedAgeParticipateStudentFromFile", method = RequestMethod.POST)
	public void addRetirementAdvancedAgeParticipateStudentFromFile(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			) { 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		String applyId=session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString();
		
		String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		if (!extension.toLowerCase().trim().equals("xlsx") && !extension.toLowerCase().trim().equals("xls"))
        {
			logger.warn("addRetirementAdvancedAgeParticipateStudentFromFile 檔案格式錯誤");
			checkFile=false;
        }
		if(checkFile) {
			Attachment attach = new Attachment();
			attach.setFileBelong("B");
			attach.setFileBelongId(Integer.valueOf(applyId));
			attach.setFileName(uploadFile.getOriginalFilename());
			attach.setFileFrequency(1);
			attach.setFileType("participate");
			attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
			attach.setFileSize((int)uploadFile.getSize());
			attach.setFileStatus(1);
			
			try {
				json = objectMapper.writeValueAsString(attach);
			} catch (JsonProcessingException e1) {
				logger.warn(e1.getMessage());
			}
			
			//檔案上傳
			try {
				SaveFileFromInputStream(uploadFile.getInputStream(),attach.getFilePath(),uploadFile.getOriginalFilename());
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
			
	        String destFileName=localPath+attach.getFilePath()+"/"+uploadFile.getOriginalFilename();
	        
	        File destFile=null;
			try {
				destFile = new File(destFileName).getCanonicalFile();
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
	        try {
				uploadFile.transferTo(destFile);
			} catch (IllegalStateException e) {
				logger.warn(e.getMessage());
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
	        
	        Sheet sheet;
	 
	        Workbook workbook = null;
	        FileInputStream inputStream = null;
	        try {
	            workbook= new XSSFWorkbook(destFile);
	        } catch (IOException ex) {
	        	try {
					inputStream=new FileInputStream(destFileName);
					workbook = new HSSFWorkbook(inputStream);
				} catch (FileNotFoundException e) {
					logger.warn(e.getMessage());
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	            
	        }catch (InvalidFormatException ex) {
	        	try {
					inputStream=new FileInputStream(destFileName);
					workbook = new HSSFWorkbook(inputStream);
				} catch (FileNotFoundException e) {
					logger.warn(e.getMessage());
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }finally {
	        	try {
	        		if(inputStream != null) {
	        			inputStream.close();
	        		}
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }
	        
	        sheet = workbook.getSheetAt(0);
	 
	        int totalRowNum = sheet.getLastRowNum();
	 
	        
	        List<RetirementAdvancedAgeParticipateStudent> list = new ArrayList<RetirementAdvancedAgeParticipateStudent>();
	        RetirementAdvancedAgeParticipateStudent data;
	        try {
		        for(int i=2;i<=totalRowNum;i++){
		        	data = new RetirementAdvancedAgeParticipateStudent();
		            Row row = sheet.getRow(i);
		            if(row!=null && !getCellValue(row.getCell(1)).equals("")){
		                
		            	data.setName(getCellValue(row.getCell(1)));
		            	if(!getCellValue(row.getCell(3)).replace("/", "").matches("[0-9]{7}")) {
		                	throw new NumberFormatException();
		                }
		                if(getCellValue(row.getCell(2)).equals("勞工保險")){
		                	data.setLaborProtectionTime(getCellValue(row.getCell(3)).replace("/", ""));
		                }
		                else if(getCellValue(row.getCell(2)).equals("職災保險")) {
		                	data.setOccupationalAccidentProtectionTime(getCellValue(row.getCell(3)).replace("/", ""));
		                }
		                if(!getCellValue(row.getCell(4)).toString().matches("[0-9]+(\\.[0])?")) {
		                	throw new NumberFormatException();
		                }
		                data.setSeniority(Integer.valueOf(getCellValue(row.getCell(4)).replace(".0","")));
		                if(Integer.valueOf(getCellValue(row.getCell(5)).toString().replace(".0",""))>12) {
		                	throw new NumberFormatException();
		                }
		                data.setSeniorityMonth(Integer.valueOf(getCellValue(row.getCell(5)).replace(".0","")));
		                if(getCellValue(row.getCell(6)).equals("主管")) {
		                	data.setManager("Y");
		                }
		                else if(getCellValue(row.getCell(6)).equals("非主管")) {
		                	data.setManager("N");
		                }
		                data.setDepartment(getCellValue(row.getCell(7)));
		                if(getCellValue(row.getCell(8)).equals("全時")) {
		                	data.setWorkingHours("A");
		                }
		                else if(getCellValue(row.getCell(8)).equals("部分工時")) {
		                	data.setWorkingHours("P");
		                }
		                
		                list.add(data);
		            }
		            else
		            {
		            	break;
		            }
		        }
	        }catch(NumberFormatException e) {
	        	checkFile=false;
	        	response.setContentType("text/html;charset=UTF-8");
	        	logger.warn(e.getMessage());
				try {
					response.resetBuffer();
					response.getWriter().print("excel fail");
				} catch (IOException e1) {
					logger.warn(e1.getMessage());
				}
	        }
	        if(checkFile)
	        {
	        	logger.info("刪除舊資料");
	        	delRetirementAdvancedAgeParticipateStudentbyId(request, response, new RetirementAdvancedAgeParticipateStudent(),applyId);
		        logger.info("刪除finish");
		        
		        RetirementAdvancedAgeParticipateStudent[] dataList = list.toArray(new RetirementAdvancedAgeParticipateStudent[list.size()]);
		        addRetirementAdvancedAgeParticipateStudent(request,response,dataList,applyId);
		        //刪除舊檔
				api.httpPost(ip+"deleteFile",json);
				//檔案儲存
				api.httpPost(ip+"fileUplolad",json);
		        try {
					workbook.close();
				} catch (IOException e1) {
					logger.warn(e1.getMessage());
				}
				response.setContentType("text/html;charset=UTF-8");
				try {
					response.resetBuffer();
					response.getWriter().print("success");
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }
		}else {
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.resetBuffer();
				response.getWriter().print("fail");
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	

	public void delRetirementAdvancedAgeParticipateStudentbyId(HttpServletRequest request, HttpServletResponse response
			,RetirementAdvancedAgeParticipateStudent participate,String applyId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		participate.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(applyId));
		try {
			json = objectMapper.writeValueAsString(participate);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delRetirementAdvancedAgeParticipateStudentbyId",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	public void addRetirementAdvancedAgeParticipateStudent(HttpServletRequest request, HttpServletResponse response
			,@RequestBody RetirementAdvancedAgeParticipateStudent[] participate,String applyId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<participate.length;i++)
			{
				participate[i].setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(applyId));
				try {
					json = objectMapper.writeValueAsString(participate[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addRetirementAdvancedAgeParticipateStudent",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritanceExpenditureFromFile", method = RequestMethod.POST)
	public void addRetirementAdvancedAgeExperienceInheritanceExpenditureFromFile(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			) { 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		String applyId=session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString();
		
		String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		if (!extension.toLowerCase().trim().equals("xlsx") && !extension.toLowerCase().trim().equals("xls"))
        {
			logger.warn("addRetirementAdvancedAgeExperienceInheritanceExpenditureFromFile 檔案格式錯誤");
			checkFile=false;
        }
		if(checkFile) {
			Attachment attach = new Attachment();
			attach.setFileBelong("B");
			attach.setFileBelongId(Integer.valueOf(applyId));
			attach.setFileName(uploadFile.getOriginalFilename());
			attach.setFileFrequency(1);
			attach.setFileType("expenditure");
			attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
			attach.setFileSize((int)uploadFile.getSize());
			attach.setFileStatus(1);
			
			try {
				json = objectMapper.writeValueAsString(attach);
			} catch (JsonProcessingException e1) {
				logger.warn(e1.getMessage());
			}
			
			//檔案上傳
			try {
				SaveFileFromInputStream(uploadFile.getInputStream(),attach.getFilePath(),uploadFile.getOriginalFilename());
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
			
	        String destFileName=localPath+attach.getFilePath()+"/"+uploadFile.getOriginalFilename();
	        
	        File destFile=null;
			try {
				destFile = new File(destFileName).getCanonicalFile();
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
	        try {
				uploadFile.transferTo(destFile);
			} catch (IllegalStateException e) {
				logger.warn(e.getMessage());
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
	        
	        Sheet sheet;
	 
	        Workbook workbook = null;
	        FileInputStream inputStream = null;
	        try {
	            workbook= new XSSFWorkbook(destFile);
	        } catch (IOException ex) {
	        	try {
					inputStream=new FileInputStream(destFileName);
					workbook = new HSSFWorkbook(inputStream);
				} catch (FileNotFoundException e) {
					logger.warn(e.getMessage());
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	            
	        }catch (InvalidFormatException ex) {
	        	try {
					inputStream=new FileInputStream(destFileName);
					workbook = new HSSFWorkbook(inputStream);
				} catch (FileNotFoundException e) {
					logger.warn(e.getMessage());
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }finally {
	        	try {
	        		if(inputStream != null) {
	        			inputStream.close();
	        		}
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }
	        
	        sheet = workbook.getSheetAt(0);
	 
	        int totalRowNum = sheet.getLastRowNum();
	 
	        
	        List<RetirementAdvancedAgeExperienceInheritanceExpenditure> list = new ArrayList<RetirementAdvancedAgeExperienceInheritanceExpenditure>();
	        RetirementAdvancedAgeExperienceInheritanceExpenditure data;
	        try {
		        for(int i=2;i<=totalRowNum;i++){
		        	data = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
		            Row row = sheet.getRow(i);
		            if(row!=null && !getCellValue(row.getCell(1)).equals("")){
		                
		                data.setPlanName(getCellValue(row.getCell(1)));
		                data.setUnitPrice(Integer.valueOf(getCellValue(row.getCell(2)).replace(".0","")));
		                data.setAmount(Integer.valueOf(getCellValue(row.getCell(3)).replace(".0","")));
		                data.setAmounts(Integer.valueOf(getCellValue(row.getCell(5)).replace(".0","")));
		                data.setDescription(getCellValue(row.getCell(6)).toString());
		                list.add(data);
		            }
		            else
		            {
		            	break;
		            }
		        }
	        }catch(NumberFormatException e) {
	        	checkFile=false;
	        	response.setContentType("text/html;charset=UTF-8");
	        	logger.warn(e.getMessage());
				try {
					response.resetBuffer();
					response.getWriter().print("excel fail");
				} catch (IOException e1) {
					logger.warn(e1.getMessage());
				}
	        }
	        if(checkFile)
	        {
	        	logger.info("刪除舊資料");
		        delRetirementAdvancedAgeExperienceInheritanceExpenditurebyId(request, response, new RetirementAdvancedAgeExperienceInheritanceExpenditure(),applyId);
		        logger.info("刪除finish");
		        
		        RetirementAdvancedAgeExperienceInheritanceExpenditure[] dataList = list.toArray(new RetirementAdvancedAgeExperienceInheritanceExpenditure[list.size()]);
		        addRetirementAdvancedAgeExperienceInheritanceExpenditure(request,response,dataList,applyId);
		        //刪除舊檔
				api.httpPost(ip+"deleteFile",json);
				//檔案儲存
				api.httpPost(ip+"fileUplolad",json);
		        try {
					workbook.close();
				} catch (IOException e1) {
					logger.warn(e1.getMessage());
				}
				response.setContentType("text/html;charset=UTF-8");
				try {
					response.resetBuffer();
					response.getWriter().print("success");
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
	        }
		}else {
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.resetBuffer();
				response.getWriter().print("fail");
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}

	public void delRetirementAdvancedAgeExperienceInheritanceExpenditurebyId(HttpServletRequest request, HttpServletResponse response
			,RetirementAdvancedAgeExperienceInheritanceExpenditure list,String applyId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		list.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(applyId));
		try {
			json = objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delRetirementAdvancedAgeExperienceInheritanceExpenditurebyId",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	public void addRetirementAdvancedAgeExperienceInheritanceExpenditure(HttpServletRequest request, HttpServletResponse response
			,@RequestBody RetirementAdvancedAgeExperienceInheritanceExpenditure[] list,String applyId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(applyId));
				try {
					json = objectMapper.writeValueAsString(list[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addRetirementAdvancedAgeExperienceInheritanceExpenditure",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceApplyRegisterFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceApplyRegisterFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="registerFiles", required=false) MultipartFile[] registerFiles){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(registerFiles !=null) {
			for(int i=0;i<registerFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(registerFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceApplyRegisterFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length+1);
					}
					
					attach.setFileBelong("B");
					attach.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
					attach.setFileName(registerFiles[i].getOriginalFilename());
					attach.setFileType("register");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)registerFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(registerFiles[i].getInputStream(),attach.getFilePath(),registerFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceApplySpeakerRetirementFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceApplySpeakerRetirementFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="speakerRetirementFiles", required=false) MultipartFile[] speakerRetirementFiles){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(speakerRetirementFiles !=null) {
			for(int i=0;i<speakerRetirementFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(speakerRetirementFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceApplySpeakerRetirementFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length+1);
					}
					
					attach.setFileBelong("B");
					attach.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
					attach.setFileName(speakerRetirementFiles[i].getOriginalFilename());
					attach.setFileType("speakerRetirement");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)speakerRetirementFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(speakerRetirementFiles[i].getInputStream(),attach.getFilePath(),speakerRetirementFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceApplySpeakerExperienceFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceApplySpeakerExperienceFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="speakerExperienceFiles", required=false) MultipartFile[] speakerExperienceFiles){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(speakerExperienceFiles !=null) {
			for(int i=0;i<speakerExperienceFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(speakerExperienceFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceApplySpeakerExperienceFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length+1);
					}
					
					attach.setFileBelong("B");
					attach.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
					attach.setFileName(speakerExperienceFiles[i].getOriginalFilename());
					attach.setFileType("speakerExperience");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)speakerExperienceFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(speakerExperienceFiles[i].getInputStream(),attach.getFilePath(),speakerExperienceFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceApplyEmploymentFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceApplyEmploymentFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="employmentFiles", required=false) MultipartFile[] employmentFiles){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(employmentFiles !=null) {
			for(int i=0;i<employmentFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(employmentFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceApplyEmploymentFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length+1);
					}
					
					attach.setFileBelong("B");
					attach.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
					attach.setFileName(employmentFiles[i].getOriginalFilename());
					attach.setFileType("employment");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)employmentFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(employmentFiles[i].getInputStream(),attach.getFilePath(),employmentFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceApplyNecessaryFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceApplyNecessaryFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="necessaryFiles", required=false) MultipartFile[] necessaryFiles){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(necessaryFiles !=null) {
			for(int i=0;i<necessaryFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(necessaryFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceApplyNecessaryFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length+1);
					}
					
					attach.setFileBelong("B");
					attach.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
					attach.setFileName(necessaryFiles[i].getOriginalFilename());
					attach.setFileType("necessary");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)necessaryFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(necessaryFiles[i].getInputStream(),attach.getFilePath(),necessaryFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	public AdvancedAgeBase selectBTypeAdvancedAgeBase(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectBTypeAdvancedAgeBase", json));
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (array.length()>0) {
				searchBase = mapper.readValue(array.getJSONObject(0).toString(), AdvancedAgeBase.class);}
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchBase;
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceApprovedFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceApprovedFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="approvedFiles", required=false) MultipartFile[] approvedFiles,
			@RequestParam(value="baseId", required=false) String baseId){
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(approvedFiles !=null) {
			for(int i=0;i<approvedFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(approvedFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceApprovedFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(approvedFiles[i].getOriginalFilename());
					attach.setFileType("approved");
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getAllowanceFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getAllowanceFileStatusRecord().split(";").length+1);
					}
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)approvedFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(approvedFiles[i].getInputStream(),attach.getFilePath(),approvedFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceReceiptFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceReceiptFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="receiptFiles", required=false) MultipartFile[] receiptFiles,
			@RequestParam(value="baseId", required=false) String baseId){
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(receiptFiles !=null) {
			for(int i=0;i<receiptFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(receiptFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceReceiptFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(receiptFiles[i].getOriginalFilename());
					attach.setFileType("receipt");
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getAllowanceFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getAllowanceFileStatusRecord().split(";").length+1);
					}
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)receiptFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(receiptFiles[i].getInputStream(),attach.getFilePath(),receiptFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceResultFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceResultFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="resultFiles", required=false) MultipartFile[] resultFiles,
			@RequestParam(value="baseId", required=false) String baseId){
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(resultFiles !=null) {
			for(int i=0;i<resultFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(resultFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceResultFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(resultFiles[i].getOriginalFilename());
					attach.setFileType("result");
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getAllowanceFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getAllowanceFileStatusRecord().split(";").length+1);
					}
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)resultFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(resultFiles[i].getInputStream(),attach.getFilePath(),resultFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceExpenditureFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceExpenditureFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="expenditureFiles", required=false) MultipartFile[] expenditureFiles,
			@RequestParam(value="baseId", required=false) String baseId){
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(expenditureFiles !=null) {
			for(int i=0;i<expenditureFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(expenditureFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceExpenditureFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(expenditureFiles[i].getOriginalFilename());
					attach.setFileType("expenditure");
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getAllowanceFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getAllowanceFileStatusRecord().split(";").length+1);
					}
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)expenditureFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(expenditureFiles[i].getInputStream(),attach.getFilePath(),expenditureFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceSpeakerFeeFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceSpeakerFeeFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="speakerFeeFiles", required=false) MultipartFile[] speakerFeeFiles,
			@RequestParam(value="baseId", required=false) String baseId){
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(speakerFeeFiles !=null) {
			for(int i=0;i<speakerFeeFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(speakerFeeFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceSpeakerFeeFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(speakerFeeFiles[i].getOriginalFilename());
					attach.setFileType("speakerFee");
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getAllowanceFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getAllowanceFileStatusRecord().split(";").length+1);
					}
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)speakerFeeFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(speakerFeeFiles[i].getInputStream(),attach.getFilePath(),speakerFeeFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/retirementAdvancedAgeExperienceInheritanceNecessaryFileUplolad", method = RequestMethod.POST)
	public void retirementAdvancedAgeExperienceInheritanceNecessaryFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="necessaryFiles", required=false) MultipartFile[] necessaryFiles,
			@RequestParam(value="baseId", required=false) String baseId){
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(necessaryFiles !=null) {
			for(int i=0;i<necessaryFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(necessaryFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") && !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("retirementAdvancedAgeExperienceInheritanceSpeakerFeeFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(necessaryFiles[i].getOriginalFilename());
					attach.setFileType("necessary");
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					AdvancedAgeBase result=selectBTypeAdvancedAgeBase(base);
					if(result.getAllowanceFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getAllowanceFileStatusRecord().split(";").length+1);
					}
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)necessaryFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(necessaryFiles[i].getInputStream(),attach.getFilePath(),necessaryFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile=false;
					break;
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if(checkFile){
					response.getWriter().print("success");
				}
				else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	public String getCellValue(Cell cell) {
		String cellValue="";
        if(cell!=null){
            switch (cell.getCellType()) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                default:
                    cellValue = "";
                    break;
            }

        }
		return cellValue;
	}
	
	public void SaveFileFromInputStream(InputStream stream,String path,String filename){  
		File directory;
		try {
			directory = new File(localPath+path+"/"+filename).getCanonicalFile();
			//路徑是否存在
			if (!directory.getParentFile().exists()) {
			    try {
			    	boolean checkPFile = directory.getParentFile().mkdirs();
			    	if(checkPFile)
			    	{
			    		directory.createNewFile();
			    	}
			    } catch (IOException e) {
			    	logger.warn(e.getMessage());
			    }
			}
		} catch (IOException e1) {
			logger.warn(e1.getMessage());
		}
		
		//存檔
        FileOutputStream fs=null;
		try {
			fs = new FileOutputStream(localPath+path+"/"+filename);
			byte[] buffer =new byte[1024*1024];
	        int byteread = 0; 
	        while ((byteread=stream.read(buffer))!=-1)
	        {
	           fs.write(buffer,0,byteread);
	           fs.flush();
	        } 
		} catch (FileNotFoundException e) {
			logger.warn(e.getMessage());
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}finally {
			try {
				if(fs != null) {
					fs.close();
				}
				if(stream != null) {
					stream.close(); 
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
			
		}
        
             
    }
}