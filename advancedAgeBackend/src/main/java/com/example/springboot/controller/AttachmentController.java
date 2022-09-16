package com.example.springboot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.springboot.entity.Attachment;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller 
public class AttachmentController {
	
	@Autowired
	CallApi api;
	
	HttpSession session;
	
	@Value("${api_ip}")
	private String ip;
	
	@Value("${file_path}")
	private String localPath;
	
	AdvancedAgeBase base;
	
	@RequestMapping(value = "/blackListFileUplolad", method = RequestMethod.POST)
	public void blackListFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="blackListFiles", required=false) MultipartFile[] blackListFiles,
			@RequestParam(value="id", required=false) String id ){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(blackListFiles !=null) {
			for(int i=0;i<blackListFiles.length;i++) {
				try {
					attach = new Attachment();
					attach.setFileBelong("BL");
					attach.setFileBelongId(Integer.valueOf(id));
					attach.setFileName(blackListFiles[i].getOriginalFilename());
					attach.setFileFrequency(1);
					attach.setFileType("blackList");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)blackListFiles[i].getSize());
					attach.setFileStatus(1);
					//寫檔
					SaveFileFromInputStream(blackListFiles[i].getInputStream(),attach.getFilePath(),blackListFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
	}
	
	@RequestMapping(value = "/siteInspectionFileUplolad", method = RequestMethod.POST)
	public void siteInspectionFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="siteInspectionFiles", required=false) MultipartFile[] blackListFiles,
			@RequestParam(value="id", required=false) String id ){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(blackListFiles !=null) {
			for(int i=0;i<blackListFiles.length;i++) {
				try {
					attach = new Attachment();
					attach.setFileBelong("SI");
					attach.setFileBelongId(Integer.valueOf(id));
					attach.setFileName(blackListFiles[i].getOriginalFilename());
					attach.setFileFrequency(1);
					attach.setFileType("siteInspection");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)blackListFiles[i].getSize());
					attach.setFileStatus(1);
					//寫檔
					SaveFileFromInputStream(blackListFiles[i].getInputStream(),attach.getFilePath(),blackListFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
	}
	
	@RequestMapping(value = "/siteInspectionOtherFileUplolad", method = RequestMethod.POST)
	public void siteInspectionOtherFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="siteInspectionOtherFiles", required=false) MultipartFile[] blackListFiles,
			@RequestParam(value="id", required=false) String id ){ 
		session = request.getSession();
		Attachment attach;
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(blackListFiles !=null) {
			for(int i=0;i<blackListFiles.length;i++) {
				try {
					attach = new Attachment();
					attach.setFileBelong("SI");
					attach.setFileBelongId(Integer.valueOf(id));
					attach.setFileName(blackListFiles[i].getOriginalFilename());
					attach.setFileFrequency(1);
					attach.setFileType("siteInspectionOther");
					attach.setFilePath("/"+attach.getFileBelong()+"/"+attach.getFileBelongId()+"/"+attach.getFileType()+"/"+attach.getFileFrequency());
					attach.setFileSize((int)blackListFiles[i].getSize());
					attach.setFileStatus(1);
					//寫檔
					SaveFileFromInputStream(blackListFiles[i].getInputStream(),attach.getFilePath(),blackListFiles[i].getOriginalFilename());
					
					json = objectMapper.writeValueAsString(attach);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"fileUplolad",json);
			}
		}
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
}