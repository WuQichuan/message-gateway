package com.jd.jr.messagegateway.service.impl;

import com.jd.jr.messagegateway.config.MailConfig;
import com.jd.jr.service.notice.IMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @description: 邮件信息服务实现类
 * @auther: wuqichuan@jd.com
 * @date: 2019/1/24 9:48
 * @version V1.0
 */
@Service("iMailServiceImpl")
public class IMailServiceImpl implements IMailService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // 获取 MimeMessage 对象。
    MimeMessage message = new MailConfig().getMessage();

    @Override
    public boolean sendHtml(String systemName, String title, String content, List<String> toMailList, List<String> CcMailList, String remark) {
        try {
            //设置收件人
            for (String toMail:toMailList) {
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            }
            //设置抄送人
            for (String ccMail:CcMailList) {
                message.setRecipient(Message.RecipientType.CC, new InternetAddress(ccMail));
            }
            // 设置标题
            message.setSubject(title);
            //设置内容，text格式
            message.setContent(content,"text/html;charset=UTF-8");
            // 发送消息
            Transport.send(message);
            logger.info("邮件发送成功："+title);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean sendText(String systemName, String title, String content, List<String> toMailList, List<String> CcMailList, String remark) {
        try {
            //设置收件人
            for (String toMail:toMailList) {
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            }
            //设置抄送人
            for (String ccMail:CcMailList) {
                message.setRecipient(Message.RecipientType.CC, new InternetAddress(ccMail));
            }
            // 设置标题
            message.setSubject(title);
            //设置内容，text格式
            message.setText(content);
            // 发送消息
            Transport.send(message);
            logger.info("邮件发送成功："+title);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

    }


}
