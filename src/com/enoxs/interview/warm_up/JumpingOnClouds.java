package com.enoxs.interview.warm_up;

import com.enoxs.util.TestUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JumpingOnClouds extends TestUtil {
    protected int jumpingOnClouds(int[] c) {
        int count = 0;
        int zeroCount = 0;
        for (int i=0;i<c.length;i++) {
            if (c[i] == 1) {
                if (zeroCount > 1) {
                    count += zeroCount / 2;

                }
                count++;
                zeroCount = 0;
            } else {
                zeroCount++;
            }
            if(i == c.length -1){
                if (zeroCount > 1) {
                    count += zeroCount / 2;
                }
            }
        }
        return count;
    }

    @Test
    public void testExampleCase01() {
        int[] input = {0, 0, 1, 0, 0, 1, 0};
        int actual = jumpingOnClouds(input);
        int expect = 4;
        assertEquals(expect, actual);
    }

    @Test
    public void testExampleCase02() {
        int[] input = {0, 0, 0, 0, 1, 0};
        int actual = jumpingOnClouds(input);
        int expect = 3;
        assertEquals(expect, actual);
    }
    @Test
    public void testCase01(){
        int[] input = {0 ,0 ,0 ,1 ,0 ,0};
        int actual = jumpingOnClouds(input);
        int expect = 3;
        assertEquals(expect, actual);
    }
    @Test
    public void testCase03(){
        int[] input = {0 ,0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0};
        int actual = jumpingOnClouds(input);
        int expect = 28;
        assertEquals(expect, actual);
    }
}
