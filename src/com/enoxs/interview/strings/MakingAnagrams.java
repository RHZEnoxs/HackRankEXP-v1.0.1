package com.enoxs.interview.strings;

import com.enoxs.util.TestUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MakingAnagrams extends TestUtil {
    protected int makeAnagram(String a, String b) {
        char[] arrA = new char[a.length()];
        char[] arrB = new char[b.length()];
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = a.charAt(i);
        }
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = b.charAt(i);
        }
        int count = 0;
        int result;
        boolean isDone;
        for (int i = 0; i < arrA.length; i++) {
            isDone = false;
            for (int j = 0; j < arrB.length; j++) {
                if (arrA[i] == arrB[j]) {
                    arrA[i] = 0;
                    arrB[j] = 0;
                    isDone = true;
                    break;
                }
            }
            if (!isDone) {
                count++;
                arrA[i] = 0;
            }
        }
        result = count;
        count = 0;
        for (char c : arrB) {
            if (c != 0) {
                count++;
            }
        }
        result += count;
        return result;
    }


    @Test
    public void testExampleCase() {
        String inputA = "cde";
        String inputB = "abc";
        actual = "" + makeAnagram(inputA, inputB);
        expect = "4";
        assertEquals(expect, actual);
    }

    @Test
    public void testCase01() {
        String inputA = "fcrxzwscanmligyxyvym";
        String inputB = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        actual = "" + makeAnagram(inputA, inputB);
        expect = "30";
        assertEquals(expect, actual);
    }

    @Test
    public void testCase02(){
        String inputA = "showman";
        String inputB = "woman";
        actual = "" + makeAnagram(inputA, inputB);
        expect = "2";
        assertEquals(expect, actual);
    }

}
