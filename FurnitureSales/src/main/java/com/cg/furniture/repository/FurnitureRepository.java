package com.cg.furniture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.furniture.entity.Furniture;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Integer>{

	@Query("select f from Furniture f where f.furnitureCategory=:name")
	public List<Furniture> findFurnitureByCategory(@Param("name") String name);
}
