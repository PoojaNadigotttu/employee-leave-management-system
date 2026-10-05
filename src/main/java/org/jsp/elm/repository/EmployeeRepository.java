package org.jsp.elm.repository;

import java.util.Optional;

import org.jsp.elm.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	Optional<Employee> findById(Integer id);

	Optional<Employee> findByEmail(String email);

}
