package com.thingsremembered;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication 
@EnableAspectJAutoProxy
public class TRordersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TRordersApplication.class, args);
	}

}
