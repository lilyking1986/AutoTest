package com.course.cookies.demo;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
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
        List<Cookie>  cookieList = store.getCookies();
        for(Cookie cookie:cookieList){
            String name=cookie.getName();
            String value = cookie.getValue();
            System.out.println(name+":"+value);
        }

    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void getwithCookies() throws IOException {
        String r;
        HttpGet get = new HttpGet(url+bundle.getString("getCookies1.uri"));
        DefaultHttpClient c = new DefaultHttpClient();
        c.setCookieStore(store);
        HttpResponse response = c.execute(get);

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode==200) {
            r = EntityUtils.toString(response.getEntity());
            System.out.println(statusCode + r);
        }
    }
}
