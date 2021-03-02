package com.wisea.equipment.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

import static java.util.Base64.getEncoder;

/**
 * @author jirg
 * @date 2020/7/8 16:08
 * @Description 讯飞密码加密工具类
 */
public class XaircraftAesCbcUtil {
    private static String ALGO = "AES";
    private static String ALGO_MODE = "AES/CBC/NoPadding";

    /**
     * @author jirg
     * @date 2020/7/8 16:08
     * @Description 加密
     */
    public static String encrypt(String date, String key, String iv) {
        try {
            byte[] keyMD5 = md5(key);
            byte[] ivMD5 = md5(iv);

            Cipher cipher = Cipher.getInstance(ALGO_MODE);
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = pkcs7padding(date).getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(keyMD5, ALGO);
            IvParameterSpec ivspec = new IvParameterSpec(ivMD5);
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(getEncoder().encode(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static byte[] md5(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            return md.digest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


    //  此函数是将字符串每两个字符合并生成byte数组
    public static byte[] toByteArray(String hexString) {
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() >> 1];
        int index = 0;
        for (int i = 0; i < hexString.length(); i++) {
            if (index > hexString.length() - 1)
                return byteArray;
            byte highDit = (byte) (Character.digit(hexString.charAt(index), 16) & 0xFF);
            byte lowDit = (byte) (Character.digit(hexString.charAt(index + 1), 16) & 0xFF);
            byteArray[i] = (byte) (highDit << 4 | lowDit);
            index += 2;
        }
        System.out.println(byteArray.length);
        return byteArray;
    }

    //  此函数是pkcs7padding填充函数
    public static String pkcs7padding(String data) {
        int bs = 16;
        int padding = bs - (data.length() % bs);
        String padding_text = "";
        for (int i = 0; i < padding; i++) {
            padding_text += (char) padding;
        }
        return data + padding_text;
    }
}