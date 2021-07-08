package com.cg.furniture.service.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.furniture.entity.Customer;
import com.cg.furniture.repository.CustomerRepository;
import com.cg.furniture.service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {
	@Mock
	private CustomerRepository customerRepo;

	@InjectMocks
	CustomerService customerService = new CustomerService();


	@Test
	public void testRegisterCustomer() {
		Customer customer=new Customer();
		customer.setCustomerId(5);
		customer.setFirstName("Smita");
		customer.setLastName("Mhatre");
		customer.setPassword("Smita@1234");
		customer.setEmail("smita@gmail.com");
		customer.setContactNo("9001244679");
		customer.setPinCode(713302);
		customer.setAddress("Mumbai");
		
		Mockito.when(customerRepo.save(customer)).thenReturn(customer);
		assertThat(customerService.registerCustomer(customer)).isEqualTo("customer Registered successfully");
	}	

}


