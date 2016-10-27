package com.hzm.boot.sms;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author Administrator
 */
public class SendSMS {

    private final static String POST_URL = "http://sms.106jiekou.com/utf8/openapi.aspx";
    private final static String ACCOUNT = "xiaoqian";
    private final static String PASSWORD = "123456abc";


    public static String sendSMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
    /*
    public static void main(String[] args) {
        String PostData = null;
        String mobile = "15818594258,15818701131,18665869521";
        String content = "春节马上到了，韶通公司在此佳节祝各位员工节日快乐。";
        try {
            PostData = "account=xiaoqian&password=123456abc&mobile="+mobile+"&content="+ URLEncoder.encode(content,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String ret = sendSMS(PostData, "http://sms.106jiekou.com/utf8/openapi.aspx");
        System.out.println(Result.getName(ret.replace("\\n","")));
    }*/

    public enum Result {

        SUCCESS("发送成功", "100"),
        FAILURE("验证失败", "101"),
        MOBILE_ERROR("手机号码格式不正确", "102"),
        CONTENT_VALIDE("内容未审核", "104"),
        BALANCE("账户余额不足", "106");

        // 成员变量
        private String name;
        private String value;

        // 构造方法
        private Result(String name, String value) {
            this.name = name;
            this.value = value;
        }

        // 普通方法
        public static String getName(String value) {
            for (Result c : Result.values()) {
                if (c.getValue().equals(value)) {
                    return c.name;
                }
            }
            return null;
        }

        // get set 方法
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
