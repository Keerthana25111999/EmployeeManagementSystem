package com.datarest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.datarest.entities.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>, PagingAndSortingRepository<Department, Integer> {
	
	
}