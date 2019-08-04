package com.course.testng;

import org.testng.annotations.Test;

public class ExceptionTest {
    @Test(expectedExceptions = RuntimeException.class)
    public void ruTimeException(){
        System.out.print("this is a testcase 1!");
        throw new RuntimeException();
    }
}
