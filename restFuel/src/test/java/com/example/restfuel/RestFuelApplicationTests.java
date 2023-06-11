package com.example.restfuel;

import com.example.restfuel.model.Refuelling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestFuelApplicationTests {

	//Refuelling refuel = new Refuelling(1, 500, 1000, 30);
	Refuelling refuel1 = new Refuelling(1, 0, 1000, 55.0);
	Refuelling refuel2 = new Refuelling(2, 1000, 1987, 52.0);
	Refuelling refuel3 = new Refuelling(3, 1987, 2050, 57);



	@Test
	void contextLoads() {
	}

	@Test
	void testGetFuelConsumption () {
		Assertions.assertEquals(5.5,refuel1.getFuelConsumption());
		Assertions.assertEquals(5.268490374873354,refuel2.getFuelConsumption());
		Assertions.assertEquals(90.47619047619048,refuel3.getFuelConsumption());
	}

}
