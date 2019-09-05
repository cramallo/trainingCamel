package com.wolox.camelproject;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Servlet;


@SpringBootApplication
public class CamelProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelProjectApplication.class, args);
	}

}
