package com.api.utils;

import com.api.enums.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(String name){
        String address = bundle.getString("HOST");
        String url = "";
        String testUrl = "";

        if(name .equals(InterfaceName.USERS)){
            url = bundle.getString("USERSPATH");
        }
        testUrl = address + url;
        return testUrl;
    }
}
