package com.enjoytrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.experimental.Accessors;

@SpringBootApplication
@MapperScan(basePackages = {"com.enjoytrip.dao"})
public class EnjoyTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnjoyTripApplication.class, args);
	}

}
