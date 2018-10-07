/**
 * 
 */
package com.linux.app.command.impl;

import com.linux.app.command.Command;
import com.linux.app.config.Constants;
import com.linux.app.filesystem.Directory;
import com.linux.app.io.InputData;
import com.linux.app.io.ResultData;
import com.linux.app.util.ResultDataUtil;


/**
 * This will remove given directory from current directory.
 * 
 * @author  Rakesh Gupta
 *
 */
public class RemoveDirectory implements Command {

	@Override
	public boolean shouldHandle(String command) {
		return command.startsWith(Constants.REMOVE_DIR_CMD);
	}

	/**
	 * This will remove given directory if exist otherwise will throw invalid ouptut.
	 * 
	 */
	@Override
	public ResultData process(InputData inputData) {
		Directory currDir = inputData.getWorkingDirectory();
		String[] dirNames = prepareDirNames(inputData.getCommandText());
		for (String dirName : dirNames) {
			if (!currDir.getChildDirs().contains(new Directory(dirName))) {
				return ResultDataUtil.prepareValidResultData(Constants.GENERIC_ERROR_CODE,
						Constants.DIR_DOES_NOT_EXIST_ERROR, currDir);
			}
			currDir.getChildDirs().remove(new Directory(dirName));
		}
		return ResultDataUtil.prepareSuccessResultData(Constants.DIR_DELETED_MESSAGE, currDir);
	}

	private String[] prepareDirNames(String commandText) {
		String[] dirNames = commandText.replace(Constants.REMOVE_DIR_CMD, "").split(" ");
		return dirNames;
	}
	
}
