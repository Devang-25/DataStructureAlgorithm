/**
 * This will list all directory and files inside specified path.
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
 * This code will print all files and directory in given path.
 * It will not recursively print all files inside any directory.
 * 
 * @author Rakesh Gupta
 */
public class ListDirectory implements Command {

    /**
     * Checking if list directory command can be handled.
     */
    @Override
    public boolean shouldHandle(String command) {
        return Constants.LIST_DIR_CMD.equals(command);
    }

    /**
     * This will process the ls command. And list all files and directory on
     * console.
     */
    @Override
    public ResultData process(InputData inputData) {
    	Directory directory = inputData.getWorkingDirectory();
    	directory.printDirs();
    	return ResultDataUtil.prepareEmptyResultData(directory);
    }

}
