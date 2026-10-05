package org.jsp.elm.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.elm.dto.Leave;
import org.jsp.elm.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LeaveDao {
	@Autowired
	private LeaveRepository repository;
	
	//save leave
	public Leave save(Leave leave) {
		return repository.save(leave);
	}

	//find
	public Optional<Leave> findById(int id) {
        return repository.findById(id);
    }
	
	//update  leave
	public Leave update(Leave leave) {
		return repository.save(leave);
	}
	
	//delete leave
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	//find all leaves
	public List<Leave> findByEmployeeId(int id){
		return repository.findByEmployee_Id(id);
	}
	
	//find all leaves of all employess
	public List<Leave> findAll() {
		return repository.findAll();
	}
	
	//find by status
	public List<Leave> findByStatus(String status){
		return repository.findByStatus(status);
		
	}
	
	
	

	
}
