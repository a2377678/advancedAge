package com.example.springboot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicData;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitList;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditure;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.Parameter;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

@Controller
public class Attachment3Controller {

	Logger logger = LogManager.getLogger(AttachmentController.class);

	CallApi api = new CallApi();

	HttpSession session;

	@Value("${api_ip}")
	private String ip;

	@Value("${file_path}")
	private String localPath;

	AdvancedAgeBase base;
	
	AdvancedAgeRetirementReemploymentBenefitList advancedAgeRetirementReemploymentBenefitList;

	AdvancedAgeRetirementReemploymentExpenditure advancedAgeRetirementReemploymentExpenditure;
	
	String jsondata;

	private AdvancedAgeRetirementReemploymentBasicData advancedAgeRetirementReemploymentBasicData;

	@RequestMapping(value = "/advancedAgeRetirementReemploymentApplyRegisterFileUplolad", method = RequestMethod.POST)
	public void advancedAgeRetirementReemploymentApplyRegisterFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "registerFiles", required = false) MultipartFile[] registerFiles) {
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		boolean checkFile = true;
		if (registerFiles != null) {
			for (int i = 0; i < registerFiles.length; i++) {
				try {
					String extension = FilenameUtils.getExtension(registerFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png")
							&& !extension.toLowerCase().trim().equals("pdf")
							&& !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip")
							&& !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") 
							&& !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt")) {
						logger.warn("advancedAgeRetirementReemploymentApplyRegisterFileUplolad 檔案格式錯誤");
						throw new Exception("請確認副檔名是否正確!");
					}
					attach = new Attachment();

					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId() + "seq").toString());
					AdvancedAgeBase result = selectCTypeAdvancedAgeBase(base);
					if (result.getFileStatusRecord() == null) {
						attach.setFileFrequency(1);
					} else {
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length + 1);
					}

					attach.setFileBelong("C");
					attach.setFileBelongId(
							Integer.valueOf(session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId").toString()));
					attach.setFileName(registerFiles[i].getOriginalFilename());
					attach.setFileType("register");
					attach.setFilePath("/" + attach.getFileBelong() + "/" + attach.getFileBelongId() + "/"
							+ attach.getFileType() + "/" + attach.getFileFrequency());
					attach.setFileSize((int) registerFiles[i].getSize());
					attach.setFileStatus(1);

					// 寫檔
					SaveFileFromInputStream(registerFiles[i].getInputStream(), attach.getFilePath(),
							registerFiles[i].getOriginalFilename());

					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile = false;
					break;
				} catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile = false;
					break;
				}
				api.httpPost(ip + "fileUplolad", json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if (checkFile) {
					response.getWriter().print("success");
				} else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
			// 申請書附件確認
//			AdvancedAgeApply apply = new AdvancedAgeApply();
//			apply.setSeq(session.getAttribute("attachmentSeq").toString());
//			apply.setAttachDocumentsRegisterProof("Y");
//			addAdvancedAgeApply(request,response,apply);
		}
	}
	
	@RequestMapping(value = "/advancedAgeRetirementReemploymentApplyJointAuthorizeFileUplolad", method = RequestMethod.POST)
	public void advancedAgeRetirementReemploymentApplyJointAuthorizeFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "jointAuthorizeFiles", required = false) MultipartFile[] jointAuthorizeFiles) {
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		boolean checkFile = true;
		if (jointAuthorizeFiles != null) {
			for (int i = 0; i < jointAuthorizeFiles.length; i++) {
				try {
					String extension = FilenameUtils.getExtension(jointAuthorizeFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png")
							&& !extension.toLowerCase().trim().equals("pdf")
							&& !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip")
							&& !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") 
							&& !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt")) {
						logger.warn("advancedAgeRetirementReemploymentApplyJointAuthorizeFileUplolad 檔案格式錯誤");
						throw new Exception("請確認副檔名是否正確!");
					}
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId() + "seq").toString());
					AdvancedAgeBase result = selectCTypeAdvancedAgeBase(base);
					if (result.getFileStatusRecord() == null) {
						attach.setFileFrequency(1);
					} else {
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length + 1);
					}
					
					attach.setFileBelong("C");
					attach.setFileBelongId(
							Integer.valueOf(session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId").toString()));
					attach.setFileName(jointAuthorizeFiles[i].getOriginalFilename());
					attach.setFileType("jointAuthorize");
					attach.setFilePath("/" + attach.getFileBelong() + "/" + attach.getFileBelongId() + "/"
							+ attach.getFileType() + "/" + attach.getFileFrequency());
					attach.setFileSize((int) jointAuthorizeFiles[i].getSize());
					attach.setFileStatus(1);
					
					// 寫檔
					SaveFileFromInputStream(jointAuthorizeFiles[i].getInputStream(), attach.getFilePath(),
							jointAuthorizeFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile = false;
					break;
				} catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile = false;
					break;
				}
				api.httpPost(ip + "fileUplolad", json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if (checkFile) {
					response.getWriter().print("success");
				} else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
			// 申請書附件確認
//			AdvancedAgeApply apply = new AdvancedAgeApply();
//			apply.setSeq(session.getAttribute("attachmentSeq").toString());
//			apply.setAttachDocumentsRegisterProof("Y");
//			addAdvancedAgeApply(request,response,apply);
		}
	}

	@RequestMapping(value = "/advancedAgeRetirementReemploymentApplyNecessaryFileUplolad", method = RequestMethod.POST)
	public void advancedAgeRetirementReemploymentApplyNecessaryFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "necessaryFiles", required = false) MultipartFile[] necessaryFiles) {
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		boolean checkFile = true;
		if (necessaryFiles != null) {
			for (int i = 0; i < necessaryFiles.length; i++) {
				try {
					String extension = FilenameUtils.getExtension(necessaryFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png")
							&& !extension.toLowerCase().trim().equals("pdf")
							&& !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip")
							&& !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") 
							&& !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt")) {
						logger.warn("advancedAgeRetirementReemploymentApplyNecessaryFileUplolad 檔案格式錯誤");
						throw new Exception("請確認副檔名是否正確!");
					}
					attach = new Attachment();

					base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId() + "seq").toString());
					AdvancedAgeBase result = selectCTypeAdvancedAgeBase(base);
					if (result.getFileStatusRecord() == null) {
						attach.setFileFrequency(1);
					} else {
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length + 1);
					}

					attach.setFileBelong("C");
					attach.setFileBelongId(
							Integer.valueOf(session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId").toString()));
					attach.setFileName(necessaryFiles[i].getOriginalFilename());
					attach.setFileType("necessary");
					attach.setFilePath("/" + attach.getFileBelong() + "/" + attach.getFileBelongId() + "/"
							+ attach.getFileType() + "/" + attach.getFileFrequency());
					attach.setFileSize((int) necessaryFiles[i].getSize());
					attach.setFileStatus(1);

					// 寫檔
					SaveFileFromInputStream(necessaryFiles[i].getInputStream(), attach.getFilePath(),
							necessaryFiles[i].getOriginalFilename());

					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					logger.warn(e.getMessage());
					checkFile = false;
					break;
				} catch (Exception e) {
					logger.warn(e.getMessage());
					checkFile = false;
					break;
				}
				api.httpPost(ip + "fileUplolad", json);
			}
			response.setContentType("text/html;charset=UTF-8");
			try {
				if (checkFile) {
					response.getWriter().print("success");
				} else {
					response.getWriter().print("fail");
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
//			session.removeAttribute("attachmentSeq");
			// 此類型檔案上傳為後續新增，AdvancedAgeApply當初沒有欄位紀錄
			// 申請書附件確認
//			AdvancedAgeApply apply = new AdvancedAgeApply();
//			apply.setSeq(session.getAttribute("seq").toString());
//			apply.setAttachDocumentsSalaryProof("Y");
//			apply.setAttachDocumentsOtherProof("Y");
//			addAdvancedAgeApply(request,response,apply);
		}
	}
	
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentBenefitListFromFile", method = RequestMethod.POST)
	public void addAdvancedAgeRetirementReemploymentBenefitListFromFile(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			) { 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		String applyId=session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentApplyId").toString();
		String planId=session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentPlanId").toString();
		
		String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		if (!extension.toLowerCase().trim().equals("xlsx") && !extension.toLowerCase().trim().equals("xls"))
        {
			logger.warn("addAdvancedAgeRetirementReemploymentBenefitListFromFile 檔案格式錯誤");
			checkFile=false;
        }
		if(checkFile) {
			Attachment attach = new Attachment();
			attach.setFileBelong("C");
			attach.setFileBelongId(Integer.valueOf(applyId));
			attach.setFileName(uploadFile.getOriginalFilename());
			attach.setFileFrequency(1);
			attach.setFileType("advancedAgeRetirementReemploymentBenefitList");
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
	 
	        
	        List<AdvancedAgeRetirementReemploymentBenefitList> list = new ArrayList<>();
	        AdvancedAgeRetirementReemploymentBenefitList data;
	        try {
		        for(int i=2;i<=totalRowNum;i++){
		        	data = new AdvancedAgeRetirementReemploymentBenefitList();
		            Row row = sheet.getRow(i);
		            if(row!=null && !getCellValue(row.getCell(1)).equals("")){
		                
		                data.setName(getCellValue(row.getCell(1)));
		                if(getCellValue(row.getCell(2)).replace("/", "").length()!=7) {
		                	throw new NumberFormatException();
		                }
		                data.setBirthday(getCellValue(row.getCell(2)).replace("/", ""));
		                data.setIdentification(getCellValue(row.getCell(3)));
		                if(getCellValue(row.getCell(4)).equals("勞工保險")) {
		                	data.setInsuranceType("L");
		                }else if(getCellValue(row.getCell(4)).equals("職災保險")) {
		                	data.setInsuranceType("Z");
		                }
		                if(getCellValue(row.getCell(5)).replace("/", "").length()!=7) {
		                	throw new NumberFormatException();
		                }
		                data.setInsuranceTime(getCellValue(row.getCell(5)).replace("/", ""));
		                if(getCellValue(row.getCell(6)).equals("主管")) {
		                	data.setManager("Y");
		                }else if(getCellValue(row.getCell(6)).equals("非主管")) {
		                	data.setManager("N");
		                }
		                if(getCellValue(row.getCell(7)).equals("全時")) {
		                	data.setWorkingHours("A");
		                }else if(getCellValue(row.getCell(7)).equals("部分工時")) {
		                	data.setWorkingHours("P");
		                }
		                data.setAdvancedAgeRetirementReemploymentPlanId(Integer.valueOf(planId));
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
	        	delAdvancedAgeRetirementReemploymentBenefitListbyPlanId(request, response, planId);
		        logger.info("刪除finish");
		        AdvancedAgeRetirementReemploymentBenefitList[] dataList = list.toArray(new AdvancedAgeRetirementReemploymentBenefitList[list.size()]);
		        addAdvancedAgeRetirementReemploymentBenefitList(request,response,dataList);
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
	
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentExpenditureFromFile", method = RequestMethod.POST)
	public void addAdvancedAgeRetirementReemploymentExpenditureFromFile(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			) { 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		String applyId=session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentApplyId").toString();
		
		String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		if (!extension.toLowerCase().trim().equals("xlsx") && !extension.toLowerCase().trim().equals("xls"))
		{
			logger.warn("addAdvancedAgeRetirementReemploymentExpenditureFromFile 檔案格式錯誤");
			checkFile=false;
		}
		if(checkFile) {
			Attachment attach = new Attachment();
			attach.setFileBelong("C");
			attach.setFileBelongId(Integer.valueOf(applyId));
			attach.setFileName(uploadFile.getOriginalFilename());
			attach.setFileFrequency(1);
			attach.setFileType("advancedAgeRetirementReemploymentExpenditure");
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
			
			
			List<AdvancedAgeRetirementReemploymentExpenditure> list = new ArrayList<>();
			AdvancedAgeRetirementReemploymentExpenditure data;
			try {
				for(int i=2;i<=totalRowNum;i++){
					data = new AdvancedAgeRetirementReemploymentExpenditure();
					Row row = sheet.getRow(i);
					if(row!=null && !getCellValue(row.getCell(1)).equals("")){
						
						data.setPlanName(getCellValue(row.getCell(1)));
						data.setUnitPrice(Integer.valueOf(getCellValue(row.getCell(2))));
						data.setAmount(Integer.valueOf(getCellValue(row.getCell(3))));
						data.setAmounts(Integer.valueOf(getCellValue(row.getCell(5))));
						if(!"".equals(getCellValue(row.getCell(6)))) {
							data.setOtherAmounts(Integer.valueOf(getCellValue(row.getCell(6))));
						}
						data.setDescription(getCellValue(row.getCell(7)));
						data.setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(applyId));
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
				delAdvancedAgeRetirementReemploymentExpenditurebyApplyId(request, response, applyId);
				logger.info("刪除finish");
				AdvancedAgeRetirementReemploymentExpenditure[] dataList = list.toArray(new AdvancedAgeRetirementReemploymentExpenditure[list.size()]);
				addAdvancedAgeRetirementReemploymentExpenditure(request,response,dataList);
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
	
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentBasicDataFromFile", method = RequestMethod.POST)
	public void addAdvancedAgeRetirementReemploymentBasicDataFromFile(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			) { 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		String applyId=session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentApplyId").toString();
		
		String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		if (!extension.toLowerCase().trim().equals("xlsx") && !extension.toLowerCase().trim().equals("xls"))
		{
			logger.warn("addAdvancedAgeRetirementReemploymentBasicDataFromFile 檔案格式錯誤");
			checkFile=false;
		}
		if(checkFile) {
			Attachment attach = new Attachment();
			attach.setFileBelong("C");
			attach.setFileBelongId(Integer.valueOf(applyId));
			attach.setFileName(uploadFile.getOriginalFilename());
			attach.setFileFrequency(1);
			attach.setFileType("advancedAgeRetirementReemploymentBasicDataList");
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
			
			
			List<AdvancedAgeRetirementReemploymentBasicData> list = new ArrayList<>();
			AdvancedAgeRetirementReemploymentBasicData data;
			jsondata = api.httpPost(ip + "getIndustryList", "");
			try {
				for(int i=2;i<=totalRowNum;i++){
					data = new AdvancedAgeRetirementReemploymentBasicData();
					Row row = sheet.getRow(i);
					if(row!=null && !getCellValue(row.getCell(1)).equals("")){
						for(int j = 2; j < 14; j++) {
							if("".equals(getCellValue(row.getCell(j)))) {
								response.setContentType("text/html;charset=UTF-8");
								try {
									response.resetBuffer();
									response.getWriter().print("fail");
									return;
								} catch (IOException e) {
									logger.warn(e.getMessage());
								}
							}
						}
						data.setCompanyName(getCellValue(row.getCell(1)));
						data.setSeq(getCellValue(row.getCell(2)));
						data.setBusinessItem(getCellValue(row.getCell(3)));
						data.setIndustry(industryCodeConventer(getCellValue(row.getCell(4))));
						data.setUnitSize(getCellValue(row.getCell(5)));
						data.setGuaranteeNumber(getCellValue(row.getCell(6)));
						data.setPrincipal(getCellValue(row.getCell(7)));
						data.setContactName(getCellValue(row.getCell(8)));
						String[] phoneNumber = extractPhoneNumber(getCellValue(row.getCell(9)));
						data.setContactWorkPhoneAreaCode(phoneNumber[0]);
						data.setContactWorkPhone(phoneNumber[1]);
						data.setContactWorkPhoneExtension(phoneNumber[2]);
						data.setContactPhone(getCellValue(row.getCell(10)).replace("-", ""));
						data.setEmail(getCellValue(row.getCell(11)));
						data.setEmployeeNumber(Integer.valueOf(getCellValue(row.getCell(12))));
						data.setParticipateNumber(Integer.valueOf(getCellValue(row.getCell(13))));
						data.setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(applyId));
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
				delAdvancedAgeRetirementReemploymentBasicDatabyApplyId(request, response, applyId);
				logger.info("刪除finish");
				AdvancedAgeRetirementReemploymentBasicData[] dataList = list.toArray(new AdvancedAgeRetirementReemploymentBasicData[list.size()]);
				addAdvancedAgeRetirementReemploymentBasicData(request,response,dataList);
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


	@RequestMapping(value = "/advancedAgeRetirementReemploymentPaymentApprovedFileUplolad", method = RequestMethod.POST)
	public void advancedAgeRetirementReemploymentPaymentApprovedFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="approvedFiles", required=false) MultipartFile[] approvedFiles,
			@RequestParam(value="baseId", required=false) String baseId){
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
							&& !extension.toLowerCase().trim().equals("doc") 
							&& !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("advancedAgeRetirementReemploymentPaymentApprovedFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(approvedFiles[i].getOriginalFilename());
					attach.setFileType("approved");
					
					AdvancedAgeBase base = new AdvancedAgeBase();
					base.setId(Integer.valueOf(baseId));
					AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base);
					if(searchBase.getAllowanceFrequencyRecord()!=null)
					{
						attach.setFileFrequency(searchBase.getAllowanceFrequencyRecord().split(";").length+1);
					}else
					{
						attach.setFileFrequency(1);
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
	
	@RequestMapping(value = "/advancedAgeRetirementReemploymentPaymentReceiptFileUplolad", method = RequestMethod.POST)
	public void advancedAgeRetirementReemploymentPaymentReceiptFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="receiptFiles", required=false) MultipartFile[] receiptFiles,
			@RequestParam(value="baseId", required=false) String baseId){ 
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
							&& !extension.toLowerCase().trim().equals("doc") 
							&& !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("advancedAgeRetirementReemploymentPaymentReceiptFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(receiptFiles[i].getOriginalFilename());
					attach.setFileType("receipt");

					AdvancedAgeBase base = new AdvancedAgeBase();
					base.setId(Integer.valueOf(baseId));
					AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base);
					if(searchBase.getAllowanceFrequencyRecord()!=null)
					{
						attach.setFileFrequency(searchBase.getAllowanceFrequencyRecord().split(";").length+1);
					}else
					{
						attach.setFileFrequency(1);
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
	
	@RequestMapping(value = "/advancedAgeRetirementReemploymentPaymentResultFileUplolad", method = RequestMethod.POST)
	public void advancedAgeRetirementReemploymentPaymentResultFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="resultFiles", required=false) MultipartFile[] resultFiles,
			@RequestParam(value="baseId", required=false) String baseId){ 
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
							&& !extension.toLowerCase().trim().equals("doc") 
							&& !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("advancedAgeRetirementReemploymentPaymentResultFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(resultFiles[i].getOriginalFilename());
					attach.setFileType("result");

					AdvancedAgeBase base = new AdvancedAgeBase();
					base.setId(Integer.valueOf(baseId));
					AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base);
					if(searchBase.getAllowanceFrequencyRecord()!=null)
					{
						attach.setFileFrequency(searchBase.getAllowanceFrequencyRecord().split(";").length+1);
					}else
					{
						attach.setFileFrequency(1);
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
	
	@RequestMapping(value = "/advancedAgeRetirementReemploymentPaymentExpenditureDetailsFileUplolad", method = RequestMethod.POST)
	public void advancedAgeRetirementReemploymentPaymentExpenditureDetailsFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="expenditureDetailsFiles", required=false) MultipartFile[] expenditureDetailsFiles,
			@RequestParam(value="baseId", required=false) String baseId){ 
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		boolean checkFile=true;
		if(expenditureDetailsFiles !=null) {
			for(int i=0;i<expenditureDetailsFiles.length;i++) {
				try {
					String extension = FilenameUtils.getExtension(expenditureDetailsFiles[i].getOriginalFilename());
					if (!extension.toLowerCase().trim().equals("jpg") && !extension.toLowerCase().trim().equals("png") 
							&& !extension.toLowerCase().trim().equals("pdf") && !extension.toLowerCase().trim().equals("rar")
							&& !extension.toLowerCase().trim().equals("zip") && !extension.toLowerCase().trim().equals("7z")
							&& !extension.toLowerCase().trim().equals("doc") 
							&& !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("advancedAgeRetirementReemploymentPaymentExpenditureDetailsFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(expenditureDetailsFiles[i].getOriginalFilename());
					attach.setFileType("expenditureDetails");

					AdvancedAgeBase base = new AdvancedAgeBase();
					base.setId(Integer.valueOf(baseId));
					AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base);
					if(searchBase.getAllowanceFrequencyRecord()!=null)
					{
						attach.setFileFrequency(searchBase.getAllowanceFrequencyRecord().split(";").length+1);
					}else
					{
						attach.setFileFrequency(1);
					}
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)expenditureDetailsFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(expenditureDetailsFiles[i].getInputStream(),attach.getFilePath(),expenditureDetailsFiles[i].getOriginalFilename());
					
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
	
	@RequestMapping(value = "/advancedAgeRetirementReemploymentPaymentNecessaryFileUplolad", method = RequestMethod.POST)
	public void advancedAgeRetirementReemploymentPaymentNecessaryFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="necessaryFiles", required=false) MultipartFile[] necessaryFiles,
			@RequestParam(value="baseId", required=false) String baseId){ 
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
							&& !extension.toLowerCase().trim().equals("doc") 
							&& !extension.toLowerCase().trim().equals("docx")
							&& !extension.toLowerCase().trim().equals("odt"))
	                {
						logger.warn("advancedAgeRetirementReemploymentPaymentNecessaryFileUplolad 檔案格式錯誤");
	                    throw new Exception("請確認副檔名是否正確!");
	                }
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(necessaryFiles[i].getOriginalFilename());
					attach.setFileType("necessary");

					AdvancedAgeBase base = new AdvancedAgeBase();
					base.setId(Integer.valueOf(baseId));
					AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base);
					if(searchBase.getAllowanceFrequencyRecord()!=null)
					{
						attach.setFileFrequency(searchBase.getAllowanceFrequencyRecord().split(";").length+1);
					}else
					{
						attach.setFileFrequency(1);
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
	
	public void delAdvancedAgeRetirementReemploymentBenefitListbyPlanId(HttpServletRequest request, HttpServletResponse response, String planId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		advancedAgeRetirementReemploymentBenefitList = new AdvancedAgeRetirementReemploymentBenefitList();
		advancedAgeRetirementReemploymentBenefitList.setAdvancedAgeRetirementReemploymentPlanId(Integer.valueOf(planId));
		try {
			json = objectMapper.writeValueAsString(advancedAgeRetirementReemploymentBenefitList);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delAdvancedAgeRetirementReemploymentBenefitListbyPlanId",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	public void addAdvancedAgeRetirementReemploymentBenefitList(HttpServletRequest request, HttpServletResponse response, AdvancedAgeRetirementReemploymentBenefitList[] list){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				try {
					json = objectMapper.writeValueAsString(list[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addAdvancedAgeRetirementReemploymentBenefitList",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	public void delAdvancedAgeRetirementReemploymentExpenditurebyApplyId(HttpServletRequest request,
			HttpServletResponse response, String applyId) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		advancedAgeRetirementReemploymentExpenditure = new AdvancedAgeRetirementReemploymentExpenditure();
		advancedAgeRetirementReemploymentExpenditure.setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(applyId));
		try {
			json = objectMapper.writeValueAsString(advancedAgeRetirementReemploymentExpenditure);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delAdvancedAgeRetirementReemploymentExpenditurebyApplyId",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
		
	}

	public void addAdvancedAgeRetirementReemploymentExpenditure(HttpServletRequest request,
			HttpServletResponse response, AdvancedAgeRetirementReemploymentExpenditure[] list) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				try {
					json = objectMapper.writeValueAsString(list[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addAdvancedAgeRetirementReemploymentExpenditure",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
		
	}

	public void delAdvancedAgeRetirementReemploymentBasicDatabyApplyId(HttpServletRequest request,
			HttpServletResponse response, String applyId) {
		
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		advancedAgeRetirementReemploymentBasicData = new AdvancedAgeRetirementReemploymentBasicData();
		advancedAgeRetirementReemploymentBasicData.setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(applyId));
		try {
			json = objectMapper.writeValueAsString(advancedAgeRetirementReemploymentBasicData);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delAdvancedAgeRetirementReemploymentBasicDatabyApplyId",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
		
	}

	public void addAdvancedAgeRetirementReemploymentBasicData(HttpServletRequest request, HttpServletResponse response,
			AdvancedAgeRetirementReemploymentBasicData[] list) {
		
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				try {
					json = objectMapper.writeValueAsString(list[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addAdvancedAgeRetirementReemploymentBasicData",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
		
	}
	
	public void SaveFileFromInputStream(InputStream stream, String path, String filename) {
		File directory;
		try {
			directory = new File(localPath + path + "/" + filename).getCanonicalFile();
			// 路徑是否存在
			if (!directory.getParentFile().exists()) {
				try {
					boolean checkPFile = directory.getParentFile().mkdirs();
					if (checkPFile) {
						directory.createNewFile();
					}
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
			}
		} catch (IOException e1) {
			logger.warn(e1.getMessage());
		}

		// 存檔
		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(localPath + path + "/" + filename);
			byte[] buffer = new byte[1024 * 1024];
			int byteread = 0;
			while ((byteread = stream.read(buffer)) != -1) {
				fs.write(buffer, 0, byteread);
				fs.flush();
			}
		} catch (FileNotFoundException e) {
			logger.warn(e.getMessage());
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} finally {
			try {
				if (fs != null) {
					fs.close();
				}
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}

		}

	}

	public AdvancedAgeBase selectCTypeAdvancedAgeBase(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectCTypeAdvancedAgeBase", json));
		try {
			if (array.length()>0) {
				searchBase = objectMapper.readValue(array.getJSONObject(0).toString(), AdvancedAgeBase.class);}
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchBase;
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

	public AdvancedAgeBase selectAdvancedAgeBaseById(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeBaseById", json);

		try {
			if (!jsondata.equals(""))
				searchBase = objectMapper.readValue(jsondata, AdvancedAgeBase.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchBase;
	}
	
	public String[] extractPhoneNumber(String phoneNumber) {
		String[] phoneArray = new String[3];
		if("".equals(phoneNumber)) {
			return phoneArray;
		}
		String areacode = phoneNumber.substring(phoneNumber.indexOf("(")+1, phoneNumber.indexOf(")")).trim();
		String workPhone = phoneNumber.substring(phoneNumber.indexOf(")")+1, phoneNumber.indexOf("#"));
		workPhone = workPhone.replace("-", "").trim();
		String extension = phoneNumber.substring(phoneNumber.indexOf("#")+1).trim();
		phoneArray[0] = areacode;
		phoneArray[1] = workPhone;
		phoneArray[2] = extension;
		return phoneArray;
	}
	
	public String industryCodeConventer(String industry) {
		String code = "";
		ObjectMapper mapper = new ObjectMapper();
		List<Parameter> list = null;
		// excel選項與資料庫不一樣 <出版、影音製作、傳播及資通訊服務業>
		if((industry).equals("出版影音及資通訊業")) {
			code = "J";
			return code.trim();
		}
		try {
			list = mapper.readValue(jsondata, new TypeReference<List<Parameter>>() {
			});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Parameter para: list) {
			if((industry).equals(para.getName())) {
				code = para.getCode();
			}
		}

		return code.trim();
	}
}
