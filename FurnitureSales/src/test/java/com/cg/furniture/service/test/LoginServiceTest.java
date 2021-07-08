package com.cg.furniture.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.furniture.entity.Admin;
import com.cg.furniture.entity.Customer;
import com.cg.furniture.exception.FurnitureException;
import com.cg.furniture.repository.AdminRepository;
import com.cg.furniture.repository.CustomerRepository;
import com.cg.furniture.service.LoginService;


@SpringBootTest
public class LoginServiceTest {

	@Mock
	private AdminRepository adminRepo;
	
	@Mock
	private CustomerRepository customerRepo;
	
	
	@InjectMocks
	LoginService loginService = new LoginService();
	
	@Test
	public void loginTeacher() throws FurnitureException{
	
		Customer customer = new Customer();
		customer.setEmail("anup@gmail.com");
		customer.setPassword("Anup@123");
		
		Mockito.when(customerRepo.loginCustomer("anup@gmail.com", "Anup@123")).thenReturn(customer);
		assertThat(loginService.loginCustomer("anup@gmail.com", "Anup@123")).isEqualTo(customer);
		
	}
	
	@Test
	public void loginAdmin() throws FurnitureException{
	
		Admin admin = new Admin();
		admin.setAdminEmail("admin@gmail.com");
		admin.setPassword("Admin@123");
		
		Mockito.when(adminRepo.loginAdmin("admin@gmail.com", "Admin@123")).thenReturn(admin);
		assertThat(loginService.loginAdmin("admin@gmail.com", "Admin@123")).isEqualTo(admin);
	}
	
}
