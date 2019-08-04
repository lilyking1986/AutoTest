package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.print("this is a testcase one!");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.print("this is a testcase beformethod!");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.print("this is a testcase beforeclass!");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.print("this is a testcase aftermethod!");
    }
    @AfterClass
    public void fterClass(){
        System.out.print("this is a testcase afterclass!");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.print("this is a testcase aftersuite!");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.print("this is a testcase aftersuite!");
    }
}
