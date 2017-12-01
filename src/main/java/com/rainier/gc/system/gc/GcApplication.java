package com.rainier.gc.system.gc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class GcApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GcApplication.class, args);
	}

/*	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}*/
}
