package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
@Test(groups="stu")
public class GroupsOnClass2 {


    public void test2(){
        System.out.print("this is a testcase 2!");
    }

}
