package com.enoxs.interview.other;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class Brackets {

    protected String solution(String input) {
        String result = "No!";
        List<String> lstQueue = new LinkedList<String>();
        for (int i = 0; i < input.length(); i++) {
            lstQueue.add(input.charAt(i) + "");
        }
        List<String> lstCompare = new LinkedList<String>();
        for (String s : lstQueue) {
            if(lstCompare.size() > 0){
                String pop = lstCompare.get(lstCompare.size()-1);
                if(pop.equals("(") && s.equals(")")  ){
                    lstCompare.remove(lstCompare.size()-1);
                }else{
                    lstCompare.add(s);
                }
            }else{
                lstCompare.add(s);
            }
        }
        if(lstCompare.size() == 0){
            result = "Yes!";
        }
        return result;
    }


    @Test
    public void input01() {
        String source = "))((((())";
        String actual = solution(source);
        String expect = "No!";
        assertEquals(expect, actual);
    }

    @Test
    public void input02() {
        String source = "()()()()(())(()())";
        String actual = solution(source);
        String expect = "Yes!";
        assertEquals(expect, actual);
    }

    @Test
    public void setTest() {
        Set set = new HashSet();
        set.add("H1");
        set.add("H2");
        set.add("H3");
//        set
    }
}
