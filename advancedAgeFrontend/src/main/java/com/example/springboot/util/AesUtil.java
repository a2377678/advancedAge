package com.example.springboot.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.springboot.controller.CompanyInfoController;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 *  加密工具类
 */
public class AesUtil {

	static Logger logger = LogManager.getLogger(AesUtil.class);
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";//默认的加密算法
    private static final String key = SystemConfig.getProperty("encrypt_key")+"Crypt";
    private static final String iv = SystemConfig.getProperty("encrypt_iv")+"IV";
     ;
    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @param iv 使用CBC模式，需要一个向量iv，可增加加密算法的强度
     * @return 加密数据
     */
    public static String encrypt(String content) {
        try {
            //创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //密码key(超过16字节即128bit的key，需要替换jre中的local_policy.jar和US_export_policy.jar，否则报错：Illegal key size)
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("utf-8"),KEY_ALGORITHM);

            //向量iv
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("utf-8"));

            //初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivParameterSpec);

            //加密
            byte[] result = cipher.doFinal(content.getBytes("utf-8"));

            return Base64.getEncoder().encodeToString(result);
        } catch (IOException e) {
        	logger.warn(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
        	logger.warn(e.getMessage());
		} catch (NoSuchPaddingException e) {
			logger.warn(e.getMessage());
		} catch (InvalidKeyException e) {
			logger.warn(e.getMessage());
		} catch (InvalidAlgorithmParameterException e) {
			logger.warn(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			logger.warn(e.getMessage());
		} catch (BadPaddingException e) {
			logger.warn(e.getMessage());
		}

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content 密文
     * @param password 密码
     * @param iv 使用CBC模式，需要一个向量iv，可增加加密算法的强度
     * @return 明文
     */
    public static String decrypt(byte[] content) {

        try {
            //创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //密码key
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("utf-8"),KEY_ALGORITHM);

            //向量iv
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("utf-8"));

            //初始化为解密模式的密码器
            cipher.init(Cipher.DECRYPT_MODE,keySpec,ivParameterSpec);

            //执行操作
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(content));

            return new String(result,"utf-8");
        } catch (IOException e) {
        	logger.warn(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
        	logger.warn(e.getMessage());
		} catch (NoSuchPaddingException e) {
			logger.warn(e.getMessage());
		} catch (InvalidKeyException e) {
			logger.warn(e.getMessage());
		} catch (InvalidAlgorithmParameterException e) {
			logger.warn(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			logger.warn(e.getMessage());
		} catch (BadPaddingException e) {
			logger.warn(e.getMessage());
		}

        return null;
    }



}