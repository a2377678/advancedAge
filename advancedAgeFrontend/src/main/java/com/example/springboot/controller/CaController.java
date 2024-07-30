package com.example.springboot.controller; 

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Store;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.com.chttl.CertUtil;

import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.util.Base64;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller 
public class CaController { 
	
	Logger logger = LogManager.getLogger(CaController.class);
	CallApi api = new CallApi();

	@Value("${api_ip}")
	private String ip;
	CMSSignedData cms;
	X509Certificate userCert;
	Date signTime;
	String cardNumber;
	String nonce;
	HttpSession session;
	
	public final ASN1ObjectIdentifier NONCE_OID=new ASN1ObjectIdentifier("1.2.840.113549.1.9.25.3");
	public final ASN1ObjectIdentifier SIGNTIME_OID=new ASN1ObjectIdentifier("1.2.840.113549.1.9.5");
	public final ASN1ObjectIdentifier CARDSN_OID=new ASN1ObjectIdentifier("2.16.886.1.100.2.204");
	
	public void setB64SignedData(String sigb64){
		try {
			cms = new CMSSignedData(Base64.decode(sigb64));
		} catch (CMSException e) {
			logger.warn(e.getMessage());
		}
	}
	public String getCardSN(){return cardNumber;}
	public String getNonce(){return nonce;}
	public Date getSignTime(){return signTime;}
	public String getDn(){
		if(userCert==null) return "No User Certificate";
		return userCert.getSubjectDN().toString();
	}
	public String getIssuer(){
		if(userCert==null) return "No User Certificate";
		return userCert.getIssuerDN().toString();
	}
	public String getSerialNumber(){
		if(userCert==null) return "No User Certificate";
		return userCert.getSerialNumber().toString(16);
	}
	public String getNotAfter(){
		if(userCert==null) return "No User Certificate";
		return userCert.getNotAfter().toString();
	}
	public boolean getVerifySignature(){
		try {
	        Store store = cms.getCertificates(); 
	        SignerInformationStore signers = cms.getSignerInfos(); 
	        Collection c = signers.getSigners(); 
	        Iterator it = c.iterator();
	        while (it.hasNext()) { 
	            SignerInformation signer = (SignerInformation) it.next(); 
	            Collection certCollection = store.getMatches(signer.getSID()); 
	            Iterator certIt = certCollection.iterator();
	            X509CertificateHolder certHolder = (X509CertificateHolder) certIt.next();
	            X509Certificate cert = new JcaX509CertificateConverter().getCertificate(certHolder);
	            if (signer.verify(new JcaSimpleSignerInfoVerifierBuilder().build(cert))==false) {
	                return false;
	            }
	            userCert=cert;
	            AttributeTable table=signer.getSignedAttributes();
	            if(table!=null){ 
		            Attribute at=table.get(NONCE_OID);
		            if(at!=null) nonce=at.getAttributeValues()[0].toString();
		            at=table.get(CARDSN_OID);
		            if(at!=null) cardNumber=at.getAttributeValues()[0].toString();
		            at=table.get(SIGNTIME_OID);
		            if(at!=null)
		            {
		            	String dateStr=at.getAttributeValues()[0].toString();
		            	SimpleDateFormat iso8601 = new SimpleDateFormat("yyMMddHHmmssX");
		            	this.signTime=iso8601.parse(dateStr);
		            }
	            }
	        }
	        byte[] data=(byte[])cms.getSignedContent().getContent();
	        
	        return true;
		} catch (ParseException e) {
			logger.warn(e.getMessage());
			return false;
		} catch (CertificateException e) {
			logger.warn(e.getMessage());
			return false;
		} catch (OperatorCreationException e) {
			logger.warn(e.getMessage());
			return false;
		} catch (CMSException e) {
			logger.warn(e.getMessage());
			return false;
		}
	}

	@RequestMapping(value = "/checkCA", method = RequestMethod.POST)
	public void advancedAgeApplyRegisterFileUplolad(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("base64") String base64, String caseType){ 
		
		//讀卡
		setB64SignedData(base64);
		getVerifySignature();
		
        //SERIALNUMBER=82798010, O=弘捷資訊服務有限公司, C=TW
        session=request.getSession();
        String cardData[]=getDn().split(",");
        for(int i=0;i<cardData.length;i++) {
        	if(cardData[i].indexOf("SERIALNUMBER=")!=-1)
        	{
        		session.setAttribute(session.getId()+"seq", cardData[i].substring(cardData[i].indexOf("=")+1, cardData[i].length()));
        	}
        	else if(cardData[i].indexOf("O=")!=-1)
        	{
        		session.setAttribute(session.getId()+"companyName", cardData[i].substring(cardData[i].indexOf("=")+1, cardData[i].length()));
        	}
        }
        
		try {
			response.setContentType("text/html;charset=UTF-8");
			if(session.getAttribute(session.getId()+"seq") == null || session.getAttribute(session.getId()+"companyName") == null)
			{
				response.getWriter().print("fail");
			}
			else
			{
				if(!"".equals(caseType)) {
					AdvancedAgeBase base = new AdvancedAgeBase();
					base.setSeq(session.getAttribute(session.getId()+"seq").toString());
					base.setCaseType(caseType);
					AdvancedAgeBase searchBase = selectAdvancedAgeBase(base);
					if(searchBase.getSeq()== null )
					{
						response.setContentType("text/html;charset=UTF-8");
						response.getWriter().print("no base");
					}else if(searchBase.getCaseStatus().equals("1"))
					{
						response.setContentType("text/html;charset=UTF-8");
						response.getWriter().print("audit");
					}else if(searchBase.getCaseStatus().equals("2"))
					{
						response.setContentType("text/html;charset=UTF-8");
						response.getWriter().print("failed");
					}else if(searchBase.getCaseStatus().equals("3")) {
						response.setContentType("text/html;charset=UTF-8");
						response.getWriter().print("approved");
					}
					else{
						session.setAttribute(session.getId()+"baseId", searchBase.getId());
						response.setContentType("text/html;charset=UTF-8");
						response.getWriter().print("success;"+session.getAttribute(session.getId()+"redirectPath"));
					}
				}else {
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print("no base");
				}
			}
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/employCheckCA", method = RequestMethod.POST)
	public void employCheckCA(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("base64") String base64){ 
		
		//讀卡
		setB64SignedData(base64);
		getVerifySignature();
		
        //SERIALNUMBER=82798010, O=弘捷資訊服務有限公司, C=TW, OU=測試分公司
        session=request.getSession();
        String cardData[]=getDn().split(",");
        String mainCompany="";
        session.setAttribute(session.getId()+"seq", CertUtil.getEnterpriseId(userCert));
        for(int i=0;i<cardData.length;i++) {
        	if(cardData[i].indexOf("O=")!=-1)
        	{
        		mainCompany = cardData[i].substring(cardData[i].indexOf("=")+1, cardData[i].length());
        	}
        	if(cardData[i].indexOf("OU=")!=-1) {
        		mainCompany = mainCompany+"_"+cardData[i].substring(cardData[i].indexOf("=")+1, cardData[i].length());
        	}
        }
        session.setAttribute(session.getId()+"companyName", mainCompany);
		try {
			response.setContentType("text/html;charset=UTF-8");
			if(session.getAttribute(session.getId()+"seq") == null || session.getAttribute(session.getId()+"companyName") == null)
			{
				response.getWriter().print("fail");
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("success;index");
			}
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	public AdvancedAgeBase selectAdvancedAgeBase(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectAdvancedAgeBase", json));
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
}