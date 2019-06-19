package com.enoxs.interview.warm_up;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountingValleys {
    //Counting Valleys
    // n: the number of steps Gary takes
    // s: a string describing his path
    // Print a single integer that denotes the number of valleys Gary walked through during his hike.
    protected int countingValleys(int n, String s) {
        char[] trace = new char[n];
        for (int i = 0; i < s.length(); i++) {
            trace[i] = s.charAt(i);
        }

        int count = 0;
        int level = 0;
        boolean isDown = false;
        for(int i=0;i<trace.length;i++){
            if(trace[i] == 'U'){
                level ++;
            }

            if(trace[i] == 'D'){
                level --;
            }

            if(level < 0 ){
                isDown = true;
            }

            if(level == 0 && isDown){
                count ++;
                isDown = false;
            }
        }
        return count;
    }

    @Test
    public void exampleInputCase() {
        int actual = countingValleys(8, "UDDDUDUU");
        int expect = 1;
        assertEquals(expect, actual);
    }

    @Test
    public void testCase01(){
        int actual = countingValleys(12, "DDUUDDUDUUUD");
        int expect = 2;
        assertEquals(expect, actual);
    }


}
