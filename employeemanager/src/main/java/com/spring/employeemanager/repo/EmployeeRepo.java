package com.spring.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.employeemanager.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository <Employee ,Long> {

	void deleteById(Long id);

	Optional<Employee> findEmployeeById(Long id);

}
