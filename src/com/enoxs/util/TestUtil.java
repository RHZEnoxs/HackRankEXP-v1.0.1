package com.enoxs.util;

public class TestUtil {
    protected String expect, actual, source, result, target;
    protected StringBuffer message = new StringBuffer(64);
    protected void print(String msg){
        System.out.println(msg);
    }

    protected void print(){
        System.out.println(message);
    }

    protected void add(String msg){
        message.append(msg);
    }

    protected void clear(){
        message.setLength(0);
    }


}
