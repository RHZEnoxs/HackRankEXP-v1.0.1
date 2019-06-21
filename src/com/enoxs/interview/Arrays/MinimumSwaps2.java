package com.enoxs.interview.Arrays;

import com.enoxs.util.TestUtil;
import org.junit.Test;

import java.util.*;

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
        int[] sort = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sort);

        int swap1Count = 0;
        int swapNSub1Count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sort.length; i++) {
            map.put(arr[i], sort[i]);
        }

        int key, pos, count;
        List<Integer> lstPos = new LinkedList<>();

        for (int i = 0; i < sort.length; i++) {
            if (arr[i] != sort[i] && arr[i] != 0) {
                key = map.get(arr[i]);
                if (map.get(key) == arr[i]) {// swap1Count
                    swap1Count++;
                    pos = arr[i] - 1;
                    arr[i] = 0;
                    arr[pos] = 0;
                } else {//swapNSub1Count-1
                    count = 0;
                    lstPos.add(i);

                    while (key != arr[i]) {
                        key = map.get(key);

                        pos = key - 1;
                        lstPos.add(pos);

                        count++;
                    }

                    for (Integer index : lstPos) {
                        arr[index] = 0;
                    }
                    lstPos.clear();
                    swapNSub1Count += count;
                }
            }
        }

        int result = swap1Count + swapNSub1Count;
        return result;
    }

    @Test
    public void testDemoCase() {
        int[] input = {2, 4, 5, 1, 3};
        int actual = minimumSwaps(input);
        int expect = 3;
        assertEquals(expect, actual);
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


    private int answerFromInternet(int[] arr) {
        MyNumber[] ascArr = new MyNumber[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            ascArr[i] = new MyNumber(i, arr[i]);
        }
        Arrays.sort(ascArr, new Comparator<MyNumber>() {

            @Override
            public int compare(MyNumber o1, MyNumber o2) {
                return o1.value - o2.value;
            }

        });

        int[] visited = new int[arr.length];
        int i = 0;
        int res = 0;
        int count = 0;
        while (true) {
            if (count > 0) {
                res += (count - 1);
                count = 0;
            }
            int j = 0;
            for (; j < visited.length; ++j) {
                if (visited[j] == 0) {
                    if (arr[j] == ascArr[j].value) {
                        visited[j] = 1;
                    } else {
                        i = j;
                        break;
                    }
                }
            }
            if (j >= visited.length) {
                break;
            }
            //找到某個閉環
            while (i < arr.length && visited[i] == 0) {
                if (arr[i] != ascArr[i].value) {
                    visited[i] = 1;
                    i = ascArr[i].index;
                    ++count;
                }


            }
        }
        return res;
    }

    static class MyNumber {
        int index;
        int value;

        MyNumber(int index, int val) {
            this.index = index;
            this.value = val;
        }
    }


}
