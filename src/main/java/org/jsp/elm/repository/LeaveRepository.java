package org.jsp.elm.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.elm.dto.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave,Integer> {

	Optional<Leave> findById(Integer id);
	
//	Optional<Leave> deleteById(Integer id);
	List<Leave> findByEmployee_Id(int id);
	
	List<Leave> findByStatus(String status);
	
}
