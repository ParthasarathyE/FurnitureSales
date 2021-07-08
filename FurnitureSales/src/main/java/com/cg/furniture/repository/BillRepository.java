package com.cg.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.cg.furniture.entity.Bill;
@Repository
@EnableJpaRepositories
public interface BillRepository extends JpaRepository<Bill,Integer>{

}
