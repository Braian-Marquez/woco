package com.nocountry.woco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@EnableWebMvc
@SpringBootApplication
@ComponentScan(basePackages = "com.nocountry.woco.config")
public class WocoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WocoApplication.class, args);
	}

}
