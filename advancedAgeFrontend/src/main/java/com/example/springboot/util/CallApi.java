package com.example.springboot.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@PropertySource("classpath:application.properties")
@Component
public class CallApi { 
	
	HttpClient client;
	HttpRequest request;
	HttpResponse<String> response;
	
	//post
	HashMap<String, String> param;
	ObjectMapper mapper;
	String requestBody;
	HttpURLConnection con;
	public String httpGet(String ip){
		client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create(ip))
                .build();
        
		
		try {
			response = client.send(request,
			        HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("response.body() = "+response.body());
		return response.body();
	}
	
	public String httpPost(String ip,String json){
		String urlParameters = convertToString(json);//"seq=12313321&companyName=test";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        StringBuilder content=null;
        try {

        	URL myurl = new URL(ip);
        	con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Java client");
            con.setRequestProperty("charset", StandardCharsets.UTF_8.displayName());
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            }

            

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(),"utf-8"))) {

                String line;
                content = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            System.out.println("return : "+content.toString());

        }catch(Exception e) {
        	System.out.println("error : "+e.getMessage());
        }
        finally {
            con.disconnect();
        }
		
		return content.toString();
	}
	
	public String convertToString(String json) {
		String data=json.replace("{", "").replace("}", "");
		String data_spl[]=data.split(",");
		String result="";
		for(int i=0;i<data_spl.length;i++) {
			if(data_spl[i].indexOf("null")==-1)
			{
				if(result.equals(""))
				{
					result=data_spl[i].replace("\"", "").replace(":","=");
				}
				else
				{
					result=result+"&"+data_spl[i].replace("\"", "").replace(":","=");
				}
			}
		}
		return result;
	}
}