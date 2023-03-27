package com.sp.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sp.inventoryservice.model.Inventory;
import com.sp.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){

		return (args) -> {
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("123");
			inventory1.setQuantity(10);
			
			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("456");
			inventory2.setQuantity(20);
			
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}
}
