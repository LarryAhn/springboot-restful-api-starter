package com.zuperztarahn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
@PropertySource(value = "classpath:/config/application.yml")
public class Application extends SpringBootServletInitializer {

	@Value("${enviroment}")
	private String env;

	@PostConstruct
	public void postConstruct() {
		System.out.println("Application started profile : " + env);
	}

	// TODO 아래 index()는 env 별 확인 용으로 없어져야 할 것. @RestController 애노테이션 또한 없어져야할 것!
	@GetMapping
	public String index() {
		return env;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
