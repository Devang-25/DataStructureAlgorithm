/**
 * 
 */
package com.linux.app.exception;

/**
 * Command exception.
 * @author  Rakesh Gupta
 *
 */
public class CommandException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorCode;

	public CommandException() {
		super();
	}

	public CommandException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
