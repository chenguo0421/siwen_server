package com.xqkj.siwencat.utils;

import java.security.MessageDigest;

public class RandomUtils {

    //盐，用于混交md5
    private static final String slat = "&%5123***&&%%$$#@";

    public int getRandomCode(){
        int intFlag = (int)(Math.random() * 1000000);

        String flag = String.valueOf(intFlag);
        if (flag.length() != 6 || !flag.substring(0, 1).equals("9")) {
            intFlag = intFlag + 100000;
        }
        System.out.println(intFlag);
        return intFlag;
    }


    public int getRandomCode_8(){
        int intFlag = (int)(Math.random() * 100000000);
        String flag = String.valueOf(intFlag);
        if (flag.length() != 6 || !flag.substring(0, 1).equals("9")) {
            intFlag = intFlag + 10000000;
        }
        return intFlag;
    }


    public String getMD5(String dataStr) {
        try {
            dataStr = dataStr + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }


}
