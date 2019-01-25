package com.jd.jr.messagegateway.config;

import com.github.qcloudsms.SmsSingleSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Description: 手机短信配置类
 * @Auther: wuqichuan@jd.com
 * @Date: 2019/1/24 17:54
 */
@Component
public class MessageConfig {

    @Value("${message.appid}")
    private int appid; // 1400开头

    // 短信应用SDK AppKey
    @Value("${message.appkey}")
    private String appkey;

    // 需要发送短信的手机号码
    private String phoneNumbers = "15663583031";

    private SmsSingleSender ssender = new SmsSingleSender(appid, appkey);

    public int getAppid() {
        return appid;
    }

    public String getAppkey() {
        return appkey;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public SmsSingleSender getSsender() {
        return ssender;
    }
}
