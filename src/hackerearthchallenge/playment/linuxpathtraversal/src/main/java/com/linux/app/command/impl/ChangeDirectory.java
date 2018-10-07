/**
 * This is main program for 'cd' command.
 */
package com.linux.app.command.impl;

import java.util.List;

import com.linux.app.command.Command;
import com.linux.app.config.Constants;
import com.linux.app.filesystem.Directory;
import com.linux.app.io.InputData;
import com.linux.app.io.ResultData;
import com.linux.app.util.ResultDataUtil;

/**
 * 
 * This class will change directory based on user input.
 * 
 * @author Rakesh Gupta
 */
public class ChangeDirectory implements Command {

	/**
	 * Checking if change directory command can be handled.
	 */
	@Override
	public boolean shouldHandle(String command) {
		return command.startsWith(Constants.CHANGE_DIR_CMD);
	}

	/**
	 * This will process the changing of directory. It will through invalid output
	 * if new directory entered is not valid directory name.
	 */
	@Override
	public ResultData process(InputData inputData) {

		Directory currDir = inputData.getWorkingDirectory();
		String[] dirNames = prepareDirNames(inputData.getCommandText());
		for (String dir : dirNames) {
			List<Directory> childDirs = currDir.getChildDirs();
			if (Constants.CHANGE_DIR_BACKWARD.equals(dir)) {
				return ResultDataUtil.prepareSuccessResultData(Constants.CHANGE_DIR_SUCCESS, currDir.getParent());
			}

			// TODO Checking directory structure from root.

			if (childDirs.contains(new Directory(dir))) {
				currDir = childDirs.get(childDirs.indexOf(new Directory(dir)));
			} else {
				return ResultDataUtil.prepareValidResultData(Constants.GENERIC_ERROR_CODE,
						Constants.CHANGE_DIR_INVALID_PATH_ERROR, currDir);
			}
		}
		return ResultDataUtil.prepareSuccessResultData(Constants.CHANGE_DIR_SUCCESS, currDir);
	}

	private String[] prepareDirNames(String commandText) {
		String[] dirNames = commandText.replace(Constants.CHANGE_DIR_CMD, "").split("/");
		return dirNames;
	}
}
