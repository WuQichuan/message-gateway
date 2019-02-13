package com.jd.jr.messagegateway.service.impl;

import com.jd.jr.messagegateway.config.AudioMessageConfig;
import com.jd.mms.audio.jsf.request.BatchFixedTextAudioMessage;
import com.jd.mms.audio.jsf.response.BatchAudioMessageResponse;
import com.jd.mms.audio.jsf.service.AudioMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
  * @description: 语音信息服务实现类
  * @auther: wuqichuan@jd.com
  * @date: 2019/1/24 9:47
  * @version V1.0
  */
@Service("audioMessageServiceImpl")
public class AudioMessageServiceImpl implements AudioMessageService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    AudioMessageConfig audioMessageConfig;

    @Override
    public BatchAudioMessageResponse sendBatchAudioMessage(BatchFixedTextAudioMessage batchFixedTextAudioMessage) {
        logger.info("---模拟语音消息发送---");
        logger.info("当前使用--->"+audioMessageConfig.getCompany()+"公司的API");
        BatchAudioMessageResponse response = new BatchAudioMessageResponse();
        return response;
    }
}
