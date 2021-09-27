package com.datarest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.datarest.entities.Department;
import com.datarest.repository.IDepartmentRepository;

@Service
public class IDepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private IDepartmentRepository repository;
	
	@Override
	public Department addDepartment(Department dname)
	{
		
		 return repository.save(dname);
	}

	@Override
	public List<Department> getAllDepartments() 
	{
		
		return repository.findAll();
	}

	@Override
	public List<Department> getAllDepartByPagination(int maxPage, int ofset) 
	{
		
		Pageable paging = PageRequest.of(maxPage, ofset);
		Page<Department> pageResult = repository.findAll(paging);
		return pageResult.toList();
		
	} 

	@Override
	public int getAllDepartCount() 
	{
		
		return (int) repository.count();
	}

	@Override
	public boolean deleteDepartment(int id)
	{
		
		repository.deleteById(id);
		return true;
	}
}