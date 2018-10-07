package com.linux.app.command.impl;

import com.linux.app.command.Command;
import com.linux.app.config.Constants;
import com.linux.app.filesystem.Directory;
import com.linux.app.io.InputData;
import com.linux.app.io.ResultData;
import com.linux.app.util.ResultDataUtil;

/**
 * This will print current working directory to cmd.
 * 
 * @author  Rakesh Gupta
 *
 */
public class PresentWorkingDirectory implements Command {

	@Override
	public boolean shouldHandle(String command) {
		return Constants.PWD_CMD.equals(command);
	}

	/**
	 * THis will print current working directory to cmd.
	 */
	@Override
	public ResultData process(InputData inputData) {
		return ResultDataUtil.prepareValidResultData(Constants.PWD_MESSAGE_CODE,
				(inputData.getWorkingDirectory() != null ? pwdName(inputData.getWorkingDirectory()) : ""),
				inputData.getWorkingDirectory());
	}
	
	/**
	 * Print present working directory from root.
	 * 
	 * @param currDir
	 * @return
	 */
	private String pwdName(Directory currDir) {
		Directory clonedDir = currDir, orignalDir = currDir;
		StringBuffer pwdName = new StringBuffer();
		while(clonedDir != null) {
			pwdName.append(" " + clonedDir.getName());
			clonedDir = clonedDir.getParent();
		}
		currDir = orignalDir;
		return pwdName.toString(); 
	}
}
