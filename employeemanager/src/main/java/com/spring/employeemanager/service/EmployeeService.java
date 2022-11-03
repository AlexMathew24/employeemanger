package com.spring.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.employeemanager.repo.EmployeeRepo;
import com.spring.employeemanager.exception.UserNOTFoundException;
import com.spring.employeemanager.model.Employee;
@Service
public class EmployeeService {

	private final EmployeeRepo employeeRepo;
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo )
	{
		this.employeeRepo=employeeRepo;
	}
	
	//save
	
	public Employee addEmployee(Employee employee)
	{
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	//getall
	public List<Employee> findAllEmployees()
	{
		return  employeeRepo.findAll();
	}
	
	//update
	public Employee updateEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	//get by id
	public Employee findEmployeeById(Long id)
	{
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(()->new UserNOTFoundException("user by id"+id+"was not found"));
	}
	
	//delete by id
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
	
}