package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.print("this is a testcase obefresuite!");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.print("this is a testcase afterSuite!");
    }
}
