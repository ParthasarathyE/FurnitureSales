package com.cg.furniture.service.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.furniture.entity.Furniture;
import com.cg.furniture.exception.FurnitureException;
import com.cg.furniture.repository.FurnitureRepository;
import com.cg.furniture.service.FurnitureService;


@SpringBootTest
public class FurnitureServiceTest {

	@Mock
	FurnitureRepository furnitureRepository;

	@InjectMocks
	FurnitureService furnitureService = new FurnitureService();
	

	@Test
	public void testRemovefurnitureById() throws FurnitureException{

		Furniture furnitureEntity = new Furniture();
		int furnitureId=101;
		String furnitureName = "chair";
		furnitureEntity.setFurnitureId(furnitureId);
		furnitureEntity.setFurnitureName(furnitureName);

		Furniture expected  = new Furniture();
		expected.setFurnitureId(furnitureEntity.getFurnitureId());
		expected.setFurnitureName(furnitureEntity.getFurnitureName());
		when(furnitureRepository.findById(furnitureId)).thenReturn(Optional.of(furnitureEntity));
		assertEquals(furnitureService.removeFurniture(furnitureId),"Furniture deleted successfully.");
	}
	
	@Test
	void testviewAllFurnitureByCategory() {
		List<Furniture> list=furnitureRepository.findFurnitureByCategory("chair");
		assertNotNull(list);
	}
	
}