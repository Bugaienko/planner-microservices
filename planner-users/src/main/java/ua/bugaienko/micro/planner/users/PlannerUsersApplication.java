package ua.bugaienko.micro.planner.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlannerUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlannerUsersApplication.class, args);
	}

}
