package com.tester.extender.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("qq","qq");
    }
    @Test
    public void logDemo(){
        Reporter.log("this is a loginfo");
        throw new RuntimeException("this is a throw exception");
    }
}
