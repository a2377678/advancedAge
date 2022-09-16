package com.example.springboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.util.CallApi;

@Controller 
public class ParameterController {
	
	CallApi api = new CallApi();
	
	@Value("${api_ip}")
	private String ip;
	JSONArray jsonArray;
	JSONObject jsonObject;
	String apiResponse;
	String result;
	@RequestMapping(value = "/getAreaList")
	public void getAreaList(HttpServletRequest request, HttpServletResponse response){ 
		String code= request.getParameter("cityCode").toString();
		apiResponse=api.httpGet(ip+"getAreaList?cityCode="+code);
		jsonArray = new JSONArray(apiResponse); 
		jsonObject = new JSONObject();
		result="";
		for(int i=0;i<jsonArray.length();i++) {
			jsonObject=jsonArray.getJSONObject(i);
			if(result.equals("")) {
				result=jsonObject.get("code")+","+jsonObject.get("name");
			}
			else {
				result=result+";"+jsonObject.get("code")+","+jsonObject.get("name");
			}
		}
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}