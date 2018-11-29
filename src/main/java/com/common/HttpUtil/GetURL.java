package com.common.HttpUtil;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class GetURL {
    private static Logger log = Logger.getLogger(HttpXmlClient.class);


    public static void main(String[] args) {
//        getToken();
//        getLoginUrl();

//        Map<String, String> map = new HashMap<>();
//        map.put("1","111111111111");
//        map.put("2","222222222222");
//        boolean isContains = map.containsKey("3");

        String  str = "   lucasmavip@gmail.com   ";
        System.out.println(str.trim()+"12312");

        String s2 = "";
        String s1 = StringUtils.trimToEmpty(s2);
        System.out.println(s1);
        System.out.println(StringUtils.isNotBlank(s1));
        boolean is = s1.length()>0 && StringUtils.isNotBlank(s1);
        System.out.println(is);
    }

    private static String  getToken() {
        Map<String, Object> params = new HashMap<>();
        params.put("corpid", "wmc2694321b7d79311");
        params.put("corpsecret", "yJJkPxLY-dkGXmgNFbsQYWAOHy8Ew1RNmA1djUUT4y_OxzOKybHE2XrPgXwVWQEG");

        String token = HttpUtil.get(" https://api.exmail.qq.com/cgi-bin/gettoken",params);
        log.info(token);

        Map fromJson = JSON.parseObject(token,Map.class);
        String access_token = (String) fromJson.get("access_token");
        log.info(access_token);
        return access_token;
    }

    // WWHH95MrL7RvtrgsOPFwjDbVF-smmzXK1iaBw2YLcFLkiF4j-28LOodHBPn85-JSh8yQwAC0F-DRCW74dO-N9Q
    private static String getLoginUrl(){

        Map<String, Object> params = new HashMap<>();
        params.put("access_token", "WWHH95MrL7RvtrgsOPFwjDbVF-smmzXK1iaBw2YLcFLkiF4j-28LOodHBPn85-JSh8yQwAC0F-DRCW74dO-N9Q");
        params.put("userid", "linmx@zjmuseum.cn");

        String loginUrlJson = HttpUtil.get(" https://api.exmail.qq.com/cgi-bin/service/get_login_url",params);
        log.info(loginUrlJson);
// https://exmail.qq.com/cgi-bin/login?fun=bizopenssologin&method=openapi&userid=linmx@zjmuseum.cn&authkey=8D45295766F6F40DC1DD146DF7D1A26A1A04BBECD0F642CDE78B57EC87D9B0F675F0AB9E72AB95FC0F77A27A6CAE3A32
        Map fromJson = JSON.parseObject(loginUrlJson,Map.class);
        String login_url = (String) fromJson.get("login_url");
        // login_url 有效期 300 秒
        log.info(login_url);
        return login_url;

    }
}
