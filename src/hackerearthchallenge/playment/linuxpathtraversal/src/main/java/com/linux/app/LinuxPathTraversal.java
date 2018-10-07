/**
 * This is command line application for window which takes linux command.
 */
package com.linux.app;

import java.util.Scanner;

import com.linux.app.command.Command;
import com.linux.app.command.impl.ChangeDirectory;
import com.linux.app.command.impl.ClearApplicationSession;
import com.linux.app.command.impl.ListDirectory;
import com.linux.app.command.impl.MakeDirectory;
import com.linux.app.command.impl.PresentWorkingDirectory;
import com.linux.app.command.impl.RemoveDirectory;
import com.linux.app.config.Constants;
import com.linux.app.exception.CommandException;
import com.linux.app.io.InputData;
import com.linux.app.io.ResultData;

/**
 * 
 * This is main driver program to start cmd application which takes linux command.
 * It has following commands.
 * 1. mkdir <dirName> <dirName> .... - create multiple directory with specified name.
 * 2. ls - print all directory inside this directory.
 * 3. cd <distDir>/<>/... - change direcotry.
 * 4. pwd - print current working directory.
 * 5. rm <dirName> <dirName> .... - remove given all directory.
 * 
 * @author Rakesh Gupta
 */
public class LinuxPathTraversal {

	/**
	 * Register all available commands for processing.
	 */
	private Command[] availableCmds = new Command[] { new ChangeDirectory(), new ListDirectory(), new MakeDirectory(),
			new PresentWorkingDirectory(), new RemoveDirectory(), new ClearApplicationSession() };

	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Output data after processing.
	 */
	private static ResultData result = new ResultData(false);
	
	/**
	 * Input data for processing.
	 */
	private static InputData input = new InputData();

	/**
	 * Main method is called by JVM.
	 * 
	 * @param args is command line input argument
	 */
	public static void main(String[] args) {

		// Start main command line application.
		LinuxPathTraversal app = new LinuxPathTraversal();
		app.greet();
		boolean runnning = true;
		
		while (runnning) {
			String cmd = Constants.DEFAULT_CMD;
			try {
				cmd = app.readInput();
				input.setCommandText(cmd);
				result.setHandled(false);
				app.processCommandText(input);
			} catch (CommandException e) {
				System.out.println(e.getErrorCode() + ": " + e.getErrorMessage());
			}
			// For stoping application provide specific input 
			// and set running = false
		}
	}

	private void greet() {
		System.out.println("Welcome to Linux Path Traversal..");
		System.out.println("For help please check README file.");
	}

	/**
	 * Read input from console.
	 * @return
	 */
	private String readInput() {
		System.out.print("$> ");
		return scanner.nextLine();
	}

	/**
	 * Print output result to console.
	 * 
	 * @param result
	 * @throws CommandException 
	 */
	private void printResult(ResultData result) throws CommandException {
		if (!result.isHandled()) {
			System.out.println(Constants.GENERIC_ERROR_CODE + " " + Constants.GENERIC_ERROR_MESSAGE);
		} else if (null != result.getOutputCode()) {
			System.out.println(result.getOutputCode() + " " + result.getOutputMessage());
		}
	}

	/**
	 * Process the command for execution.
	 * 
	 * @param inputData is passed input command.
	 * @return
	 */
	private void processCommandText(InputData inputData) throws CommandException {
		for (int i = 0; i < availableCmds.length; i++) {
			Command currentCommand = availableCmds[i];
			tryAvailableCommand(inputData, currentCommand);
		}
		if (!result.isHandled()) {
			printResult(result);
		}
	}

	/**
	 * Select appropriete command from available command.
	 * 
	 * @param inputData is input command for processing.
	 * @param currentCommand is cmd which can be performed.
	 * @return
	 */
	private void tryAvailableCommand(InputData inputData, Command currentCommand) throws CommandException {
		if (currentCommand.shouldHandle(inputData.getCommandText())) {
			result = processCurrentCommand(inputData, currentCommand);
			printResult(result);
		}
	}

	/**
	 * Process the current selected command for execution.
	 * 
	 * @param inputData      is passed input command
	 * @param currentCommand is available command to handle.
	 * @return
	 */
	private ResultData processCurrentCommand(InputData inputData, Command currentCommand) throws CommandException {
		inputData.setWorkingDirectory(result.getWorkingDirectory());
		result = currentCommand.process(inputData);
		result.setHandled(true);
		return result;
	}
}
