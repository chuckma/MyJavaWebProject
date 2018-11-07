package com.HttpUtil;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.StringUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author Administrator
 */
public class HttpXmlClient {

    private static Logger log = Logger.getLogger(HttpXmlClient.class);

    public static String post(String url, Map<String, String> params) {
        HttpClient httpclient = HttpClientBuilder.create().build();
        String body = null;

        log.info("create httppost:" + url);
        HttpPost post = postForm(url, params);

        body = invoke(httpclient, post);

        httpclient.getConnectionManager().shutdown();
        return body;
    }

    public static String get(String url) {
        HttpClient httpclient = HttpClientBuilder.create().build();
        String body = null;

        log.info("create httppost:" + url);
        HttpGet get = new HttpGet(url);
        body = invoke(httpclient, get);

        httpclient.getConnectionManager().shutdown();

        return body;
    }


    private static String invoke(HttpClient httpclient,
                                 HttpUriRequest httpost) {

        HttpResponse response = sendRequest(httpclient, httpost);
        String body = paseResponse(response);

        return body;
    }

    private static String paseResponse(HttpResponse response) {
        log.info("get response from http server..");
        HttpEntity entity = response.getEntity();

        log.info("response status: " + response.getStatusLine());
        String charset = EntityUtils.getContentCharSet(entity);
        log.info(charset);

        String body = null;
        try {
            body = EntityUtils.toString(entity);
            log.info(body);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }

    private static HttpResponse sendRequest(HttpClient httpclient,
                                            HttpUriRequest httpost) {
        log.info("execute post...");
        HttpResponse response = null;

        try {
            response = httpclient.execute(httpost);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static HttpPost postForm(String url, Map<String, String> params){

        HttpPost httpost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList <NameValuePair>();

        Set<String> keySet = params.keySet();
        for(String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }

        try {
            log.info("set utf-8 form entity to httppost");
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return httpost;
    }



    private static String getToken(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("corpid", "wmc2694321b7d79311");  //管理帐号
        params.put("corpsecret", "yJJkPxLY-dkGXmgNFbsQYWAOHy8Ew1RNmA1djUUT4y_OxzOKybHE2XrPgXwVWQEG");  //接口key

        /**
         * 发送给请求,获取token
         */
//                String token = HttpXmlClient.post("https://exmail.qq.com/cgi-bin/token",params);
        String token = HttpXmlClient.post(" https://api.exmail.qq.com/cgi-bin/gettoken",params);
        log.info(token);

        Map fromJson = JSON.parseObject(token,Map.class);
        String access_token = (String) fromJson.get("access_token");
        log.info(access_token);
        return access_token;
    }


    public static void main(String[] args) {
        System.out.println(getToken());

    }

































































      /*public void getNewCount(HttpServletRequest request, String email, HttpServletResponse response){
        try {
            if(StringUtil.isNotEmpty(email)&&email.contains("@hsjy.com")){
                //String pyName = "";
                *//**
     * 将中文转成拼音再拼接邮箱
     *//*
                //pyName = startService.getPingYin(personName);

                *//**
     * 封装获取access_token需要的参数
     *//*
                Map<String, String> params = new HashMap<String, String>();
                params.put("client_id", "管理帐号");  //管理帐号
                params.put("grant_type", "client_credentials");  //授权类型
                params.put("client_secret", "接口KEY");  //接口key

                *//**
     * 发送给请求,获取token
     *//*
                String token = HttpXmlClient.post("https://exmail.qq.com/cgi-bin/token",params);
                log.info(token);

                *//**
     * 将返回的字符串转成Map,获取access_token
     *//*
                Map fromJson = JSON.parseObject(token,Map.class);
                String access_token = (String) fromJson.get("access_token");

                *//**
     * 封装获取未读邮件需要的参数
     *//*
                Map<String, String> params2 = new HashMap<String, String>();
                params2.put("alias", email);    //需要获取的帐号
                params2.put("access_token", access_token);    //上面获取到的access_token

                *//**
     * 发送请求,获取newcount未读邮件
     *//*
                String mail = HttpXmlClient.post("http://openapi.exmail.qq.com:12211/openapi/mail/newcount",params2);

//                Map json = JsonHelper.fromJson(mail,Map.class);
                Map json = JSON.parseObject(mail,Map.class);
                String newCount = (String) json.get("NewCount");

                log.info(newCount+"条未读邮件");

                //如果获取的未读邮件是0或者是null都设置为""页面判断不在显示
                if(newCount!=null&&!"".equals(newCount)&&!"0".equals(newCount)){
                    request.setAttribute("newcount", newCount);
                }else{
                    request.setAttribute("newcount", "");
                }
                *//**
     * 发送请求,获取AuthKey
     *//*
                String authKey = HttpXmlClient.post("http://openapi.exmail.qq.com:12211/openapi/mail/authkey",params2);
                log.info(authKey);
                //将json字符串转成Map
//                Map authKeyJson = JsonHelper.fromJson(authKey,Map.class);
                Map authKeyJson = JSON.parseObject(authKey,Map.class);
                //获取到authKeyValue
                String authKeyValue = (String) authKeyJson.get("auth_key");

                //String authKey2 = HttpXmlClient.post("https://exmail.qq.com/cgi-bin/login?fun=bizopenssologin&method=bizauth&agent=hsjyadmin&user="+pyName+"@hsjy.com"+"&ticket="+authKeyValue,params2);

                *//**
     * 设置页面腾讯企业邮箱单点登录页面需要的参数
     *//*
                request.setAttribute("pyName", email);
                request.setAttribute("authKeyValue", authKeyValue);

                *//*try {
                    PrintWriter writer = response.getWriter();
                    writer.write(authKey2);
                } catch (IOException e) {
                    e.printStackTrace();
                }*//*

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
