package com.linux.app.io;

import com.linux.app.command.Command;
import com.linux.app.filesystem.Directory;

/**
 * This class contains input data for processing.
 * 
 * @author  Rakesh Gupta
 *
 */
public class InputData {

	private Directory workingDirectory;
	private Command command;
	private String commandText;

	public InputData() {
		this.workingDirectory = new Directory();
	}

	public InputData(Directory workingDirectory) {
		this.workingDirectory = workingDirectory;
	}

	public InputData(Directory workingDirectory, Command command) {
		this(workingDirectory);
		this.command = command;
	}

	public InputData(Directory workingDirectory, Command command, String commandText) {
		this(workingDirectory, command);
		this.commandText = commandText;
	}

	public Directory getWorkingDirectory() {
		return workingDirectory;
	}

	public void setWorkingDirectory(Directory workingDirectory) {
		this.workingDirectory = workingDirectory;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public String getCommandText() {
		return commandText;
	}

	public void setCommandText(String commandText) {
		this.commandText = commandText;
	}
}
