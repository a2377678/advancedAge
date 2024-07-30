package com.example.springboot.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.springboot.entity.CompanyInfo;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

@Component
public class SSOloginUtil {

	RSA_Util rsa;

	@Bean
	public void readKey() {
		RSA_Util rsa = null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("C:\\advancedAge\\0036RSA_privateKey.xml"), "UTF-8")); // 指定讀取文件的編碼格式，以免出現中文亂碼
			String str = null;
			StringBuffer sb = new StringBuffer();
			while ((str = reader.readLine()) != null) {
				sb.append(str);
			}
			rsa = new RSA_Util(RSA_PEM.FromXML(sb.toString()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		this.rsa = rsa;
	}

	public String encode(String plainText) throws Exception {
		return URLEncoder.encode(rsa.Encode(plainText), "UTF-8");
	}

	public String decode(String decodeText) throws UnsupportedEncodingException, Exception {
		return rsa.Decode(decodeText.replace(" ", "+"));
	}

	public CompanyInfo parseXmlStringToCompanyInfo(String parseText) {
		CompanyInfo info = new CompanyInfo();
		Document doc;
		try {
			doc = DocumentHelper.parseText(parseText);
			Element root = doc.getRootElement();
			info.setCompanyName(decode(root.elementText("COMP_NAME")));
			info.setSeq(decode(root.elementText("IDNO")));
			info.setSsoMid(decode(root.elementText("MID")));
//			info.setPrincipal(decode(root.elementText("MNGNAME")));
//			info.setContactName(decode(root.elementText("CONNAME")));
			//連絡電話:XXX、聯絡手機:XXX 格式，所以拿掉
//			info.setContactPhone(decode(root.elementText("CONTACT")));
			//地址:XXXX11號之1、12號之2，所以拿掉
//			info.setRegisterAddress(decode(root.elementText("COMP_ADDR")));
//			info.setEmail(decode(root.elementText("COMP_EMAIL")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return info;
	}
	
}
