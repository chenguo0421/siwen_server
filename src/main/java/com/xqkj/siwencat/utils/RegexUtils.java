package com.xqkj.siwencat.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    /***
     * 手机号码检测
     */
    public static boolean checkPhoneNum(String num){
        String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(14[5-9])|(166)|(19[8,9])|)\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(num);
        return m.matches();
    }

    /***
     * 8位密码，包含字母数字
     */
    public static boolean checkPSW(String psw){
        String regex = "^(?=.*[A-Za-z])(?=.*[0-9])(?!.*([~!@&%$^\\(\\)#_]).*\\1.*\\1)[A-Za-z0-9~!@&%$^\\(\\)#_]{8,16}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(psw);
        return m.matches();
    }

}
