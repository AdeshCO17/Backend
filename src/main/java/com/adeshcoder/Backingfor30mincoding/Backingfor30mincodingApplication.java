package com.adeshcoder.Backingfor30mincoding;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Backingfor30mincodingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Backingfor30mincodingApplication.class, args);
	}


	@Bean // this bean use to create object where we use through this Autowired
	public ModelMapper modelMapper() {

		return new ModelMapper();


	}

}
