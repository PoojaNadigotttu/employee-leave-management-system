package org.jsp.elm.controller;

import org.jsp.elm.dto.Employee;
import org.jsp.elm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	//save emp
	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		return service.save(employee);
	}
	
	//find by email
	@GetMapping("/login/{email}/{password}")
	public Employee login(@PathVariable String email,@PathVariable String password) {
		return service.findByEmail(email, password);
	}

}
