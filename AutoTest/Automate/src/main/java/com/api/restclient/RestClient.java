package com.api.restclient;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.mongodb.util.JSON;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    /**
     * lily
     * @param url
     * @return
     * @throws IOException
     */
    public CloseableHttpResponse get(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        return httpResponse;
    }

    /**
     * lily
     * @param url
     * @param headsmap
     * @param <K>
     * @return
     * @throws IOException
     */
    public <K> CloseableHttpResponse get(String url, HashMap<String,String> headsmap) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);

        for(Map.Entry<String,String> entry:headsmap.entrySet()){
            httpget.addHeader(entry.getKey(),entry.getValue());
        }

        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        return httpResponse;
    }

    /**
     * lily
     * @param url
     * @param entryString
     * @param headsmap
     * @return
     * @throws IOException
     */
    public CloseableHttpResponse post(String url,String entryString,HashMap<String,String> headsmap) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);

        httppost.setEntity(new StringEntity(entryString));

        for (Map.Entry<String,String> entry:headsmap.entrySet()){
            httppost.addHeader(entry.getKey(),entry.getValue());
        }

        CloseableHttpResponse httpResponse = httpclient.execute(httppost);
        return httpResponse;
    }

    /**
     * lily
     * @param url
     * @param entryString
     * @param headsmap
     * @return
     * @throws IOException
     */
    public CloseableHttpResponse put(String url,String entryString,HashMap<String,String> headsmap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPut httpput = new HttpPut(url);

        httpput.setEntity(new StringEntity(entryString));

        for(Map.Entry<String,String> entry:headsmap.entrySet()){
            httpput.addHeader(entry.getKey(),entry.getValue());
        }

        CloseableHttpResponse httpResponse = httpClient.execute(httpput);
        return httpResponse;
    }

    /**
     * lily
     * @param url
     * @return
     * @throws IOException
     */
    public CloseableHttpResponse delete(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpDelete delete = new HttpDelete(url);
        CloseableHttpResponse httpResponse = httpclient.execute(delete);
        return httpResponse;
    }

    /**
     * lily
     * @param response
     * @return
     */
    public int getStatusCode(CloseableHttpResponse response){
        int statusCode = response.getStatusLine().getStatusCode();
        return statusCode;
    }

    /**
     * lily
     * @param response
     * @return
     * @throws IOException
     */
    public JSONObject getResponseJson(CloseableHttpResponse response) throws IOException {
        String responseString = EntityUtils.toString(response.getEntity());
        JSONObject responseJson = (JSONObject) JSON.parse(responseString);
        return responseJson;
    }
}
