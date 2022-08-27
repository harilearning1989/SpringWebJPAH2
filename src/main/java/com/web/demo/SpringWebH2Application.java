package com.web.demo;

import com.web.demo.model.ThemeParkRide;
import com.web.demo.repos.ThemeParkRideRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

	@Bean
	public CommandLineRunner sampleData(ThemeParkRideRepository repository) {
		return (args) -> {
			repository.save(new ThemeParkRide("Rollercoaster", "Train ride that speeds you along.", 5, 3));
			repository.save(new ThemeParkRide("Log flume", "Boat ride with plenty of splashes.", 3, 2));
			repository.save(new ThemeParkRide("Teacups", "Spinning ride in a giant tea-cup.", 2, 4));
		};
	}
}
