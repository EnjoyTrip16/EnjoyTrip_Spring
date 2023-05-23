package com.enjoytrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.enjoytrip.dao"})
public class EnjoyTrip1Application {

	public static void main(String[] args) {
		SpringApplication.run(EnjoyTrip1Application.class, args);
	}

}
