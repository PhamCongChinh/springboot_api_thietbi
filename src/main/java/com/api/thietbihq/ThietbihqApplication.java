package com.api.thietbihq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // sử dụng cho EntityListeners
public class ThietbihqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThietbihqApplication.class, args);
	}

}
