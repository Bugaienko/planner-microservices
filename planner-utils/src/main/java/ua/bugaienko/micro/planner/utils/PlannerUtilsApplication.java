package ua.bugaienko.micro.planner.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ua.bugaienko.micro.planner"})
public class PlannerUtilsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlannerUtilsApplication.class, args);
	}

}
