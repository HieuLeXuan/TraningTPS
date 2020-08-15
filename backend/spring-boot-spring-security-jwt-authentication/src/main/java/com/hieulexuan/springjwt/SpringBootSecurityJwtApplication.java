package com.hieulexuan.springjwt;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hieulexuan.springjwt.service.ImageService;

@SpringBootApplication
public class SpringBootSecurityJwtApplication implements CommandLineRunner{

	@Resource
	ImageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.init();
	}

}
