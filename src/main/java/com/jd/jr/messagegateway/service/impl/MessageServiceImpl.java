package com.jd.jr.messagegateway.service.impl;

import com.jd.jrdp.exts.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
/**
 * @description: 短信服务实现类
 * @auther: wuqichuan@jd.com
 * @date: 2019/1/24 9:49
 * @version V1.0
 */
@Service("messageServiceImpl")
public class MessageServiceImpl implements MessageService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public Map<String, Object> execute(String s, Map<String, Object> map, String s1) {
        logger.info("模拟实现消息发送类");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result","1");
        resultMap.put("data",new HashMap());
        return resultMap;
    }
}
