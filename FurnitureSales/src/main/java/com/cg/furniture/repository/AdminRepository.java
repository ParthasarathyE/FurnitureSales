package com.cg.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.furniture.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("select a from Admin as a where a.adminEmail=:adminEmail AND a.password=:password")
	public Admin loginAdmin(@Param("adminEmail") String adminEmail, @Param("password") String password);
}
