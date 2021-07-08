package com.cg.furniture.service.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.furniture.exception.FurnitureException;
import com.cg.furniture.repository.BillRepository;
import com.cg.furniture.service.BillService;

@SpringBootTest
public class BillServiceTest {
	
	@InjectMocks
    BillService billService=new BillService();
	
	@Mock
	BillRepository repository;
	
	@Test
	public void testGetBillByIdThrowsException() {
		int billId=101;
		when(repository.findById(billId)).thenReturn(Optional.empty());
		assertThrows(FurnitureException.class,()->billService.generateBill(billId));
	}

}
