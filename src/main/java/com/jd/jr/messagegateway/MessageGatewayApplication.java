package com.jd.jr.messagegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages ={"com.jd.jr.messagegateway"})
public class MessageGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageGatewayApplication.class, args);
	}

}

