package com.xqkj.siwencat.utils;

public class RandomUtils {
    public int getRandomCode(){
        int intFlag = (int)(Math.random() * 1000000);

        String flag = String.valueOf(intFlag);
        if (flag.length() == 6 && flag.substring(0, 1).equals("9"))
        {
            System.out.println(intFlag);
        }
        else
        {
            intFlag = intFlag + 100000;
            System.out.println(intFlag);
        }
        return intFlag;
    }
}
