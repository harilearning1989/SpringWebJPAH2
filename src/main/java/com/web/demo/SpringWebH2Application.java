package com.web.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringWebH2Application implements CommandLineRunner {

	@Value("${app.api.endPoints}")
	private String endPoint;

	public static void main(String[] args) {
		SpringApplication.run(SpringWebH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] endPoints = endPoint.split(",");
		for(int i=0;i<endPoints.length;i++){
			System.out.println("EndPoints::"+endPoints[i]);
		}
	}
}
