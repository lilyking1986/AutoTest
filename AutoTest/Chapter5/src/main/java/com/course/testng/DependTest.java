package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void test1(){
        System.out.print("this is a testcase 1!");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.print("this is a testcase 2!");
    }
}
