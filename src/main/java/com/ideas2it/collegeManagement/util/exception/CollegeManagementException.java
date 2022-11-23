package com.ideas2it.collegeManagement.util.exception;



	
	/**
	 * <p>
	 * This class is used to create custom exception and use this function.
	 * <p>
	 *
	 * @author jeevanantham
	 * @version 1.0  10 SEP 2022
	 */
public class CollegeManagementException  extends Exception {

	    public CollegeManagementException (String message) {
	        super (message);
	    }

	   public CollegeManagementException(String message, Throwable throwable) {
	       super (message);
	   }
	}