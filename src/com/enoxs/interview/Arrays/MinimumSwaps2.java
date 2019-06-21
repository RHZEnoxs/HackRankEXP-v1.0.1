package com.enoxs.interview.Arrays;

import com.enoxs.util.TestUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Difficulty: Medium
 */
public class MinimumSwaps2 extends TestUtil {
    /**
     * 從前面遇到第一個最大的與從後面遇到第一個最小的 交換
     * i   arr                     swap (indices)
     * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
     * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
     * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
     * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
     * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
     * 5   [1, 2, 3, 4, 5, 6, 7]
     */
    protected int minimumSwaps(int[] arr) {
        int len = arr.length;

        int max = arr[0];
        int maxPos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) {
                max = arr[i];
                maxPos = i;
            } else {
                break;
            }
        }
        int min = len;
        int minPos = 0;
        int pos;
        for (int i = 0; i < arr.length; i++) {
            pos = len - 1 - i;
            if (min < arr[pos]) {
                min = arr[pos];
                minPos = pos;
            }else{
                break;
            }
        }

        System.out.println("max: " + max);
        System.out.println("maxPos: " + maxPos);
        System.out.println("min: " + min);
        System.out.println("minPos: " + minPos);

        int result = 5;
        return result;
    }


    @Test
    public void testExampleCase01() {
        int[] input = {7, 1, 3, 2, 4, 5, 6};
        int actual = minimumSwaps(input);
        int expect = 5;
        assertEquals(expect, actual);
    }

    @Test
    public void testExampleCase02() {
        int[] input = {4, 3, 1, 2};
        int actual = minimumSwaps(input);
        int expect = 3;
        assertEquals(expect, actual);
    }

    @Test
    public void testExampleCase03() {
        int[] input = {2, 3, 4, 1, 5};
        int actual = minimumSwaps(input);
        int expect = 3;
        assertEquals(expect, actual);
    }

    @Test
    public void testExampleCase04() {
        int[] input = {1, 3, 5, 2, 4, 6, 7};
        int actual = minimumSwaps(input);
        int expect = 3;
        assertEquals(expect, actual);
    }

    @Test
    public void testCase04() {
        int[] input = {2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19};
        int actual = minimumSwaps(input);
        int expect = 46;
        assertEquals(expect, actual);
    }


}
