package com.linux.app.util;

import com.linux.app.config.Constants;
import com.linux.app.filesystem.Directory;
import com.linux.app.io.ResultData;

/**
 * Utility for creating output result data set.
 * 
 * @author Rakesh Gupta
 *
 */
public class ResultDataUtil {

	private ResultDataUtil() {
		super();
	}

	/**
	 * Create output result data set with given message and current working directory.
	 * 
	 * @param message
	 * @param currentDir
	 * @return
	 */
	public static ResultData prepareSuccessResultData(String message, Directory currentDir) {
		ResultData resultData = new ResultData();
		resultData.setOutputCode(Constants.SUCCESS_OPERATION_CODE);
		resultData.setOutputMessage(message);
		resultData.setWorkingDirectory(currentDir);
		return resultData;
	}
	
	/**
	 * Create output result data set with given message and current working directory.
	 * 
	 * @param messageCode
	 * @param message
	 * @param currentDir
	 * @return
	 */
	public static ResultData prepareValidResultData(String messageCode, String message, Directory currentDir) {
		ResultData resultData = new ResultData();
		resultData.setOutputCode(messageCode);
		resultData.setOutputMessage(message);
		resultData.setWorkingDirectory(currentDir);
		return resultData;
	}

	/**
	 * Create output result data set with empty message and current working directory.
	 * @param directory
	 * @return
	 */
	public static ResultData prepareEmptyResultData(Directory directory) {
		return new ResultData(directory, false);
 	}

}
