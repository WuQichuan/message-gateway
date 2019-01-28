package com.jd.jr.messagegateway;

import com.jd.jr.service.notice.IMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageGatewayApplicationTests {
	@Autowired
	IMailService mailService;

	@Test
	public void contextLoads() {
		List<String> toList = new ArrayList<>();
		toList.add("wuqichuan@jd.com");
		List<String> ccList = new ArrayList<>();
		ccList.add("yanyao11@jd.com");
		mailService.sendText("etl","mailTest","邮件系统测试",toList,ccList,"");
	}

}

