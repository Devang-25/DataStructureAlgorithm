/**
 *  This will create new directory if given directory doesn't exit.
 */
package com.linux.app.command.impl;

import com.linux.app.command.Command;
import com.linux.app.config.Constants;
import com.linux.app.filesystem.Directory;
import com.linux.app.io.InputData;
import com.linux.app.io.ResultData;
import com.linux.app.util.ResultDataUtil;

/**
 * 
 * This code will create new directory if given directory doesn't exit. It will
 * through error if directory already exit.
 * 
 * @author Rakesh Gupta
 */
public class MakeDirectory implements Command {

	/**
	 * Checking if make directory command can be handled.
	 */
	@Override
	public boolean shouldHandle(String command) {
		return command.startsWith(Constants.MAKE_DIR_CMD);
	}

	/**
	 * This will process the mkdir command. And it will directory if directory
	 * doesn't exist. This will throw invalid output if directory already exist.
	 */
	@Override
	public ResultData process(InputData inputData) {
		Directory currDir = inputData.getWorkingDirectory();
		String[] newDirNames = prepareNewDirNames(inputData.getCommandText());
		for (String dirName : newDirNames) {
			if (currDir.getChildDirs().contains(new Directory(dirName))) {
				return ResultDataUtil.prepareValidResultData(Constants.GENERIC_ERROR_CODE,
						Constants.DIR_ALREADY_EXIST_ERROR, currDir);
			}
			// Add dirName directory to currDir as child dir.
			new Directory(dirName, currDir);
		}
		return ResultDataUtil.prepareSuccessResultData(Constants.DIR_CREATED_MESSAGE, currDir);
	}

	private String[] prepareNewDirNames(String commandText) {
		String[] dirNames = commandText.replace(Constants.MAKE_DIR_CMD, "").split(" ");
		return dirNames;
	}
}
