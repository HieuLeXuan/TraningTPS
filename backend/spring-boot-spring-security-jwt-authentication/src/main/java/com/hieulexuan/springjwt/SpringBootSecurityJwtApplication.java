package com.hieulexuan.springjwt;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hieulexuan.springjwt.service.FileStorageService;

@SpringBootApplication
public class SpringBootSecurityJwtApplication {

	@Resource
	FileStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

}
