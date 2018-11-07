package com.HttpUtil;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.net.URI;
import java.util.*;

public class HttpUtils {


   public static String get(String url) throws ClientProtocolException, IOException {
        //首先需要先创建一个DefaultHttpClient的实例
        HttpClient httpClient = new DefaultHttpClient();
        //先创建一个HttpGet对象,传入目标的网络地址,然后调用HttpClient的execute()方法即可:
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(URI.create(url));
        HttpResponse response = httpClient.execute(httpGet);
        String httpEntityContent = getHttpEntityContent(response);
        httpGet.abort();
        return httpEntityContent;
    }

    public static String get(String url, Map<String, String> paramMap) throws ClientProtocolException, IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet();
        List<NameValuePair> formparams = setHttpParams(paramMap);
        String param = URLEncodedUtils.format(formparams, "UTF-8");
        httpGet.setURI(URI.create(url + "?" + param));
        HttpResponse response = httpClient.execute(httpGet);
        String httpEntityContent = getHttpEntityContent(response);
        httpGet.abort();
        return httpEntityContent;
    }

    /**
     * 设置请求参数
     *
     * @param
     * @return
     */
    private static List<NameValuePair> setHttpParams(Map<String, String> paramMap) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> set = paramMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return formparams;
    }

    private static String getHttpEntityContent(HttpResponse response) throws IOException, UnsupportedEncodingException {
        //通过HttpResponse 的getEntity()方法获取返回信息
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream is = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line + "\n");
                line = br.readLine();
            }
            br.close();
            is.close();
            return sb.toString();
        }
        return "";
    }

    public static void main(String[] args) throws IOException {

//        String corpid = "wmc2694321b7d79311";
//        String corpsecret = "yJJkPxLY-dkGXmgNFbsQYWAOHy8Ew1RNmA1djUUT4y_OxzOKybHE2XrPgXwVWQEG";
//        Map<String, Object > map = new HashMap<String, Object>();
//        map.put("corpid", corpid);
//        map.put("corpsecret",corpsecret);
//
//        String token = HttpUtil.get("https://api.exmail.qq.com/cgi-bin/gettoken", map);
//        Map tokenMap = JSON.parseObject(token, Map.class);
//        System.out.println(tokenMap.get("access_token"));

        String access_token = "qR1YkaPi9da9Q5C2xZWX_6zYaw3Htxxz0N1bLWHqX1XcjMJga6M-1p0bAWWzeI4qA4-I6ZxmfnLEpnALouZW3A";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", access_token);
        map.put("userid", "linmx@zjmuseum.cn");

        String urljson = HttpUtil.get(" https://api.exmail.qq.com/cgi-bin/service/get_login_url?", map);

        Map res = JSON.parseObject(urljson);
        System.out.println(res.get("login_url"));


    }

}
