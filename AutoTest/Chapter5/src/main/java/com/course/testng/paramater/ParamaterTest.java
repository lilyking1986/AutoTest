package com.course.testng.paramater;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamaterTest {
    @Test
    @Parameters({"name","age"})
    public void paramTest1(String name, int age){
        System.out.print("name="+name+",age="+age);
    }
}
