package com.neusoft.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages={"com.neusoft.hotel.manage.mapper","com.neusoft.hotel.admin.mapper, com.neusoft.hotel.info.mapper"})
@ServletComponentScan("com.neusoft.hotel.filter")
public class HotelManagementSystem014Application {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementSystem014Application.class, args);
	}

}
