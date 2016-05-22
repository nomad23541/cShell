package com.chrisreaidng.cshell.util;

import java.io.File;
import java.io.IOException;

/**
 * Has tools for various file uses
 */
public class FileUtils {
	
	/**
	 * Get all files in a directory
	 * @param dir
	 * @return
	 */
	public static File[] getFiles(String dir) {
		File file = new File(dir);
		return file.listFiles();
	}
	
	public static boolean createFile(String dir) throws IOException {
		File file = new File(dir);
		return file.createNewFile();
	}
	
	public static boolean deleteFile(String dir) {
		File file = new File(dir);
		return file.delete();
	}

}
