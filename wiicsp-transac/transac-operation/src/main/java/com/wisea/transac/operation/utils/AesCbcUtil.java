package com.wisea.transac.operation.utils;

import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.wisea.cloud.common.util.JsonMapper;

import net.sf.json.JSONObject;

/**
 * 微信解密相关的UTIL
 *
 * Created by yfs on 2017/2/6.
 * <p>
 * AES-128-CBC 加密方式
 * 注：
 * AES-128-CBC可以自己定义“密钥”和“偏移量“。
 * AES-128是jdk自动生成的“密钥”。
 */
/**
 * 微信解密相关的UTIL
 *
 *
 * @author wangh(wisea)
 *  ES-128-CBC 加密方式
 *  注：
 *  AES-128-CBC可以自己定义“密钥”和“偏移量“。
 *  AES-128是jdk自动生成的“密钥”。
 * @date 2019年3月27日
 * @version 1.0
 */
public class AesCbcUtil {
    static {
        //BouncyCastle是一个开源的加解密解决方案，主页在http://www.bouncycastle.org/
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * AES解密
     *
     * @param data           //密文，被加密的数据
     * @param key            //秘钥
     * @param iv             //偏移量
     * @param encodingFormat //解密后的结果需要进行的编码
     * @return
     * @throws Exception
     */
    public static JSONObject decrypt(String data, String key, String iv, String encodingFormat){
//        initialize();

        //被加密的数据
        byte[] dataByte = Base64.decodeBase64(data);
        //加密秘钥
        byte[] keyByte = Base64.decodeBase64(key);
        //偏移量
        byte[] ivByte = Base64.decodeBase64(iv);
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");

            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");

            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));

            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化

            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, encodingFormat);
                return (JSONObject) JsonMapper.fromJsonString(result,JSONObject.class);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
	 * 小程序解密用户数据
	 *
	 * @param encryptedData
	 * @param sessionKey
	 * @param iv
	 * @return
	 */
	public static JSONObject decryptionUserInfo(String encryptedData, String sessionKey, String iv) {
		// 被加密的数据
		byte[] dataByte = Base64.decodeBase64(encryptedData);
		// 加密秘钥
		byte[] keyByte = Base64.decodeBase64(sessionKey);
		// 偏移量
		byte[] ivByte = Base64.decodeBase64(iv);
		try {
			// 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
			int base = 16;
			if (keyByte.length % base != 0) {
				int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
				byte[] temp = new byte[groups * base];
				Arrays.fill(temp, (byte) 0);
				System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
				keyByte = temp;
			}
			// 初始化
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
			SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
			AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
			parameters.init(new IvParameterSpec(ivByte));
			cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
			byte[] resultByte = cipher.doFinal(dataByte);
			if (null != resultByte && resultByte.length > 0) {
				String result = new String(resultByte, "UTF-8");
				return (JSONObject) JsonMapper.fromJsonString(result,JSONObject.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
     * 解密处理
     *
     * @author wangh(wisea)
     *
     * @date 2019年12月26日
     * @version 1.0
     */
    public static JSONObject decryptDataS5(String encryptedData,String sessionKey, String iv){
        byte[] dataByte = Base64.decodeBase64(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decodeBase64(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decodeBase64(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return (JSONObject) JsonMapper.fromJsonString(result,JSONObject.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
