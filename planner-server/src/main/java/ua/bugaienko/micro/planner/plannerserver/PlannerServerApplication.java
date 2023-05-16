package ua.bugaienko.micro.planner.plannerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PlannerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlannerServerApplication.class, args);
	}

}
