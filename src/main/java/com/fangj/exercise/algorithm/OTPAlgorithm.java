package com.fangj.exercise.algorithm;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

/**
 * @author fangjie
 * @date Created in 下午4:11 18/8/3.
 */
public class OTPAlgorithm {

    public static void main(String[] args) {
        String code = generateOTP("asfd", "123335", "6");
        System.out.println(code);
    }

    public static String generateOTP(String K,
                                     String C,
                                     String returnDigits) {
        int codeDigits = Integer.decode(returnDigits).intValue();
        String result = null;
        // K是密码
        // C是产生的随机数
        // crypto是加密算法 HMAC-SHA-1
        byte[] hash = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, K).hmac(C);
        // hash为20字节的字符串

        // put selected bytes into result int
        // 获取hash最后一个字节的低4位，作为选择结果的开始下标偏移
        int offset = hash[hash.length - 1] & 0xf;

        // 获取4个字节组成一个整数，其中第一个字节最高位为符号位，不获取，使用0x7f
        int binary =
                ((hash[offset] & 0x7f) << 24) |
                        ((hash[offset + 1] & 0xff) << 16) |
                        ((hash[offset + 2] & 0xff) << 8) |
                        (hash[offset + 3] & 0xff);
        // 获取这个整数的后6位（可以根据需要取后8位）
        int otp = binary % 1000000;
        // 将数字转成字符串，不够6位前面补0
        result = Integer.toString(otp);
        while (result.length() < codeDigits) {
            result = "0" + result;
        }
        return result;
    }

}
