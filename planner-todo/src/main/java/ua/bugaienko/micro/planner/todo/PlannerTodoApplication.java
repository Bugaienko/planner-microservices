package ua.bugaienko.micro.planner.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"ua.bugaienko.micro.planner"})
@EnableJpaRepositories(basePackages = {"ua.bugaienko.micro.planner.todo"})
public class PlannerTodoApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlannerTodoApplication.class, args);
	}

}
