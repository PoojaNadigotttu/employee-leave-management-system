package org.jsp.elm.dao;

import java.util.Optional;

import org.jsp.elm.dto.Employee;
import org.jsp.elm.repository.EmployeeRepository;
import org.jsp.elm.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepository repository;
	
	//SAVE EMP
	 public Employee saveEmployee(Employee employee) {
		 return repository.save(employee);
	 }

	 public Optional<Employee> findById(int id) {
		return repository.findById(id);
	 }
	 
	 //find by email
	 public Optional<Employee> findByEmail(String email) {
		return repository.findByEmail(email);
		 
	 }

}
