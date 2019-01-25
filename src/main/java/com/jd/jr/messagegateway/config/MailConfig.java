package com.jd.jr.messagegateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
        Session session = Session.getInstance(properties,new MailConfig());
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
