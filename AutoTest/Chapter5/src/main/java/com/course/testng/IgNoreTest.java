package com.course.testng;

import org.testng.annotations.Test;

public class IgNoreTest {
    @Test
    public void ignore1(){
        System.out.print("this is a testcase one!");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.print("this is a testcase two!");
    }
}
