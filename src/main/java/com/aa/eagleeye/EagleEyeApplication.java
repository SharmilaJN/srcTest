/*
 * Copyright (c) 2021 American Airlines
 * 
 * @author Sahil Batra
 * @version 1.0
 * @since 1.0
 * 
 */
package com.aa.eagleeye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EagleEyeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EagleEyeApplication.class, args);
	}

}
