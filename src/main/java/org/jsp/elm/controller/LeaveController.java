package org.jsp.elm.controller;

import java.util.List;

import org.jsp.elm.dto.Leave;
import org.jsp.elm.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaveController {
	@Autowired
	private LeaveService service;
	
	@PostMapping("/saveL")
	public Leave save(@RequestBody Leave leave) {
		return service.save(leave);
	}
	//findleave by id
	@GetMapping("/findL/{id}")
	public Leave find(@PathVariable int id) {
		return service.findLeaveById(id);
	}
	
	//update leave
	@PutMapping("/updateL")
	public Leave update(@RequestBody Leave leave) {
		return service.update(leave);
		
	}
	
	//delete leave
	@DeleteMapping("/deleteL/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
	
	//find all leaves
	@GetMapping("findAll/{id}")
	public List<Leave> findByEmployeeId(@PathVariable int id){
		return service.findByEmployeeId(id);
	}
	
	//approve leave
	@PutMapping("/approveLeave/{id}")
	public Leave approveLeave(@PathVariable int id) {
		return service.approveLeave(id);
	}
	
	//reject leave
	@PutMapping("/rejectLeave/{id}")
	public Leave rejectLeave(@PathVariable int id) {
		return service.rejectLeave(id);
	}
	
	//leave validation
	@PutMapping("/leaveValidate")
	public Leave leaveValidate(@RequestBody Leave leave) {
		return service.ValidateLeave(leave);
	}
	
	//find all leaves and employess
	@GetMapping("/findAll")
	public List<Leave> findAll(){
		return service.findAll();
	}
	
	//find by status
	@GetMapping("/findByStatus/{status}")
	public List<Leave> findByStatus(@PathVariable String status) {
		return service.findByStatus(status);
	}
	
	//leave id and hr id
	@PutMapping("/approveByHR/{leaveId}/{hrId}")
	public Leave approveByHR(@PathVariable int leaveId,
	                         @PathVariable int hrId) {
	    return service.approveLeaveByHR(leaveId, hrId);
	}
	
	//reject leave by hr
	@PutMapping("/rejectByHR/{leaveId}/{hrId}")
	public Leave rejectByHR(@PathVariable int leaveId,
	                        @PathVariable int hrId) {

	    return service.rejectLeaveByHR(leaveId, hrId);
	}
	

}
