package com.jd.jr.messagegateway.config;

import com.jd.mms.audio.jsf.service.AudioMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * @version V1.0
 * @Description:
 * @Auther: wuqichuan@jd.com
 * @Date: 2019/2/12 16:51
 */
@Configuration
public class AudioMessageAutoConfig {
    @Bean
    @Conditional(AudioMessageCondition.class)
    public AudioMessageConfig getAudioMessageConfig() {
        return new AudioMessageConfig();
    }

}
