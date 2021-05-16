package com.peake.webseed.utils;

import java.util.Date;

public class CodeUtils {
    public static String genOutTradeNo(){

        String n = DateUtils.format(new Date(), "yyyyMMddHHmmssSSS");
        n=n.substring(2);
        n+=createDigitCode(6);
        return n;
    }
    public static String genPicName(){

        String n = DateUtils.format(new Date(), "yyyyMMddHHmmssSSS");
        n+=createDigitCode(4);
        return n;
    }


    /**
     * 生成数字随机码
     * @author lei.ma 2016年6月3日 上午10:45:58
     * @param length 随机码长度
     * @return
     */
    public static String createDigitCode(int length) {

        String[] rS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * rS.length);
            sb.append(rS[index]);
        }
        return sb.toString();

    }

}
