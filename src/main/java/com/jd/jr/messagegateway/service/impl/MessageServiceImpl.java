package com.jd.jr.messagegateway.service.impl;


import com.alibaba.fastjson.JSON;
import com.jd.jr.service.notice.IMailService;
import com.jd.jrdp.exts.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @description: 信息服务实现类
 * @auther: wuqichuan@jd.com
 * @date: 2019/1/24 9:49
 * @version V1.0
 */
@Service("messageServiceImpl")
public class MessageServiceImpl implements MessageService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    IMailService mailService;
    @Override
    public Map<String, Object> execute(String s, Map<String, Object> map, String s1) {
        //用于判断邮件是否发送成功
        boolean sendflag = false;

        String title =  map.get("title").toString();
        String content = map.get("content").toString();
        String receiver =map.get("receiver").toString();
        if("message.mailSender.sendHtml".equals(s)){
            List<String> receiverList = new ArrayList<>();
            receiverList.add(receiver);
            sendflag = mailService.sendHtml("", title, content, receiverList, null, "");
        }

        Map<String, Object> resultMap = new HashMap<>();
        if(sendflag){
            resultMap.put("result","1");
            resultMap.put("data",new HashMap());
            logger.info("消息发送成功");
        }else{
            resultMap.put("result","0");
            resultMap.put("data",new HashMap());
            logger.info("消息发送失败");
        }
        return resultMap;
    }
}
