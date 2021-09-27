package com.datarest.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.datarest.entities.Employee;
import com.datarest.repository.IEmployeeRepository;

@Service
public class IEmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private IEmployeeRepository repository;

	@Override
	public Employee addEmployee(Employee emp)
	{

		return repository.save(emp);
	}

	@Override
	public void deleteEmployee(int id) 
	{

		repository.findById(id).orElseThrow(
				()-> new EntityNotFoundException("no employee found for the given id"));
		repository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee emp) 
	{

		Employee employee = repository.findById(emp.getUserId()).orElseThrow(
				() -> new EntityNotFoundException("no employee found"));
		employee.setFirstName(emp.getFirstName());
		return repository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() 
	{


		return (List<Employee>)repository.findAll();
	
	}

	@Override
	public Employee getEmployeeById(int userId) 
	{
		
		return repository.findById(userId).get();
	}

	@Override
	public List<Employee> getAllEmployeesByPagination(int maxPage, int ofset) 
	{
		
		Pageable paging = PageRequest.of(maxPage, ofset);
		Page<Employee> pageResult = repository.findAll(paging);
		return pageResult.toList();
		
	} 

	@Override
	public int getEmployeeCount() 
	{
		
		return (int) repository.count();
	}

	


}
