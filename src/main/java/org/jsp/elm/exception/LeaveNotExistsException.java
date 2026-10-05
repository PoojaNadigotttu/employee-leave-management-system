package org.jsp.elm.exception;

public class LeaveNotExistsException extends RuntimeException {

    public LeaveNotExistsException() {
        super("Leave not found");
    }
	

}
