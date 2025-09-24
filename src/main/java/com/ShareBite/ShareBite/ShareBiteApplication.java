package com.ShareBite.ShareBite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class ShareBiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareBiteApplication.class, args);
	}

}
