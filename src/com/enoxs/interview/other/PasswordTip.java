package com.enoxs.interview.other;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PasswordTip {


    protected String solution(String input){
        int [] code = new int[input.length()];
        StringBuffer sb = new StringBuffer(16);
        for (int i = 0; i < input.length(); i++) {
           code[i] = input.charAt(i);
        }

        for (int i = 0; i < code.length; i++) {
            if(i < code.length - 1 ){
                int num;
                if((code[i] >= 'A' && code[i] <= 'Z')){
                    if(code[i] > code[i+1]){
                        num = code[i] - code[i+1];
                    }else{
                        num = code[i+1] - code[i];
                    }
                    sb.append(num);
                }else{
                    sb.setLength(0);
                    sb.append("輸入錯誤");
                    break;
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void input01(){
        String source = "POKEMON";
        String actual = solution(source);
        String expect = "146821";
        assertEquals(expect,actual);
    }

    @Test
    public void input02(){
        String source = "abcfg";
        String actual = solution(source);
        String expect = "輸入錯誤";
        assertEquals(expect,actual);
    }
    @Test
    public void printNum(){
        String num = "aAzZ"; // 65 ~ 90
        int [] code = new int[num.length()];
        for (int i = 0; i < code.length; i++) {
            code[i] = num.charAt(i);
        }
        System.out.println(Arrays.toString(code));
    }

}
