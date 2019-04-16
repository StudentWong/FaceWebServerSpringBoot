package com.graduationproject.facewebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScan({"controller"})
@SpringBootApplication
public class FacewebserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacewebserverApplication.class, args);
	}

}
