/**
 * This is result after processing some command.
 */
package com.linux.app.io;

import com.linux.app.filesystem.Directory;

/**
 * This class contains output data after processing.
 * 
 * @author Rakesh Gupta
 */
public class ResultData {

	private Directory workingDirectory;
	private String outputCode;
	private String outputMessage;
	private boolean handled;

	public ResultData() {
		this.workingDirectory = new Directory();
	}

	public ResultData(boolean handled) {
		this();
		this.handled = handled;
	}

	public ResultData(Directory workingDirectory) {
		this.workingDirectory = workingDirectory;
	}

	public ResultData(Directory workingDirectory, boolean handled) {
		this.workingDirectory = workingDirectory;
		this.handled = handled;
	}

	public ResultData(String outputCode, String outputMessage) {
		this();
		this.outputCode = outputCode;
		this.outputMessage = outputMessage;
	}

	/**
	 * @param workingDirectory
	 * @param outputCode
	 * @param outputMessage
	 */
	public ResultData(Directory workingDirectory, String outputCode, String outputMessage) {
		this.workingDirectory = workingDirectory;
		this.outputCode = outputCode;
		this.outputMessage = outputMessage;
	}

	public Directory getWorkingDirectory() {
		return workingDirectory;
	}

	public void setWorkingDirectory(Directory workingDirectory) {
		this.workingDirectory = workingDirectory;
	}

	public String getOutputCode() {
		return outputCode;
	}

	public void setOutputCode(String outputCode) {
		this.outputCode = outputCode;
	}

	public String getOutputMessage() {
		return outputMessage;
	}

	public void setOutputMessage(String outputMessage) {
		this.outputMessage = outputMessage;
	}

	public boolean isHandled() {
		return handled;
	}

	public void setHandled(boolean handled) {
		this.handled = handled;
	}
}
