package com.api.test;

import com.alibaba.fastjson.JSON;
import com.api.enums.ResponseCode;
import com.api.model.User;
import com.api.restclient.RestClient;
import com.api.utils.ConfigFile;
import com.api.utils.ProviderData;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class UsersTest {
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;
    HashMap<String,String> postHeader;

    @BeforeClass
    public void setUp(){
        restClient = new RestClient();
        postHeader = new HashMap<String, String>();
        postHeader.put("Content-Type","application/json");
    }

    @Test(dataProvider ="UsersData",dataProviderClass = ProviderData.class)
    public void login(String interfaceName,String name,String job) throws IOException {
        User userInfo = new User(name,job);
        String userJson = JSON.toJSONString(userInfo);
        System.out.println(ConfigFile.getUrl(interfaceName));
        closeableHttpResponse = restClient.post(ConfigFile.getUrl(interfaceName), userJson, postHeader);
        int code = restClient.getStatusCode(closeableHttpResponse);

        Assert.assertEquals(ResponseCode.RESPONSE_STATUS_CODE_200, code);
		Reporter.log("状态码：" + code);
		Reporter.log("URL:" + ConfigFile.getUrl(interfaceName));
    }

    @BeforeClass
    public void endTest() {
        System.out.print("测试结束");
    }
}
