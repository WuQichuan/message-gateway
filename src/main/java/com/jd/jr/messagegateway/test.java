package com.jd.jr.messagegateway;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.jd.jr.messagegateway.config.MessageConfig;
import org.json.JSONException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

/**
 * @version V1.0
 * @Description:
 * @Auther: wuqichuan@jd.com
 * @Date: 2019/1/24 15:41
 */
public class test extends Authenticator {
    public static void main(String[] args){
/*
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", "smtp.163.com");
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.user","wuqichuan199739@163.com");
        properties.setProperty("mail.password","wuqichuan199739");
        // 获取默认的 Session 对象。
        Session session = Session.getInstance(properties,new test());
        // 创建默认的 MimeMessage 对象。
        MimeMessage message = new MimeMessage(session);

        try {
            //设置发件人
            message.setFrom(new InternetAddress("wuqichuan199739@163.com"));
            //设置收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("wuqichuan@jd.com"));
            // 设置标题
            message.setSubject("邮件发送测试");
            //设置内容，text格式
            message.setContent("hah1111111111hahha","text/html;charset=UTF-8");


            Transport transport = session.getTransport();//根据session获得邮件传输对象
            transport.connect("wuqichuan199739@163.com", "wuqichuan199739");
            // 发送消息
            transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }*/
        // 发短信
        try {
            int appid = 1400124484; // 1400开头

            // 短信应用SDK AppKey
            String appkey = "7ea6afa253b363ef87891e5646761322";

            String smsSign="162031";
            String[] phoneNumbers = {"15663583031"};
            int templateId=173625;
            String[] params = {"5678"};
            SmsMultiSender msender = new SmsMultiSender(appid, appkey);
            SmsMultiSenderResult result =  msender.sendWithParam("86", phoneNumbers, templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.print(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }






    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        String username = "wuqichuan199739@163.com";
        String pa = "wuqichuan199739";
        if(username != null && username.length()>0 && pa != null && pa.length()>0){
            return new PasswordAuthentication(username, pa);
        }
        return null;
    }

}
