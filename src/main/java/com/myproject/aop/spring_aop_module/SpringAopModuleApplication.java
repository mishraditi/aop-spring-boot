package com.myproject.aop.spring_aop_module;

import com.myproject.aop.spring_aop_module.business.BusinessService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringAopModuleApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private BusinessService businessService;

	public SpringAopModuleApplication(BusinessService businessService1) {
		this.businessService = businessService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAopModuleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Value returned is {}", businessService.calculateMax());
	}

}
