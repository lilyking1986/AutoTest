package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups="server")
    public void test1(){
        System.out.print("this is a testcase one!");
    }



    @Test(groups="client")
    public void test3(){
        System.out.print("this is a testcase 3!");
    }

    @Test(groups="client")
    public void test4(){
        System.out.print("this is a testcase 4!");
    }
    @BeforeGroups("server")
    public void beforeonserver(){
        System.out.print("this is a testcase befroeserver!");
    }

    @Test(groups="server")
    public void test2(){
        System.out.print("this is a testcase too!");
    }

    @AfterGroups("server")
    public void afteronserver(){
        System.out.print("this is a testcase afterserver!");
    }
}
