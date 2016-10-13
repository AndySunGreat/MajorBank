package com.majorbank.common;

/**
 * Created by AndySun on 2016/10/13.
 */
public class CovertCodeUtil {
    /*0-9对应Ascii 48-57
        *A-Z 65-90
        *a-z 97-122
        *第33～126号(共94个)是字符，其中第48～57号为0～9十个阿拉伯数字
        */
    public static final String getPositionBySeq(String answerseq){
        char[] strChar = answerseq.toCharArray();
        int b =0;
        String strPositons = "";
        for (int i=0;i<strChar.length;i++){
            char a = strChar[i];
            System.out.print(a+"  ");
            b = (int)a;
            b = b-64;
            strPositons = strPositons + b;
            if(i<strChar.length-1){
                strPositons = strPositons + ",";
            }
        }
        return strPositons;
    }

}
