package com.jd.jr.messagegateway;

import com.jd.jr.messagegateway.service.impl.MessageServiceImpl;
import com.jd.jr.service.notice.IMailService;
import com.jd.jrdp.exts.message.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageGatewayApplicationTests {
	@Autowired
	IMailService mailService;
	@Autowired
	MessageService messageService;

	@Test
	public void contextLoads() {

		//测试iMailServiceImpl
		List<String> toList = new ArrayList<>();
		toList.add("wuqichuan@jd.com");
		List<String> ccList = new ArrayList<>();
		ccList.add("yanyao11@jd.com");
		mailService.sendText("etl","iMailServiceImpl测试","iMailServiceImpl测试",toList,ccList,"");

		//测试messageService
		Map<String,Object> sendMap = new HashMap<String, Object>();
		sendMap.put("title","messageService测试");
		sendMap.put("content","<div>messageService测试</div>");
		sendMap.put("receiver","wuqichuan@jd.com");

		messageService.execute("message.mailSender.sendHtml",sendMap,"");
	}

}

