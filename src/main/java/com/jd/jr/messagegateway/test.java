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

        // 发短信
        try {
            int appid = 1400183061; // 1400开头

            // 短信应用SDK AppKey
            String appkey = "bef23d5685829a005fea62b63e922361";

            String smsSign="193165";
            String[] phoneNumbers = {"18845896035","18845148483","15663583031","18846438638"};
            int templateId=272550;
            String[] params = {"【】"};
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
