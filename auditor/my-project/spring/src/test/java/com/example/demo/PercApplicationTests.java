package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import perc.PercentillApplication;
import perc.services.PersentillService;

import java.util.Random;


@SpringBootTest(classes = PercentillApplication.class)
class PercApplicationTests {


	@Autowired
	PersentillService persentillService;

	@Test
	void contextLoads() {

		Random gen = new Random();
		for(int i = 0; i < 100; i++) {
			persentillService.create(8, 1);
		}
		persentillService.create(8, 100);

		for(int i = 0; i < 99; i++) {
			persentillService.create(9, 1);
		}
		persentillService.create(9, 100);
		persentillService.create(9, 100);
	}



}
