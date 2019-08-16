package com.course.cookies.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        HttpGet get = new HttpGet(url+bundle.getString("getCookies.uri"));
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse respose = client.execute(get);
        result = EntityUtils.toString(respose.getEntity());
        System.out.println(result);
        store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie:cookieList){
            String name=cookie.getName();
            String value = cookie.getValue();
            System.out.println(name+":"+value);
        }

    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPost() throws IOException {
        String r;
        DefaultHttpClient c = new DefaultHttpClient();
        HttpPost post = new HttpPost(url+bundle.getString("testpost.uri"));
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("value","20");
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        c.setCookieStore(store);
        HttpResponse response = c.execute(post);
        r = EntityUtils.toString(response.getEntity());
        System.out.println("-----"+r);

        JSONObject re = new JSONObject(r);
        String name = (String) re.get("huhansan");
        String value = (String) re.get("status");
        Assert.assertEquals("succcess",name);
        Assert.assertEquals("1",value);
    }

}
