package com.cg.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.furniture.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	@Query("select a from Customer as a where a.email=:email AND a.password=:password")
	public Customer loginCustomer(@Param("email") String email, @Param("password") String password);
}


