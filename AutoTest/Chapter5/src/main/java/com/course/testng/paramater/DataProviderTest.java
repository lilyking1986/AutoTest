package com.course.testng.paramater;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @Test(dataProvider ="data" )
    public void testDataProvider(String name,int age){
        System.out.print("name="+name+",age="+age);
    }
    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhangsan",19},
                {"zhangsan1",29},
                {"zhangsan2",39}
        };
        return o;
    }
}
