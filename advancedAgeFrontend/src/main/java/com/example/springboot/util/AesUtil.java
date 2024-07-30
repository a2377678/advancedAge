package com.example.springboot.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.springboot.controller.CompanyInfoController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 *  加密工具类
 */
public class AesUtil {

	static Logger logger = LogManager.getLogger(AesUtil.class);
    private static final String key = SystemConfig.getProperty("encrypt")+"Crypt";// key 长度只能是 16、25 或 32 字节
    private static final String iv = SystemConfig.getProperty("encrypt")+"GCMIV";
    private static final String aad = "aad"; // AAD 长度无限制，可为空
    private static final int tagLength = 128; // tag 长度必须是 128、120、112、104、96 之一
    
    public static String encrypt(String data){
    	try {
	        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"), new GCMParameterSpec(tagLength, iv.getBytes("utf-8")));
	        cipher.updateAAD(aad.getBytes("utf-8"));
	        byte[] result = cipher.doFinal(data.getBytes("utf-8"));
	        return Base64.getEncoder().encodeToString(result);
    	}catch(NoSuchAlgorithmException e) {
    		logger.warn(e.getMessage());
    	} catch (NoSuchPaddingException e) {
    		logger.warn(e.getMessage());
		} catch (InvalidKeyException e) {
			logger.warn(e.getMessage());
		} catch (InvalidAlgorithmParameterException e) {
			logger.warn(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.warn(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			logger.warn(e.getMessage());
		} catch (BadPaddingException e) {
			logger.warn(e.getMessage());
		}
    	return null;
    }

    public static String decrypt(byte[] data){
    	try {
	        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"), new GCMParameterSpec(tagLength, iv.getBytes("utf-8")));
	        cipher.updateAAD(aad.getBytes("utf-8"));
	        byte[] result = cipher.doFinal(Base64.getDecoder().decode(data));
	        return new String(result,"utf-8");
    	}catch(NoSuchAlgorithmException e) {
    		logger.warn(e.getMessage());
    	} catch (NoSuchPaddingException e) {
    		logger.warn(e.getMessage());
		} catch (InvalidKeyException e) {
			logger.warn(e.getMessage());
		} catch (InvalidAlgorithmParameterException e) {
			logger.warn(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.warn(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			logger.warn(e.getMessage());
		} catch (BadPaddingException e) {
			logger.warn(e.getMessage());
		}
    	return null;
    }
}