package br.com.csvparser;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ApplicationBoot{

	public static void main(String[] args) {
		new SpringApplicationBuilder(ApplicationBoot.class)
        .web(WebApplicationType.NONE) 
        .run(args);
	}
}
