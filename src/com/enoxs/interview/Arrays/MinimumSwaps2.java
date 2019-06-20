package com.enoxs.interview.Arrays;

import com.enoxs.util.TestUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Difficulty: Medium
 */
public class MinimumSwaps2 extends TestUtil {

    protected int minimumSwaps(int[] arr) {

        int sort [] = new int[arr.length];

        for (int i = 0; i < sort.length; i++) {
            sort[i] = arr[i];

        }

        int tmp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }

            }
        }

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < sort.length; i++) {
            map.put(arr[i],sort[i]);
        }

        int directSwapCount = 0;
        int count = 0;
        for (int i = 0; i < sort.length; i++) {
            if(sort[i] != arr[i]){
                int value = map.get(arr[i]);
                if(map.get(value) == sort[i]){
                    directSwapCount ++;
                }else{
                    count ++ ;
                }
            }
        }

        if(count > 2){
            count = count - 1;
        }

        System.out.println(directSwapCount);
        System.out.println(count);

        int result = directSwapCount + count;

        return result;
    }


    @Test
    public void testExampleCase01() {
        int[] input = {7, 1, 3, 2, 4, 5, 6};
        int actual = minimumSwaps(input);
        int expect = 5;
        assertEquals(expect, actual);
    }


}
