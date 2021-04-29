package com.hhz.demo;

import com.alibaba.fastjson.JSON;
import com.hhz.demo.util.ApiSecurityExample;
import com.tuya.basic.client.util.http.TuyaHttpClient;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * <p class="detail">
 * 功能:
 * </p>
 *
 * @author duye.huang
 * @ClassName Ty dev plamt.
 * @since 2021 -04-23 14:26:38
 */
public class TYDevPlamt {
    TuyaHttpClient tuyaHttpClient;
    String token;
    Long t;
    List<Header> headerList;
    String clientId;
    String secret;

    @Before
    public void init() {
        t = System.currentTimeMillis();

        clientId = "";
        secret = "";

        tuyaHttpClient = new TuyaHttpClient(1000, 1, 1);
        token = getToken();


        String tokenSign = ApiSecurityExample.getTokenSign(clientId, t, token, secret);

        headerList = new LinkedList<>();
        headerList.add(new BasicHeader("client_id", clientId));
        headerList.add(new BasicHeader("sign", tokenSign));
        headerList.add(new BasicHeader("sign_method", "HMAC-SHA256"));
        headerList.add(new BasicHeader("t", t + ""));
        headerList.add(new BasicHeader("access_token", token));
    }

    public String getToken() {

        String tokenSign = ApiSecurityExample.getTokenSign(clientId, t, null, secret);

        List<Header> headerList = new LinkedList<>();
        headerList.add(new BasicHeader("client_id", clientId));
        headerList.add(new BasicHeader("sign", tokenSign));
        headerList.add(new BasicHeader("sign_method", "HMAC-SHA256"));
        headerList.add(new BasicHeader("t", t + ""));

        List<NameValuePair> params = new LinkedList<>();
        params.add(new BasicNameValuePair("grant_type", 1 + ""));
        String s = tuyaHttpClient.doGet("https://openapi-cn.wgine.com/v1.0/token", params, headerList, Charset.defaultCharset(), null);

        System.out.println(s);
        return JSON.parseObject(s).getJSONObject("result").getString("access_token");
    }

    @Test
    public void userReg() {
        List<NameValuePair> params = new LinkedList<>();
        params.add(new BasicNameValuePair("country_code", "86"));
        params.add(new BasicNameValuePair("username", "hhz0508"));
        params.add(new BasicNameValuePair("password", "827ccb0eea8a706c4c34a16891f84e7b"));
        params.add(new BasicNameValuePair("username_type", "3"));

        Map<String, Object> map = new HashMap<>();
        map.put("country_code", "86");
        map.put("username", "hhz0508");
        map.put("password", "827ccb0eea8a706c4c34a16891f84e7b");
        map.put("username_type", 3);
        Map<String, String> stringStringMap = tuyaHttpClient
                .doPostV2("https://openapi-cn.wgine.com/v1.0/apps/streetlamp/user", null, JSON.toJSONString(map), headerList,
                        Charset.defaultCharset(), null);
        System.out.println(1);
    }

    @Test
    public void addToAuthSpace() {

        Map<String, String> stringStringMap = tuyaHttpClient
                .doPostV2("https://openapi-cn.wgine.com/v1.0/iot-02/third/spaces/persons/ay1619178646434xWjiR", null, null, headerList,
                        Charset.defaultCharset(), null);
        System.out.println(1);
    }

    @Test
    public void getDeviceById() {
        String s = tuyaHttpClient.doGet("https://openapi-cn.wgine.com/v1.0/iot-02/third/devices/6c4b5473130dfdbb63hi2a", headerList,
                Charset.defaultCharset());

        System.out.println(1);
    }

    @Test
    public void getSnInfo() {
        String s = tuyaHttpClient
                .doGet("https://openapi-cn.wgine.com/v1.0/iot-02/third/cmds/1386213856275071001", headerList, Charset.defaultCharset());

        System.out.println(1);
    }


    @Test
    public void adjustExhaustAir() {
//        String deviceId="6c4b5473130dfdbb63hi2a";
//        String personId="ay1619178646434xWjiR";

        String deviceId = "6cec0c04cfcced83a2abaq";
        String personId = "bay1583286494106g2Ei";
        Map<String, Object> map = new HashMap<>();
        map.put("value", 1.10);
        Map<String, String> stringStringMap = tuyaHttpClient
                .doPostV2("https://openapi-cn.wgine.com/v1.0/iot-02/third/buildings/" + deviceId + "/persons/" + personId +
                        "/adjust/exhaust-air", null, JSON.toJSONString(map), headerList, Charset.defaultCharset(), null);


        System.out.println(1);
    }


    @Test
    public void getEfos() {
        String s = tuyaHttpClient.doGet("https://openapi-cn.wgine.com/v1.0/iot-02/third/buildings/eegrid/device/param", headerList,
                Charset.defaultCharset());

        System.out.println(1);
    }

    @Test
    public void aaa() {
        System.out.println(1);
    }
}




