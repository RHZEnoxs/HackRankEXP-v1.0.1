package com.enoxs.interview.Arrays;

import com.enoxs.util.TestUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Array2D extends TestUtil {
    protected int hourglassSum(int[][] arr) {
        int wight = arr.length - 2;
        int height = arr.length - 2;
        int result;
        int max = 0;
        for (int i = 0; i < wight; i++) {
            result = 0;
            for (int j = 0; j < height; j++) {
                result += arr[i][j];
                result += arr[i][j + 1];
                result += arr[i][j + 2];
                result += arr[i + 1][j + 1];
                result += arr[i + 2][j];
                result += arr[i + 2][j + 1];
                result += arr[i + 2][j + 2];
                if (result > max || (i == 0 && j == 0)) {
                    max = result;
                }
                result = 0;
            }
        }
        return max;
    }

    @Test
    public void testExampleCase() {
        int[][] source =
                {
                        {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}
                };
        int actual = hourglassSum(source);
        int expect = 19;
        assertEquals(expect, actual);
    }

    @Test
    public void testCase03() {
        int[][] source =
                {
                        {-1, -1, 0, -9, -2, -2},
                        {-2, -1, -6, -8, -2, -5},
                        {-1, -1, -1, -2, -3, -4},
                        {-1, -9, -2, -4, -4, -5},
                        {-7, -3, -3, -2, -9, -9},
                        {-1, -3, -1, -2, -4, -5}
                };
        int actual = hourglassSum(source);
        int expect = -6;
        assertEquals(expect, actual);
    }

}
