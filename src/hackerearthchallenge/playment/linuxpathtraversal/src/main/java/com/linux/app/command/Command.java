/**
 * Command is base interface represents all command.
 */
package com.linux.app.command;

import com.linux.app.io.InputData;
import com.linux.app.io.ResultData;

/**
 * Command is base command which process all command. It has two method.
 * 1.shouldHandle - which check if given command will be executed by this command.
 * 2. process method which process the actual command.
 * 
 * @author Rakesh Gupta
 */
public interface Command {

	/**
	 * Return boolean if this method handles given command.
	 * 
	 * @param command to check if it can be handled by this.
	 * @return boolean based on handle implementation.
	 */
	boolean shouldHandle(String command);

	/**
	 * Perform the operation based on command and directory file.
	 * 
	 * @param inputData
	 * @return
	 */
	ResultData process(InputData inputData);

}
