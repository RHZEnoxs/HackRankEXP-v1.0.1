package com.enoxs.interview.sorting;

import com.enoxs.util.TestUtil;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BubbleSortCountSwaps extends TestUtil {
    int mSwap = 0;
    int mFirst = 0;
    int mLast = 0;

    /**
     * output
     * Array is sorted in 3 swaps.
     * First Element: 1
     * Last Element: 3
     */
    protected void countSwaps(int[] a) {
        // BubbleSort
        int swap = 0;
        int first = 0;
        int last = 0;
        int len = a.length;
        int tmp;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swap++;
                }
            }
        }
        first = a[0];
        last = a[len - 1];
        System.out.println("Array is sorted in " + swap + " swaps.");
        System.out.println("First Element: " + first);
        System.out.println("Last Element: " + last);
        mSwap = swap;
        mFirst = first;
        mLast = last;
    }

    @Test
    public void testExampleCase() {
        int[] source = {6, 4, 1};
        countSwaps(source);
        assertEquals(3, mSwap);
        assertEquals(1, mFirst);
        assertEquals(6, mLast);

    }

    @Test
    public void testExampleCase01() {
        int[] source = {1, 2, 3};
        countSwaps(source);
        assertEquals(0, mSwap);
        assertEquals(1, mFirst);
        assertEquals(3, mLast);
    }

    @Test
    public void testExampleCase02() {
        int[] source = {3, 2, 1};
        countSwaps(source);
        assertEquals(3, mSwap);
        assertEquals(1, mFirst);
        assertEquals(3, mLast);
    }
}
