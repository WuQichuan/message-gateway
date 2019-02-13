package com.jd.jr.messagegateway.config;

import com.jd.mms.audio.jsf.service.AudioMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * @version V1.0
 * @Description: 自动注入语音消息配置类
 * @Auther: wuqichuan@jd.com
 * @Date: 2019/2/12 16:51
 */
@Configuration
public class AudioMessageAutoConfig {
    /**
     * @description: 如果匹配AudioMessageCondition条件，就创建，并在调用时返回 AudioMessageConfig 这个配置对象
     * @param:
     * @return: com.jd.jr.messagegateway.config.AudioMessageConfig
     * @auther: wuqichuan@jd.com
     * @date: 2019/2/13 14:02
     * @version V1.0
     */
    @Bean
    @Conditional(AudioMessageCondition.class)
    public AudioMessageConfig getAudioMessageConfig() {
        return new AudioMessageConfig();
    }

}
