package com.jd.jr.messagegateway.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @version V1.0
 * @Description: 语音消息条件注入的条件匹配类
 * @Auther: wuqichuan@jd.com
 * @Date: 2019/2/12 16:32
 */
public class AudioMessageCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String type = conditionContext.getEnvironment().getProperty("AudioMessage.type");
        return "renhang-cloud".equalsIgnoreCase(type);
    }
}
