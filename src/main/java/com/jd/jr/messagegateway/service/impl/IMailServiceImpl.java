package com.jd.jr.messagegateway.service.impl;

import com.jd.jr.service.notice.IMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * @description: 邮件信息服务实现类
 * @auther: wuqichuan@jd.com
 * @date: 2019/1/24 9:48
 * @version V1.0
 */
@Service("iMailServiceImpl")
public class IMailServiceImpl implements IMailService {

    private Logger logger = LoggerFactory.getLogger(getClass());
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
    @Override
    public boolean sendHtml(String systemName, String title, String content, List<String> toMailList, List<String> CcMailList, String remark) {
        logger.info("模拟邮件发送："+title);
        return true;
    }

    @Override
    public boolean sendText(String systemName, String title, String content, List<String> toMailList, List<String> CcMailList, String remark) {
        logger.info("模拟邮件发送："+title);
        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.transport.protocol",protocol);
        properties.setProperty("mail.smtp.auth",auth);
        properties.setProperty("mail.user",user);
        properties.setProperty("mail.password",password);
        // 获取默认的 Session 对象。
        Session session = Session.getDefaultInstance(properties);

        // 创建默认的 MimeMessage 对象。
        MimeMessage message = new MimeMessage(session);



        return true;
    }
}
