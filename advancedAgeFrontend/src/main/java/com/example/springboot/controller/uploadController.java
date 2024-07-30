package com.example.springboot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.example.springboot.entity.AdvancedAgePlan;
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
public class uploadController {
	
	Logger logger = LogManager.getLogger(AttachmentController.class);
	
	CallApi api = new CallApi();
	
	HttpSession session;
	
	@Value("${api_ip}")
	private String ip;
	
	@Value("${file_path}")
	private String localPath;
	
	@RequestMapping(value = "/upload")
	public String employ() {
		return "upload";
	}
	
	@RequestMapping(value = "/addOldData", method = RequestMethod.POST)
	public void addOldData(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			,@RequestParam(value="year", required=false) String year
			) { 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		if (!extension.toLowerCase().trim().equals("xlsx") && !extension.toLowerCase().trim().equals("xls"))
        {
			logger.warn("addOldData 檔案格式錯誤");
			checkFile=false;
        }
		if(checkFile) {
			//檔案上傳
			try {
				SaveFileFromInputStream(uploadFile.getInputStream(),"/upload",uploadFile.getOriginalFilename());
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
			
	        String destFileName=localPath+"/upload/"+uploadFile.getOriginalFilename();
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
	 
	        AdvancedAgeBase uploadBase;
	        AdvancedAgeApply uploadApply;
	        AdvancedAgePlan uploadPlan;
		     // 行業別列表
			JSONArray industryJsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
			// 縣市列表
			JSONArray cityJsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
			
			JSONObject object;
			
			Date date = null; 
			
        	String tempData;
        	
	        try {
		        for(int i=1;i<=totalRowNum;i++){
//	        	for(int i=1;i<=1;i++){
		            Row row = sheet.getRow(i);
		            uploadBase = new AdvancedAgeBase();
		            uploadApply = new AdvancedAgeApply();
		            uploadPlan = new AdvancedAgePlan();
		            if(row!=null && !getCellValue(row.getCell(0)).equals("")){
		            	uploadBase.setYear(year);
		            	uploadBase.setCaseType("A");
		            	uploadApply.setApplyYear(year);
		            	uploadBase.setAaid(getCellValue(row.getCell(0)));
		            	
		            	uploadBase.setSeq(getCellValue(row.getCell(8)));
		            	uploadApply.setSeq(getCellValue(row.getCell(8)));
		            	uploadBase.setCompanyName(getCellValue(row.getCell(9)));
		            	uploadApply.setCompanyName(getCellValue(row.getCell(9)));
		            	uploadPlan.setCompanyName(getCellValue(row.getCell(9)));
		            	//行業別
		            	for(int industry=0;industry<industryJsonArray.toList().size();industry++) {
		            		object = industryJsonArray.getJSONObject(industry);
		            		if(object.get("name").toString().indexOf(getCellValue(row.getCell(10)))!=-1) {
		            			uploadApply.setIndustry(object.get("code").toString());
		            			break;
		            		}
		            	}
		            	if(!getCellValue(row.getCell(11)).equals(""))
		            		uploadPlan.setEmploymentNumber(Integer.valueOf(getCellValue(row.getCell(11))));
		            	
	            		uploadApply.setContactName(getCellValue(row.getCell(12)));
	            		uploadApply.setRegisterPostalCode(getCellValue(row.getCell(13)));
		            	
		            	//縣市
		            	for(int city=0;city<cityJsonArray.toList().size();city++) {
		            		object = cityJsonArray.getJSONObject(city);
		            		if(object.get("name").toString().indexOf(getCellValue(row.getCell(14)))!=-1) {
		            			uploadApply.setRegisterCity(object.get("code").toString());
		            			uploadBase.setCity(object.get("code").toString());
		            			break;
		            		}
		            	}
		            	JSONArray areaJsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + uploadApply.getRegisterCity(),""));
		            	//鄉鎮市區
		            	for(int area=0;area<areaJsonArray.toList().size();area++) {
		            		object = areaJsonArray.getJSONObject(area);
		            		if(object.get("name").toString().indexOf(getCellValue(row.getCell(15)))!=-1) {
		            			uploadApply.setRegisterArea(object.get("code").toString());
		            			break;
		            		}
		            	}
		            	uploadApply.setRegisterAddress(getCellValue(row.getCell(16)));
		            	//縣市
		            	for(int city=0;city<cityJsonArray.toList().size();city++) {
		            		object = cityJsonArray.getJSONObject(city);
		            		if(object.get("name").toString().indexOf(getCellValue(row.getCell(17)))!=-1) {
		            			uploadApply.setContactCity(object.get("code").toString());
		            			break;
		            		}
		            	}
		            	areaJsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + uploadApply.getContactCity(),""));
		            	//鄉鎮市區
		            	for(int area=0;area<areaJsonArray.toList().size();area++) {
		            		object = areaJsonArray.getJSONObject(area);
		            		if(object.get("name").toString().indexOf(getCellValue(row.getCell(18)))!=-1) {
		            			uploadApply.setContactArea(object.get("code").toString());
		            			break;
		            		}
		            	}
		            	uploadApply.setContactAddress(getCellValue(row.getCell(19)));
		            	uploadApply.setContactName(getCellValue(row.getCell(20)));
		            	uploadApply.setContactJobtitle(getCellValue(row.getCell(21)));
		            	tempData=getCellValue(row.getCell(22));
		            	if(!tempData.equals("") && tempData.indexOf("-")!=-1) {
			            	uploadApply.setContactWorkPhoneAreaCode(tempData.substring(0,tempData.indexOf("-")));
			            	uploadApply.setContactWorkPhone(tempData.substring(tempData.indexOf("-")+1));
			            	uploadApply.setContactWorkPhoneExtension(getCellValue(row.getCell(23)));
		            	}
		            	uploadApply.setContactPhone(getCellValue(row.getCell(24)).replace("-", ""));
		            	tempData=getCellValue(row.getCell(25));
		            	if(!tempData.equals("") && tempData.indexOf("-")!=-1) {
			            	uploadApply.setFaxAreaCode(tempData.substring(0,tempData.indexOf("-")));
			            	uploadApply.setFax(tempData.substring(tempData.indexOf("-")+1));
		            	}
		            	uploadApply.setEmail(getCellValue(row.getCell(26)));
		            	
//		            	tempData=getCellValue(row.getCell(27));
//		            	tempData=String.valueOf((Integer.valueOf(tempData.substring(0, 3))+1911))+tempData.substring(3);
//		            	try {
//							date=new SimpleDateFormat("yyyy/MM/dd").parse(tempData);
//							uploadApply.setCreateTime(date);
//							uploadBase.setCreateTime(date);
//						} catch (ParseException e) {
//							System.out.println(uploadApply.getSeq()+" 申請日期有誤 :"+date +" before change:"+tempData);
//							break;
//						} 
		            	if(!getCellValue(row.getCell(28)).equals(""))
		            		uploadPlan.setNearHighEmploymentNumber(Integer.valueOf(getCellValue(row.getCell(28))));
		            	if(!getCellValue(row.getCell(29)).equals(""))
		            		uploadPlan.setContinueEmploymentNumber(Integer.valueOf(getCellValue(row.getCell(29))));
		            		uploadBase.setCheckEmploymentPerson(Integer.valueOf(getCellValue(row.getCell(29))));
		            	if(!getCellValue(row.getCell(28)).equals("") && !getCellValue(row.getCell(29)).equals(""))
		            		uploadPlan.setContinueEmploymentPercentage(Double.valueOf(Math.round(Double.valueOf(uploadPlan.getContinueEmploymentNumber())/Double.valueOf(uploadPlan.getNearHighEmploymentNumber())*1000))/10);
		            	if(getCellValue(row.getCell(31)).equals("通過")) {
		            		uploadBase.setCaseStatus("4");
		            	}else if(getCellValue(row.getCell(30)).equals("通過")){
		            		uploadBase.setCaseStatus("3");
		            	}else if(getCellValue(row.getCell(30)).equals("未通過")) {
		            		uploadBase.setCaseStatus("2");
		            	}
		            	if(!getCellValue(row.getCell(33)).equals(""))
		            		uploadBase.setCheckEmploymentPerson(Integer.valueOf(getCellValue(row.getCell(33))));
//		            	uploadBase.setCaseDescription(getCellValue(row.getCell(34)));
//		            	if(uploadBase.getCaseDescription().equals("")) {
		            		uploadBase.setCaseDescription(getCellValue(row.getCell(35)));
//		            	}else {
//		            		uploadBase.setCaseDescription(uploadBase.getCaseDescription()+"\n"+getCellValue(row.getCell(35)));
//		            	}
		            	if(getCellValue(row.getCell(37)).equals("有")) {
		            		uploadApply.setMultipleCompany("Y");
		            	}else {
		            		uploadApply.setMultipleCompany("N");
		            	}
		            	if(getCellValue(row.getCell(38)).equals("是")) {
		            		uploadApply.setWorkersEmployment("Y");
		            	}else {
		            		uploadApply.setWorkersEmployment("N");
		            	}
		            	if(getCellValue(row.getCell(39)).equals("是")) {
		            		uploadApply.setRelatives("Y");
		            	}else {
		            		uploadApply.setRelatives("N");
		            	}
		            	if(getCellValue(row.getCell(40)).equals("有")) {
		            		uploadApply.setRelatedAmounts("Y");
		            	}else {
		            		uploadApply.setRelatedAmounts("N");
		            	}
		            	if(getCellValue(row.getCell(41)).equals("同意")) {
		            		uploadApply.setNotMandatory("Y");
		            	}else {
		            		uploadApply.setNotMandatory("N");
		            	}
		            	tempData=getCellValue(row.getCell(48)).replace("/","");
		            	if(tempData.length()==6) {
		            		tempData="0"+tempData;
		            	}
		            	uploadPlan.setCompanyCreateTime(tempData);
		            	uploadPlan.setItems(getCellValue(row.getCell(49)));
		            	if(!getCellValue(row.getCell(50)).equals("")) {
		            		uploadPlan.setHighEmploymentNumber(Integer.valueOf(getCellValue(row.getCell(50))));
		            	}
		            	if(!getCellValue(row.getCell(51)).equals("")) {
		            		uploadPlan.setMiddleEmploymentNumber(Integer.valueOf(getCellValue(row.getCell(51))));
		            	}
		            	if(!getCellValue(row.getCell(52)).equals("")) {
		            		uploadPlan.setLowEmploymentNumber(Integer.valueOf(getCellValue(row.getCell(52))));
		            	}
//		            	uploadPlan.setFriendlyMeasures(getCellValue(row.getCell(53)));
//		            	uploadPlan.setAssistanceMeasures(getCellValue(row.getCell(54)));
//		            	uploadPlan.setExpectedMeasuresEffectiveness(getCellValue(row.getCell(55)));
		            	
		            	addAdvancedAgeApply(uploadApply);
		            	addAdvancedAgePlan(uploadPlan);
		            	addAdvancedAgeBase(uploadBase);
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
		        
//		        RetirementAdvancedAgeParticipateStudent[] dataList = list.toArray(new RetirementAdvancedAgeParticipateStudent[list.size()]);
//		        addRetirementAdvancedAgeParticipateStudent(request,response,dataList,applyId);
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
	
	@RequestMapping(value = "/addOldEmployment", method = RequestMethod.POST)
	public void addOldEmployment(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			,@RequestParam(value="year", required=false) String year
			) { 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		if (!extension.toLowerCase().trim().equals("xlsx") && !extension.toLowerCase().trim().equals("xls"))
        {
			logger.warn("addOldEmployment 檔案格式錯誤");
			checkFile=false;
        }
		if(checkFile) {
			//檔案上傳
			try {
				SaveFileFromInputStream(uploadFile.getInputStream(),"/uploadEmployment",uploadFile.getOriginalFilename());
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
			
	        String destFileName=localPath+"/uploadEmployment/"+uploadFile.getOriginalFilename();
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
	        
	        sheet = workbook.getSheetAt(1);
	 
	        int totalRowNum = sheet.getLastRowNum();
	 
	        AdvancedAgeEmploymentList employment;
		    
			JSONObject object;
			
			Date date = null; 
			
        	String tempData;
        	
	        try {
		        for(int i=1;i<=totalRowNum;i++){
//	        	for(int i=1;i<=1;i++){
		            Row row = sheet.getRow(i);
		            employment = new AdvancedAgeEmploymentList();
		            if(row!=null && !getCellValue(row.getCell(0)).equals("") && !getCellValue(row.getCell(6)).equals("")){
		            	employment.setEmployeeId(getCellValue(row.getCell(0)));
		            	employment.setIdentification(getCellValue(row.getCell(6)));
		            	employment.setName(getCellValue(row.getCell(7)));
		            	if(getCellValue(row.getCell(8)).replace("/", "").length()==6)
		            	{
		            		employment.setBirthday("0"+getCellValue(row.getCell(8)).replace("/", ""));
		            	}
		            	else {
		            		employment.setBirthday(getCellValue(row.getCell(8)).replace("/", ""));
		            	}
		            	
		            	addAdvancedAgeEmployment(employment);
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
		        
//		        RetirementAdvancedAgeParticipateStudent[] dataList = list.toArray(new RetirementAdvancedAgeParticipateStudent[list.size()]);
//		        addRetirementAdvancedAgeParticipateStudent(request,response,dataList,applyId);
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
	
	public int addAdvancedAgeApply(AdvancedAgeApply apply){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(apply);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"addApply",json));
		return Integer.valueOf(object.get("id").toString());
	}
	
	public void addAdvancedAgePlan(AdvancedAgePlan plan){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(plan);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"addPlan",json));
	}
	
	public void addAdvancedAgeBase(AdvancedAgeBase base){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"addAdvancedAgeBase",json);
		
	}
	
	public void addAdvancedAgeEmployment(AdvancedAgeEmploymentList employment){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		
		try {
			json = objectMapper.writeValueAsString(employment);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"addEmployment",json);
		
	}
	
	public String getCellValue(Cell cell) {
		String cellValue="";
        if(cell!=null){
            switch (cell.getCellType()) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    cellValue = String.valueOf((int)cell.getNumericCellValue());
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