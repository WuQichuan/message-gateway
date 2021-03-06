package com.jd.jr.messagegateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @version V1.0
 * @Description: 邮件设置类
 * @Auther: wuqichuan@jd.com
 * @Date: 2019/1/24 16:14
 */
@Component
public class MailConfig extends Authenticator {
    /*
     * 目前采用wuqichuan199739@163.com作为发件邮箱进行测试
     * 部署测试请更改邮箱配置
     */
    @Value("${mail.smtp.host}")
    private String host;

    @Value("${mail.transport.protocol}")
    private String protocol;

    @Value("${mail.smtp.auth}")
    private String auth;

    @Value("${mail.user}")
    private String user;

    @Value("${mail.password}")
    private String password;

    /**
     * @description: 获取一个message对象
     * @param: []
     * @return: javax.mail.internet.MimeMessage
     * @auther: wuqichuan@jd.com
     * @date: 2019/1/29 13:46
     * @version V1.0
     */
    public MimeMessage getMessage() {
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.transport.protocol",protocol);
        properties.setProperty("mail.smtp.auth",auth);
        properties.setProperty("mail.user",user);
        properties.setProperty("mail.password",password);
        // 获取默认的 Session 对象。
        Session session = Session.getInstance(properties,this);
        // 创建默认的 MimeMessage 对象。
        MimeMessage message = new MimeMessage(session);

        //设置发件人
        try {
            message.setFrom(new InternetAddress(user));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        if(user != null && user.length()>0 && password != null && password.length()>0){
            return new PasswordAuthentication(user, password);
        }
        return null;
    }



}
