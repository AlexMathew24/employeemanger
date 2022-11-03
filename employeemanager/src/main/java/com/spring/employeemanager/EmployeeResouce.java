package com.spring.employeemanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employeemanager.model.Employee;
import com.spring.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResouce {

	
	private EmployeeService employeeService;
	
	@Autowired
	public void EmployeeResource( EmployeeService employeeService) {
		this.employeeService= employeeService;
	}
	@GetMapping("/all")
	public ResponseEntity <List<Employee>> getAllEmployee(){
		List<Employee> employee =employeeService.findAllEmployees();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity <Employee> getEmployeeById(@PathVariable("id")Long id){
		Employee employee =employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
		
	}
		@PostMapping("/add")
		public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
			
			Employee newEmployee =employeeService.addEmployee(employee);
			return new ResponseEntity<>(employee,HttpStatus.CREATED);
		}
		
		@PutMapping("/update")
		public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
			
			Employee updateEmployee =employeeService.addEmployee(employee);
			return new ResponseEntity<>(updateEmployee,HttpStatus.CREATED);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?>deleteEmployee(@PathVariable("id")Long id){
			employeeService.deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}


