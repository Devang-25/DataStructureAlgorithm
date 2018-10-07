package com.linux.app.command.impl;

import com.linux.app.command.Command;
import com.linux.app.config.Constants;
import com.linux.app.filesystem.Directory;
import com.linux.app.io.InputData;
import com.linux.app.io.ResultData;
import com.linux.app.util.ResultDataUtil;

/**
 * This will clear current session and will set pwd to root.
 * 
 * @author Rakesh Gupta
 *
 */
public class ClearApplicationSession implements Command {

	@Override
	public boolean shouldHandle(String command) {
		return Constants.CLEAR_SESSION_CMD.equals(command);
	}

	/**
	 * This will clear session and set directory to root.
	 * 
	 */
	@Override
	public ResultData process(InputData inputData) {
		return ResultDataUtil.prepareSuccessResultData(Constants.SESSION_CLEAR_MESSAGE, new Directory());
	}

}
