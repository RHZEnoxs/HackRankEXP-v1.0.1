package com.enoxs.easy;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class LibraryFine {

    // Complete the libraryFine function below.
    protected int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int result = 0;
        int mYear = y1 - y2;
        int mMonth = m1 - m2;
        int mDay = d1 - d2;

        if(mDay > 0){
            result = mDay * 15;
        }

        if(mMonth > 0 ){
            result = mMonth * 500;
        }else if(mMonth < 0){
            result = 0;
        }

        if(mYear > 0){
            result = 10000;
        }else if(mYear < 0 ){
            result = 0;
        }

        return result;
    }

    @Test
    public void onTimeCase01() {
        int actual = libraryFine(6, 6, 2014, 9, 6, 2015);
        int expect = 0;
        assertEquals(expect, actual);
    }

    @Test
    public void onTimeCase02() {
        int actual = libraryFine(6, 6, 2015, 9, 6, 2015);
        int expect = 0;
        assertEquals(expect, actual);
    }

    @Test
    public void sameMonthCase01() {
        int actual = libraryFine(9, 6, 2015, 6, 6, 2015);
        int expect = 45;
        assertEquals(expect, actual);
    }

    @Test
    public void sameYearCase01() {
        int actual = libraryFine(6, 9, 2015, 6, 6, 2015);
        int expect = 1500;
        assertEquals(expect, actual);
    }

    @Test
    public void sameYearCase02() {
        int actual = libraryFine(9, 9, 2015, 6, 6, 2015);
        int expect = 1500;
        assertEquals(expect, actual);
    }

    @Test
    public void outOfYearCase01() {
        int actual = libraryFine(6, 6, 2016, 6, 6, 2015);
        int expect = 10000;
        assertEquals(expect, actual);
    }

    @Test
    public void outOfYearCase02() {
        int actual = libraryFine(9, 9, 2016, 6, 6, 2015);
        int expect = 10000;
        assertEquals(expect, actual);
    }

    @Test
    public void testCase04(){
        int actual = libraryFine(2 ,7, 1014, 1, 1, 1014);
        int expect = 3000;
        assertEquals(expect, actual);
    }

    @Test
    public void testCase05(){
        int actual = libraryFine(2 ,7,1014,1, 1, 1015);
        int expect = 0;
        assertEquals(expect, actual);
    }

    @Test
    public void testCase10(){
        int actual = libraryFine(28, 2, 2015,15, 4, 2015);
        int expect = 0;
        assertEquals(expect, actual);

    }
}
