package com.api.utils;

import org.testng.annotations.DataProvider;

public class ProviderData {
    private static String xlsPath = "E:\\IdeaProjects\\AutoTest\\Automate\\src\\main\\resources\\testCaseData.xlsx";

    @DataProvider(name = "UsersData")
    public static Object[][] createUsersData() {
        Object[][] data = null;
        try {
            data = ReaderExcel.DesignationData(xlsPath, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
