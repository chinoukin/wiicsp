package com.wisea.cultivar.plant.utils;

import java.security.MessageDigest;

public class Md5Utils {
    public final static String md5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(Md5Utils.md5("20121221"));
        System.out.println(Md5Utils.md5("加密"));
    }

    //获取10位纯数字md5加密
    public static String getMD5(String s) {
	    char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	    try
		   {
		    MessageDigest md = MessageDigest.getInstance( "MD5" );
		    byte[] btInput = s.getBytes();
		    md.update(btInput);
		    byte tmp[] = md.digest();
		    char str[] = new char[10];
		    int k = 0;
		    for (int i = 0; i < 10; i++) {
		     byte byte0 = tmp[i];
		    //只取高位
		    str[k++] = hexDigits[(byte0 >>> 4 & 0xf)%10];
		    // str[k++] = hexDigits[byte0 & 0xf];
		   }
		      s = new String(str);  // 换后的结果转换为字符串
		    }catch( Exception e )
		   {
		       e.printStackTrace();
		   }
	   return s;
	 }
}
