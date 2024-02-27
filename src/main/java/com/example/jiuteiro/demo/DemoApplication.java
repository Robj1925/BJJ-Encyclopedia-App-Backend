package com.example.jiuteiro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Checking ");
		for(String arg:args) {
			System.out.println(arg);
		}

		SpringApplication.run(DemoApplication.class, args);
	}

}
