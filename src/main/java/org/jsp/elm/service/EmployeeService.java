package org.jsp.elm.service;

import java.util.Optional;

import org.jsp.elm.dao.EmployeeDao;
import org.jsp.elm.dto.Employee;
import org.jsp.elm.exception.EmployeeAlreadyExistsException;
import org.jsp.elm.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	
	//save emp
	public Employee save(Employee employee) {
		Optional<Employee> e=dao.findById(employee.getId());
		if(e.isPresent()) {
			throw new EmployeeAlreadyExistsException("Employee already exists") ;
		}
			else {
				return dao.saveEmployee(employee);
			}
	}
	
	//find by email
	public Employee findByEmail(String email,String password) {
		Optional<Employee> e=dao.findByEmail(email);
		if(e.isPresent()) {
			Employee employee=e.get();
			if(employee.getPassword().equals(password)) {
				System.out.println("login successful");
				return employee;
			}else {
				throw new RuntimeException("invalid password");
			}
		}else {
			throw new EmployeeNotFoundException("employee not found");
		}
	}

}
