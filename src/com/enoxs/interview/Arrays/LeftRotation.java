package com.enoxs.interview.Arrays;

import com.enoxs.util.TestUtil;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LeftRotation extends TestUtil {
    protected int[] rotLeft(int[] a, int d) {
        int[] res = new int[a.length];
        int rightMove = a.length - (d % a.length);
        if(rightMove > 0){
            for (int i = 0; i < rightMove; i++) {
                res[i] = a[a.length - rightMove + i];
            }
            for (int i = rightMove; i < res.length ; i++) {
                res[i] = a[i - rightMove];
            }
        }
        return res;
    }

    @Test
    public void testExampleCase() {
        int arr[] = {1, 2, 3, 4, 5};
        int left = 4;
        int[] res = rotLeft(arr, left);
        int[] ans = {5, 1, 2, 3, 4};
        assertArrayEquals(ans, res);
    }

    @Test
    public void testCase01(){
        int arr[] = {41 ,73 ,89 ,7 ,10 ,1 ,59 ,58 ,84 ,77 ,77 ,97 ,58 ,1 ,86 ,58 ,26 ,10 ,86 ,51};
        int left = 10;
        int[] res = rotLeft(arr, left);
        int ans[] = {77 ,97, 58 ,1 ,86, 58 ,26 ,10, 86 ,51 ,41 ,73 ,89 ,7 ,10 ,1 ,59 ,58 ,84 ,77};
        assertArrayEquals(ans, res);
    }

}
