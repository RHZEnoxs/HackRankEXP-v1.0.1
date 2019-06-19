package com.enoxs.interview.warm_up;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SockMerchant {
    //Sock Merchant
    // n: the number of socks in the pile
    // ar: the colors of each sock
    protected int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> lstKey = new LinkedList<>();
        for (int key : ar) {
            if (map.get(key) == null) {
                map.put(key, 1);
                lstKey.add(key);
            } else {
                int count = map.get(key);
                count++;
                map.put(key, count);
            }
        }

        int result = 0;
        for (Integer key : lstKey) {
            int count = map.get(key);
            if(count > 1){
                count = count / 2;
                result += count;
            }
        }
        return result;
    }

    @Test
    public void exampleInputCase() {
        int n = 9;
        int[] arr = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int actual = sockMerchant(n, arr);
        int expect = 3;
        assertEquals(expect, actual);
    }


}
