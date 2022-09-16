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

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import com.example.springboot.entity.Attachment;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller 
public class AttachmentController {
	
	CallApi api = new CallApi();
	
	HttpSession session;
	
	@Value("${api_ip}")
	private String ip;
	
	@Value("${file_path}")
	private String localPath;
	
	AdvancedAgeBase base;
	
	@RequestMapping(value = "/companyInfoRegisterFileUplolad", method = RequestMethod.POST)
	public void companyInfoRegisterFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="registerFiles", required=false) MultipartFile[] registerFiles,
			@RequestParam(value="companyInfoId", required=false) String companyInfoId){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(registerFiles !=null) {
			for(int i=0;i<registerFiles.length;i++) {
				try {
					attach = new Attachment();
					attach.setFileBelong("E");
					attach.setFileBelongId(Integer.valueOf(companyInfoId));
					attach.setFileName(registerFiles[i].getOriginalFilename());
					attach.setFileFrequency(1);
					attach.setFileType("register");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)registerFiles[i].getSize());
					attach.setFileStatus(1);
					//寫檔
					SaveFileFromInputStream(registerFiles[i].getInputStream(),attach.getFilePath(),registerFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
	}
	
	@RequestMapping(value = "/companyInfoAuFileUplolad", method = RequestMethod.POST)
	public void companyInfoAuFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="authorizeFiles", required=false) MultipartFile[] authorizeFiles,
			@RequestParam(value="companyInfoId", required=false) String companyInfoId){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(authorizeFiles !=null) {
			for(int i=0;i<authorizeFiles.length;i++) {
				try {
					attach = new Attachment();
					attach.setFileBelong("E");
					attach.setFileBelongId(Integer.valueOf(companyInfoId));
					attach.setFileName(authorizeFiles[i].getOriginalFilename());
					attach.setFileFrequency(1);
					attach.setFileType("authorize");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)authorizeFiles[i].getSize());
					attach.setFileStatus(1);
					//寫檔
					SaveFileFromInputStream(authorizeFiles[i].getInputStream(),attach.getFilePath(),authorizeFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
	}
	
	@RequestMapping(value = "/advancedAgeApplyRegisterFileUplolad", method = RequestMethod.POST)
	public void advancedAgeApplyRegisterFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="registerFiles", required=false) MultipartFile[] registerFiles,
			@RequestParam(value="seq", required=false) String seq){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(registerFiles !=null) {
			for(int i=0;i<registerFiles.length;i++) {
				try {
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(seq);
					AdvancedAgeBase result=selectATypeAdvancedAgeBase(base);
					if(result.getFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length+1);
					}
					
					attach.setFileBelong("A");
					attach.setFileBelongId(Integer.valueOf(session.getAttribute(base.getSeq()+"advancedAgeApplyId").toString()));
					attach.setFileName(registerFiles[i].getOriginalFilename());
					attach.setFileType("register");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)registerFiles[i].getSize());
					attach.setFileStatus(1);
					
					
					//寫檔
					SaveFileFromInputStream(registerFiles[i].getInputStream(),attach.getFilePath(),registerFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			//申請書附件確認
//			AdvancedAgeApply apply = new AdvancedAgeApply();
//			apply.setSeq(session.getAttribute("attachmentSeq").toString());
//			apply.setAttachDocumentsRegisterProof("Y");
//			addAdvancedAgeApply(request,response,apply);
		}
	}
	
	@RequestMapping(value = "/advancedAgeApplyInsureFileUplolad", method = RequestMethod.POST)
	public void advancedAgeApplyInsureFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="insureFiles", required=false) MultipartFile[] insureFiles,
			@RequestParam(value="seq", required=false) String seq){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(insureFiles !=null) {
			for(int i=0;i<insureFiles.length;i++) {
				try {
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(seq);
					AdvancedAgeBase result=selectATypeAdvancedAgeBase(base);
					if(result.getFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length+1);
					}
					
					attach.setFileBelong("A");
					attach.setFileBelongId(Integer.valueOf(session.getAttribute(base.getSeq()+"advancedAgeApplyId").toString()));
					attach.setFileName(insureFiles[i].getOriginalFilename());
					attach.setFileType("insure");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)insureFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(insureFiles[i].getInputStream(),attach.getFilePath(),insureFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			//申請書附件確認
//			AdvancedAgeApply apply = new AdvancedAgeApply();
//			apply.setSeq(session.getAttribute("attachmentSeq").toString());
//			apply.setAttachDocumentsInsureProof("Y");
//			addAdvancedAgeApply(request,response,apply);
		}
	}
	
	@RequestMapping(value = "/advancedAgeApplySalaryFileUplolad", method = RequestMethod.POST)
	public void advancedAgeApplySalaryFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="salaryFiles", required=false) MultipartFile[] salaryFiles,
			@RequestParam(value="seq", required=false) String seq){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(salaryFiles !=null) {
			for(int i=0;i<salaryFiles.length;i++) {
				try {
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(seq);
					AdvancedAgeBase result=selectATypeAdvancedAgeBase(base);
					if(result.getFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length+1);
					}
					
					attach.setFileBelong("A");
					attach.setFileBelongId(Integer.valueOf(session.getAttribute(base.getSeq()+"advancedAgeApplyId").toString()));
					attach.setFileName(salaryFiles[i].getOriginalFilename());
					attach.setFileType("salary");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)salaryFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(salaryFiles[i].getInputStream(),attach.getFilePath(),salaryFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			//申請書附件確認
//			AdvancedAgeApply apply = new AdvancedAgeApply();
//			apply.setSeq(session.getAttribute("attachmentSeq").toString());
//			apply.setAttachDocumentsSalaryProof("Y");
//			addAdvancedAgeApply(request,response,apply);
		}
	}
	
	@RequestMapping(value = "/advancedAgeApplyAttendanceFileUplolad", method = RequestMethod.POST)
	public void advancedAgeApplyAttendanceFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="attendanceFiles", required=false) MultipartFile[] attendanceFiles,
			@RequestParam(value="seq", required=false) String seq){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(attendanceFiles !=null) {
			for(int i=0;i<attendanceFiles.length;i++) {
				try {
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(seq);
					AdvancedAgeBase result=selectATypeAdvancedAgeBase(base);
					if(result.getFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length+1);
					}
					
					attach.setFileBelong("A");
					attach.setFileBelongId(Integer.valueOf(session.getAttribute(base.getSeq()+"advancedAgeApplyId").toString()));
					attach.setFileName(attendanceFiles[i].getOriginalFilename());
					attach.setFileType("attendance");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)attendanceFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(attendanceFiles[i].getInputStream(),attach.getFilePath(),attendanceFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
			//此類型檔案上傳為後續新增，AdvancedAgeApply當初沒有欄位紀錄
			//申請書附件確認
//			AdvancedAgeApply apply = new AdvancedAgeApply();
//			apply.setSeq(session.getAttribute("seq").toString());
//			apply.setAttachDocumentsSalaryProof("Y");
//			apply.setAttachDocumentsOtherProof("Y");
//			addAdvancedAgeApply(request,response,apply);
		}
	}
	
	@RequestMapping(value = "/advancedAgeApplyNecessaryFileUplolad", method = RequestMethod.POST)
	public void advancedAgeApplyNecessaryFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="necessaryFiles", required=false) MultipartFile[] necessaryFiles,
			@RequestParam(value="seq", required=false) String seq){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(necessaryFiles !=null) {
			for(int i=0;i<necessaryFiles.length;i++) {
				try {
					attach = new Attachment();
					
					base = new AdvancedAgeBase();
					base.setSeq(seq);
					AdvancedAgeBase result=selectATypeAdvancedAgeBase(base);
					if(result.getFileStatusRecord()==null)
					{
						attach.setFileFrequency(1);
					}
					else
					{
						attach.setFileFrequency(result.getFileStatusRecord().split(";").length+1);
					}
					
					attach.setFileBelong("A");
					attach.setFileBelongId(Integer.valueOf(session.getAttribute(base.getSeq()+"advancedAgeApplyId").toString()));
					attach.setFileName(necessaryFiles[i].getOriginalFilename());
					attach.setFileType("necessary");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)necessaryFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(necessaryFiles[i].getInputStream(),attach.getFilePath(),necessaryFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
//			session.removeAttribute("attachmentSeq");
			//此類型檔案上傳為後續新增，AdvancedAgeApply當初沒有欄位紀錄
			//申請書附件確認
//			AdvancedAgeApply apply = new AdvancedAgeApply();
//			apply.setSeq(session.getAttribute("seq").toString());
//			apply.setAttachDocumentsSalaryProof("Y");
//			apply.setAttachDocumentsOtherProof("Y");
//			addAdvancedAgeApply(request,response,apply);
		}
	}
	//0728刪除
//	@RequestMapping(value = "/advancedAgePlanAssistanceMeasuresFileUplolad", method = RequestMethod.POST)
//	public void advancedAgePlanAssistanceMeasuresFileUplolad(HttpServletRequest request, HttpServletResponse response,
//			@RequestParam(value="assistanceMeasuresFiles", required=false) MultipartFile[] assistanceMeasuresFiles){ 
//		session = request.getSession();
//		Attachment attach;
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json="";
//		if(assistanceMeasuresFiles !=null) {
//			for(int i=0;i<assistanceMeasuresFiles.length;i++) {
//				try {
//					attach = new Attachment();
//					attach.setFileBelong("A");
//					attach.setFileBelongId(Integer.valueOf(session.getAttribute("advancedAgeApplyId").toString()));
//					attach.setFileName(assistanceMeasuresFiles[i].getOriginalFilename());
//					attach.setFileFrequency(1);
//					attach.setFileType("assistanceMeasures");
//					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
//					attach.setFileSize((int)assistanceMeasuresFiles[i].getSize());
//					attach.setFileStatus(1);
//					//寫檔
//					SaveFileFromInputStream(assistanceMeasuresFiles[i].getInputStream(),attach.getFilePath(),assistanceMeasuresFiles[i].getOriginalFilename());
//					
//					json = objectMapper.writeValueAsString(attach);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				api.httpPost(ip+"fileUplolad",json);
//			}
//		}
//	}
//	
//	@RequestMapping(value = "/advancedAgePlanFriendlyMeasuresFileUplolad", method = RequestMethod.POST)
//	public void advancedAgePlanFriendlyMeasuresFileUplolad(HttpServletRequest request, HttpServletResponse response,
//			@RequestParam(value="friendlyMeasuresFiles", required=false) MultipartFile[] friendlyMeasuresFiles){ 
//		session = request.getSession();
//		Attachment attach;
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json="";
//		if(friendlyMeasuresFiles !=null) {
//			for(int i=0;i<friendlyMeasuresFiles.length;i++) {
//				try {
//					attach = new Attachment();
//					attach.setFileBelong("A");
//					attach.setFileBelongId(Integer.valueOf(session.getAttribute("advancedAgeApplyId").toString()));
//					attach.setFileName(friendlyMeasuresFiles[i].getOriginalFilename());
//					attach.setFileFrequency(1);
//					attach.setFileType("friendlyMeasures");
//					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
//					attach.setFileSize((int)friendlyMeasuresFiles[i].getSize());
//					attach.setFileStatus(1);
//					//寫檔
//					SaveFileFromInputStream(friendlyMeasuresFiles[i].getInputStream(),attach.getFilePath(),friendlyMeasuresFiles[i].getOriginalFilename());
//					
//					json = objectMapper.writeValueAsString(attach);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				api.httpPost(ip+"fileUplolad",json);
//			}
//		}
//	}
//	
//	@RequestMapping(value = "/advancedAgePlanExpectedMeasuresEffectivenessFilesFileUplolad", method = RequestMethod.POST)
//	public void advancedAgePlanExpectedMeasuresEffectivenessFilesFileUplolad(HttpServletRequest request, HttpServletResponse response,
//			@RequestParam(value="expectedMeasuresEffectivenessFiles", required=false) MultipartFile[] expectedMeasuresEffectivenessFiles){ 
//		session = request.getSession();
//		Attachment attach;
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json="";
//		if(expectedMeasuresEffectivenessFiles !=null) {
//			for(int i=0;i<expectedMeasuresEffectivenessFiles.length;i++) {
//				try {
//					attach = new Attachment();
//					attach.setFileBelong("A");
//					attach.setFileBelongId(Integer.valueOf(session.getAttribute("advancedAgeApplyId").toString()));
//					attach.setFileName(expectedMeasuresEffectivenessFiles[i].getOriginalFilename());
//					attach.setFileFrequency(1);
//					attach.setFileType("expectedMeasuresEffectiveness");
//					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
//					attach.setFileSize((int)expectedMeasuresEffectivenessFiles[i].getSize());
//					attach.setFileStatus(1);
//					//寫檔
//					SaveFileFromInputStream(expectedMeasuresEffectivenessFiles[i].getInputStream(),attach.getFilePath(),expectedMeasuresEffectivenessFiles[i].getOriginalFilename());
//					
//					json = objectMapper.writeValueAsString(attach);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				api.httpPost(ip+"fileUplolad",json);
//			}
//		}
//	}
	
	@RequestMapping(value = "/addAdvancedAgeEmploymentListFromFile", method = RequestMethod.POST)
	public void addAdvancedAgeEmploymentListFromFile(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile) throws Exception{ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		String applyId=session.getAttribute("advancedAgeApplyId").toString();
		String planId=session.getAttribute("advancedAgePlanId").toString();
		session.removeAttribute("advancedAgePlanId");
		session.removeAttribute("advancedAgeApplyId");
		Attachment attach = new Attachment();
		attach.setFileBelong("A");
		attach.setFileBelongId(Integer.valueOf(applyId));
		attach.setFileName(uploadFile.getOriginalFilename());
		attach.setFileFrequency(1);
		attach.setFileType("employmentList");
		attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
		attach.setFileSize((int)uploadFile.getSize());
		attach.setFileStatus(1);
		
		json = objectMapper.writeValueAsString(attach);
		//刪除舊檔
		api.httpPost(ip+"deleteFile",json);
		
		//檔案上傳
		SaveFileFromInputStream(uploadFile.getInputStream(),attach.getFilePath(),uploadFile.getOriginalFilename());
		
		//檔案儲存
		api.httpPost(ip+"fileUplolad",json);
		
        String destFileName=localPath+attach.getFilePath()+"/"+uploadFile.getOriginalFilename();
        System.out.println(destFileName);
        
        File destFile = new File(destFileName);
        try {
			uploadFile.transferTo(destFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        System.out.println("上傳成功");
        delAdvancedAgeEmploymentListbyId(request, response, new AdvancedAgeEmploymentList(),planId);
        System.out.println("讀取EXCEL內容");
        
        Sheet sheet;
        InputStream fis = null;
 
        try {
			fis = new FileInputStream(destFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        Workbook workbook = null;
        
        try {
            workbook= new XSSFWorkbook(destFile);
        } catch (Exception ex) {
            workbook = new HSSFWorkbook(fis);
        }
        sheet = workbook.getSheetAt(0);
 
        int totalRowNum = sheet.getLastRowNum();
 
        System.out.println("表格共有："+totalRowNum+"列");
        
        List<AdvancedAgeEmploymentList> list = new ArrayList<AdvancedAgeEmploymentList>();
        AdvancedAgeEmploymentList data;
        for(int i=2;i<=totalRowNum;i++){
        	data = new AdvancedAgeEmploymentList();
            Row row = sheet.getRow(i);
            if(row!=null && !getCellValue(row.getCell(1)).equals("")){
                int columnNum=row.getPhysicalNumberOfCells();
                System.out.println("該列共有行數："+columnNum);
//                for(int j=0;j<columnNum;j++){
//                    System.out.println("當前處理第"+i+"列，第"+j+"行");
//                    Cell cell = row.getCell(j);
//                    
//                    System.out.println(getCellValue(cell));
//                    
//                }
                data.setName(getCellValue(row.getCell(1)));
                data.setIdentification(getCellValue(row.getCell(2)));
                if(getCellValue(row.getCell(3)).equals("勞工保險")){
                	data.setLaborProtectionTime(getCellValue(row.getCell(4)).replace("/", ""));
                }
                else if(getCellValue(row.getCell(3)).equals("職災保險")) {
                	data.setOccupationalAccidentProtectionTime(getCellValue(row.getCell(4)).replace("/", ""));
                }
                if(getCellValue(row.getCell(5)).equals("主管")) {
                	data.setManager("Y");
                }
                else if(getCellValue(row.getCell(5)).equals("非主管")) {
                	data.setManager("N");
                }
                if(getCellValue(row.getCell(6)).equals("三等親內")) {
                	data.setRelatives("Y");
                }
                else if(getCellValue(row.getCell(6)).equals("非三等親")) {
                	data.setRelatives("N");
                }
                if(getCellValue(row.getCell(7)).equals("全時")) {
                	data.setWorkingHours("A");
                }
                else if(getCellValue(row.getCell(7)).equals("部分工時")) {
                	data.setWorkingHours("P");
                }
                
                data.setRecurringSalary(Integer.valueOf(getCellValue(row.getCell(8))));
                data.setNotRecurringSalary(Integer.valueOf(getCellValue(row.getCell(9))));
                data.setAverageSalary((data.getRecurringSalary()+data.getNotRecurringSalary())/3);
                list.add(data);
            }
            else
            {
            	break;
            }
        }
        AdvancedAgeEmploymentList[] dataList = list.toArray(new AdvancedAgeEmploymentList[list.size()]);
        addAdvancedAgeEmploymentList(request,response,dataList,planId);
        workbook.close();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/addAdvancedAgeEmploymentListReceiptFromFile", method = RequestMethod.POST)
	public void addAdvancedAgeEmploymentListReceiptFromFile(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(value="uploadFile", required=true) MultipartFile uploadFile,
			@RequestParam(value="baseId", required=true) String baseId,
			@RequestParam(value="seq", required=true) String seq) throws Exception{ 
		System.out.println("baseId = "+baseId);
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		Attachment attach = new Attachment();
		attach.setFileBelong("BA");
		attach.setFileBelongId(Integer.valueOf(baseId));
		attach.setFileName(uploadFile.getOriginalFilename());
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
		attach.setFileType("employmentList");
		attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
		attach.setFileSize((int)uploadFile.getSize());
		attach.setFileStatus(1);
		
		json = objectMapper.writeValueAsString(attach);
		//刪除舊檔
		api.httpPost(ip+"deleteReceiptFile",json);
		
		//檔案上傳
		SaveFileFromInputStream(uploadFile.getInputStream(),attach.getFilePath(),uploadFile.getOriginalFilename());
		
		//檔案儲存
		api.httpPost(ip+"fileUplolad",json);
		
        String destFileName=localPath+attach.getFilePath()+"/"+uploadFile.getOriginalFilename();
        System.out.println(destFileName);
        
        File destFile = new File(destFileName);
        try {
			uploadFile.transferTo(destFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        System.out.println("上傳成功");
        AdvancedAgeEmploymentListReceipt receipt = new AdvancedAgeEmploymentListReceipt();
        receipt.setAdvancedAgeBaseId(Integer.valueOf(baseId));
        delAdvancedAgeEmploymentListReceiptbyId(request, response, receipt);
        System.out.println("讀取EXCEL內容");
        
        Sheet sheet;
        InputStream fis = null;
 
        try {
			fis = new FileInputStream(destFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        Workbook workbook = null;
        
        try {
            workbook= new XSSFWorkbook(destFile);
        } catch (Exception ex) {
            workbook = new HSSFWorkbook(fis);
        }
        sheet = workbook.getSheetAt(0);
 
        int totalRowNum = sheet.getLastRowNum();
 
        System.out.println("表格共有："+totalRowNum+"列");
        
        List<AdvancedAgeEmploymentListReceipt> list = new ArrayList<AdvancedAgeEmploymentListReceipt>();
        AdvancedAgeEmploymentListReceipt data;
        for(int i=2;i<=totalRowNum;i++){
        	data = new AdvancedAgeEmploymentListReceipt();
            Row row = sheet.getRow(i);
            if(row!=null && !getCellValue(row.getCell(1)).equals("")){
                int columnNum=row.getPhysicalNumberOfCells();
                System.out.println("該列共有行數："+columnNum);
//                for(int j=0;j<columnNum;j++){
//                    System.out.println("當前處理第"+i+"列，第"+j+"行");
//                    Cell cell = row.getCell(j);
//                    
//                    System.out.println(getCellValue(cell));
//                    
//                }
                data.setAdvancedAgeBaseId(Integer.valueOf(baseId));
                data.setBaseAllowanceFrequency(0);
                data.setSeq(seq);
                data.setName(getCellValue(row.getCell(1)));
                data.setIdentification(getCellValue(row.getCell(2)));
                if(getCellValue(row.getCell(3)).equals("勞工保險")){
                	data.setLaborProtectionExpiredTime(getCellValue(row.getCell(4)).replace("/", ""));
                }
                else if(getCellValue(row.getCell(3)).equals("職災保險")) {
                	data.setOccupationalAccidentProtectionExpiredTime(getCellValue(row.getCell(4)).replace("/", ""));
                }
                data.setFrequency(Integer.valueOf(getCellValue(row.getCell(5)).substring(1, 2)));
                data.setEmploymentMonthStartTime(getCellValue(row.getCell(7)).replace("/", ""));
                data.setEmploymentMonthEndTime(getCellValue(row.getCell(8)).replace("/", ""));
                if(data.getFrequency().equals(1)) {
                	if(!getCellValue(row.getCell(9)).toString().equals(""))
                		data.setLowMonthNumber(Integer.valueOf(getCellValue(row.getCell(9))));
                }else
                {
                	if(!getCellValue(row.getCell(9)).toString().equals(""))
                		data.setHighMonthNumber(Integer.valueOf(getCellValue(row.getCell(9))));
                }
                
                data.setEmploymentHourStartTime(getCellValue(row.getCell(11)).replace("/", ""));
                data.setEmploymentHourEndTime(getCellValue(row.getCell(12)).replace("/", ""));
                if(data.getFrequency().equals(1)) {
                	if(!getCellValue(row.getCell(13)).toString().equals(""))
                		data.setLowHoursNumber(Integer.valueOf(getCellValue(row.getCell(13))));
                }else
                {
                	if(!getCellValue(row.getCell(13)).toString().equals(""))
                		data.setHighHoursNumber(Integer.valueOf(getCellValue(row.getCell(13))));
                }
                data.setSalary(Integer.valueOf(getCellValue(row.getCell(14))));
                if(getCellValue(row.getCell(15)).equals("按月計")) {
                	data.setSalaryMethod("M");
                }else if(getCellValue(row.getCell(15)).equals("非按月")) {
                	data.setSalaryMethod("H");
                }else {
                	data.setSalaryMethod("MH");
                }
                data.setSalaryMethodRemark(getCellValue(row.getCell(16)));
                list.add(data);
            }
            else
            {
            	break;
            }
        }
        AdvancedAgeEmploymentListReceipt[] dataList = list.toArray(new AdvancedAgeEmploymentListReceipt[list.size()]);
        addAdvancedAgeEmploymentListReceipt(request,response,dataList,searchBase.getSeq());
        workbook.close();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("path") String path){ 
		
		try{
	        // 1.得到要下載的檔名稱
	        String filename = path.substring(path.lastIndexOf("/")+1,path.length());
	        filename = new String(filename.getBytes("iso8859-1"), "utf-8"); // 解決中文亂碼
	        //檔案所在位置
	        File file = new File(localPath+path.substring(0, path.lastIndexOf("/")), filename);
	        if (file.exists()) {
	            // 檔案存在，完成下載
	            // 下載注意事項1--設定下載檔案的mimeType
	            String mimeType = request.getServletContext().getMimeType(filename);
	            response.setContentType(mimeType);
	            // 其它瀏覽器
	            filename = URLEncoder.encode(filename, "utf-8");

	            // 下載注意事項2--永遠是下載 設定以附件的形式進行開啟下載
	            response.setHeader("content-disposition", "attachment;filename="
	                    + filename);

	            FileInputStream fis = new FileInputStream(file); // 讀取要下載檔案的內容
	            OutputStream os = response.getOutputStream();// 將要下載的檔案內容通過輸出流寫回到瀏覽器
	            int len = -1;
	            byte[] b = new byte[1024 * 100];

	            while ((len = fis.read(b)) != -1) {
	                os.write(b, 0, len);
	                os.flush();
	            }
	            os.close();
	            fis.close();
	        } else {
	            throw new RuntimeException("下載資源不存在");
	        }
	        }catch (IOException e){

	        }
		
	}
	
	public void SaveFileFromInputStream(InputStream stream,String path,String filename) throws IOException{  
		File directory = new File(localPath+path+"/"+filename);
		
		//路徑是否存在
		if (!directory.getParentFile().exists()) {
		    try {
		    	directory.getParentFile().mkdirs();
		    	directory.createNewFile();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		//存檔
        FileOutputStream fs=new FileOutputStream(localPath+path+"/"+filename);
        byte[] buffer =new byte[1024*1024];
        int bytesum = 0;
        int byteread = 0; 
        while ((byteread=stream.read(buffer))!=-1)
        {
           bytesum =byteread;
           fs.write(buffer,0,byteread);
           fs.flush();
        } 
        fs.close();
        stream.close();      
    }
	
	public void deleteRealFile(String path,String filename) throws IOException{  
		File directory = new File(localPath+path+"/"+filename);
		
		directory.delete();
    }
	
	public void addAdvancedAgeApply(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeApply apply){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(apply);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String body = api.httpPost(ip+"addAdvancedAgeApply",json);
		JSONObject object = new JSONObject(body);
		session.setAttribute("advancedAgeApplyId", object.get("id"));
	}
	
	public void delAdvancedAgeEmploymentListbyId(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeEmploymentList list,String planId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		list.setAdvancedAgePlanId(Integer.valueOf(planId));
		try {
			json = objectMapper.writeValueAsString(list);
			System.out.println("json : "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		api.httpPost(ip+"delAdvancedAgeEmploymentListbyId",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delAdvancedAgeEmploymentListReceiptbyId(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeEmploymentListReceipt listReceipt){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(listReceipt);
			System.out.println("json : "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		api.httpPost(ip+"delAdvancedAgeEmploymentListReceiptbyId",json);
//		response.setContentType("text/html;charset=UTF-8");
//		try {
//			response.getWriter().print("success");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void addAdvancedAgeEmploymentList(HttpServletRequest request, HttpServletResponse response
			,@RequestBody AdvancedAgeEmploymentList[] list,String planId){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setAdvancedAgePlanId(Integer.valueOf(planId));
				try {
					json = objectMapper.writeValueAsString(list[i]);
					System.out.println("json : "+json);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"addAdvancedAgeEmploymentList",json);
				Thread.sleep(500);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addAdvancedAgeEmploymentListReceipt(HttpServletRequest request, HttpServletResponse response
			,@RequestBody AdvancedAgeEmploymentListReceipt[] list,String seq){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setCompanyName(session.getAttribute(seq+"companyName").toString());
				try {
					json = objectMapper.writeValueAsString(list[i]);
					System.out.println("json : "+json);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"addAdvancedAgeEmploymentListReceipt",json);
				Thread.sleep(500);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AdvancedAgeBase selectATypeAdvancedAgeBase(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip + "selectATypeAdvancedAgeBase", json);
		JSONArray array = new JSONArray(jsondata);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (array.length()>0) {
				searchBase = mapper.readValue(array.getJSONObject(0).toString(), AdvancedAgeBase.class);}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchBase;
	}
	
	@RequestMapping(value = "/advancedAgeEmploymentListApprovedFileUplolad", method = RequestMethod.POST)
	public void advancedAgeEmploymentListApprovedFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="approvedFiles", required=false) MultipartFile[] approvedFiles,
			@RequestParam(value="baseId", required=false) String baseId){
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(approvedFiles !=null) {
			for(int i=0;i<approvedFiles.length;i++) {
				try {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
	}
	
	@RequestMapping(value = "/advancedAgeEmploymentListReceiptFileUplolad", method = RequestMethod.POST)
	public void advancedAgeEmploymentListReceiptFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="receiptFiles", required=false) MultipartFile[] receiptFiles,
			@RequestParam(value="baseId", required=false) String baseId){ 
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(receiptFiles !=null) {
			for(int i=0;i<receiptFiles.length;i++) {
				try {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
	}
	
	@RequestMapping(value = "/advancedAgeEmploymentListEmploymentFileUplolad", method = RequestMethod.POST)
	public void advancedAgeEmploymentListEmploymentFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="employmentFiles", required=false) MultipartFile[] employmentFiles,
			@RequestParam(value="baseId", required=false) String baseId){ 
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(employmentFiles !=null) {
			for(int i=0;i<employmentFiles.length;i++) {
				try {
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(employmentFiles[i].getOriginalFilename());
					attach.setFileType("employment");

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
					attach.setFileSize((int)employmentFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(employmentFiles[i].getInputStream(),attach.getFilePath(),employmentFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
	}
	
	@RequestMapping(value = "/advancedAgeEmploymentListSalaryFileUplolad", method = RequestMethod.POST)
	public void advancedAgeEmploymentListSalaryFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="salaryFiles", required=false) MultipartFile[] salaryFiles,
			@RequestParam(value="baseId", required=false) String baseId){ 
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(salaryFiles !=null) {
			for(int i=0;i<salaryFiles.length;i++) {
				try {
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(salaryFiles[i].getOriginalFilename());
					attach.setFileType("salary");

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
					attach.setFileSize((int)salaryFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(salaryFiles[i].getInputStream(),attach.getFilePath(),salaryFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
	}
	
	@RequestMapping(value = "/advancedAgeEmploymentListAttendanceFileUplolad", method = RequestMethod.POST)
	public void advancedAgeEmploymentListAttendanceFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="attendanceFiles", required=false) MultipartFile[] attendanceFiles,
			@RequestParam(value="baseId", required=false) String baseId){ 
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(attendanceFiles !=null) {
			for(int i=0;i<attendanceFiles.length;i++) {
				try {
					attach = new Attachment();
					
					attach.setFileBelong("BA");
					attach.setFileBelongId(Integer.valueOf(baseId));
					attach.setFileName(attendanceFiles[i].getOriginalFilename());
					attach.setFileType("attendance");

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
					attach.setFileSize((int)attendanceFiles[i].getSize());
					attach.setFileStatus(1);
					
					//寫檔
					SaveFileFromInputStream(attendanceFiles[i].getInputStream(),attach.getFilePath(),attendanceFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
	}
	
	@RequestMapping(value = "/advancedAgeEmploymentListNecessaryFileUplolad", method = RequestMethod.POST)
	public void advancedAgeEmploymentListNecessaryFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="necessaryFiles", required=false) MultipartFile[] necessaryFiles,
			@RequestParam(value="baseId", required=false) String baseId){ 
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(necessaryFiles !=null) {
			for(int i=0;i<necessaryFiles.length;i++) {
				try {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
	}
	
	public AdvancedAgeBase selectAdvancedAgeBaseById(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeBaseById", json);
		ObjectMapper mapper = new ObjectMapper();

		try {
			if (!jsondata.equals(""))
				searchBase = mapper.readValue(jsondata, AdvancedAgeBase.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchBase;
	}
}