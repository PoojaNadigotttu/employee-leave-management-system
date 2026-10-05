package org.jsp.elm.service;

import java.util.List;
import java.util.Optional;

import org.jsp.elm.dao.EmployeeDao;
import org.jsp.elm.dao.LeaveDao;
import org.jsp.elm.dto.Employee;
import org.jsp.elm.dto.Leave;
import org.jsp.elm.exception.EmployeeNotFoundException;
import org.jsp.elm.exception.LeaveAlreadyExistsException;
import org.jsp.elm.exception.LeaveNotExistsException;
//import org.jsp.elm.dto.LeaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {
	@Autowired
	private LeaveDao leaveDao;
	@Autowired
	private EmployeeDao employeeDao;
	
	//save leave
	public Leave save(Leave leave) {
	    Optional<Employee> e = employeeDao.findById(leave.getEmployee().getId());
	    if (e.isPresent()) {
	        leave.setEmployee(e.get());
	        return leaveDao.save(leave);
	    } else {
	        throw new EmployeeNotFoundException("Employee not found");
	    }
	}
	
	//find leave
	public Leave findLeaveById(int id) {
		Optional<Leave> l=leaveDao.findById(id);
		if(l.isPresent()){
			return l.get();
		}else {
			throw new LeaveNotExistsException();
		}
	}
	
	//update leave
	public Leave update(Leave leave) {
		Optional<Leave> l=leaveDao.findById(leave.getId());
		if(l.isPresent()) {
			return leaveDao.update(leave);
		}else {
			throw new LeaveNotExistsException();
		}
	}
	
	//dlete leave
	public void delete(int id) {
		Optional<Leave> l=leaveDao.findById(id);
		if(l.isPresent()) {
			leaveDao.delete(id);
		}else {
			throw new LeaveNotExistsException();
		}
	}
	
	//find all leaves
	public List<Leave> findByEmployeeId(int id){
		return leaveDao.findByEmployeeId(id);
	}
	
	//leave approval
	public Leave approveLeave(int id) {
	    Optional<Leave> l = leaveDao.findById(id);
	    if (l.isPresent()) {
	        Leave leave = l.get();
	        // Check whether leave is still pending
	        if (leave.getStatus().equals("PENDING")) {
	            Employee employee = leave.getEmployee();
	            int days = leave.getToDate().getDayOfMonth()- leave.getFromDate().getDayOfMonth() + 1;
	            if (employee.getLeaveBalance() >= days) {
	                employee.setLeaveBalance(employee.getLeaveBalance() - days);
	                leave.setStatus("APPROVED");
	                employeeDao.saveEmployee(employee);
	                return leaveDao.update(leave);
	            } else {
	                throw new RuntimeException("Insufficient leave balance");
	            }
	        } else {
	            throw new RuntimeException("Leave is already processed");
	        }
	    } else {
	        throw new LeaveNotExistsException();
	    }
	}
	
	//reject leave
	public Leave rejectLeave(int id) {
		Optional<Leave> l=leaveDao.findById(id);
		if(l.isPresent()) {
			Leave leave=l.get();
			String status=leave.getStatus();
			if(status.equals("PENDING")) {
				leave.setStatus("Rejected");
				return leaveDao.save(leave);
			}else {
	            throw new RuntimeException("Leave can be rejected only when status is PENDING");
	        }
		}else {
			throw new LeaveNotExistsException();
		}
	}
	
	//leave validation
	public Leave ValidateLeave(Leave leave) {
		Optional<Employee> e=employeeDao.findById(leave.getEmployee().getId());
		if(e.isPresent()) {
			Employee employee=e.get();
			int days=leave.getToDate().getDayOfMonth()-leave.getFromDate().getDayOfMonth()+1;
			if(employee.getLeaveBalance()>=days) {
				employee.setLeaveBalance(employee.getLeaveBalance()-(int)days);
				leave.setEmployee(employee);
				leave.setStatus("PENDING");
				return leaveDao.save(leave);
			}else {
				throw new RuntimeException("insufficient leave balance");
			}
		}else {
			throw new LeaveNotExistsException();
		
		}
	}
	
	//find all leves of all employees
	public List<Leave> findAll() {
		return leaveDao.findAll();
		
	}
	
	//find by status
	public List<Leave> findByStatus(String status){
		return leaveDao.findByStatus(status);
	}
	
	//approve leave with leave id and hr id
	public Leave approveLeaveByHR(int leaveId, int hrId) {
	    Optional<Employee> h = employeeDao.findById(hrId);
	    if (h.isPresent()) {
	        Employee hr = h.get();
	        if (hr.getRole().equals("HR") || hr.getRole().equals("MANAGER")) {
	            return approveLeave(leaveId);
	        } else {
	            throw new RuntimeException("Only HR or Manager can approve leave");
	        }
	    } else {
	        throw new EmployeeNotFoundException("HR/Manager not found");
	    }
	}
	
	//reject leave by hr
	public Leave rejectLeaveByHR(int leaveId,int hrId) {
		 Optional<Employee> e = employeeDao.findById(hrId);
		if(e.isPresent()) {
			Employee employee=e.get();
			if(employee.getRole().equals("HR") || employee.getRole().equals("MANAGER")) {
				return rejectLeave(leaveId);
			}else {
				throw new RuntimeException("only hr or manager can reject");
			}}
		else {
			throw new EmployeeNotFoundException("hr/manager not found");
			
		}
	}
	
	
	
	
	
	
	
	
	
	}

