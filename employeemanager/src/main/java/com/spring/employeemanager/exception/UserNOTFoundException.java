package com.spring.employeemanager.exception;

public class UserNOTFoundException extends RuntimeException{

public UserNOTFoundException(String message) {
	super(message);
}
}
