package com.nextscm.commons.lang;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Allows creation/deletion of temporary files and directories
 */
public class FileUtil {

	private static final String JAVA_TEMP_DIR = "java.io.tmpdir";

	/**
	 * Create a temporary directory with the specified name in JAVA_TEMP_DIR location (if not exists)
	 * @param dirName Name of directory to be created
	 * @return File object representing created temporary directory
	 */
	public static File getTempDir(String dirName) throws IOException {
		File dir = new File(System.getProperty(JAVA_TEMP_DIR));
		dir = new File(dir, dirName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}

	/**
	 * Create a temporary, in-memory file with given filename in specified directory
	 * @param dir Directory where file is to be created
	 * @param fileName Name of file
	 * @return File object representing created file
	 */
	public static File createTempFile(File dir, String fileName) throws IOException {
		return new File(dir, fileName);
	}

	/**
	 * Create a temporary, in-memory file using just the extension (assigns random name) in specified directory
	 * @param dir Directory where file is to be created
	 * @param ext Extension of the file to be created e.g ".csv", ".txt"
	 * @return File object representing the created file
	 */
	public static File createTempFileWithExt(File dir, String ext) throws IOException {
		String fileName = UUID.randomUUID().toString() + ext;
		return createTempFile(dir, fileName);
	}

	/**
	 * Quietly Delete a file by specifying it filePath
	 * @param filePath Path to file
	 */
	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			return;
		}
		file.delete();
	}

	/**
	 * Quietly try to close a file
	 * @param c Closeable object
	 */
	public static void closeQuietly(Closeable c) {
		if (c == null) {
			return;
		}
		try {
			c.close();
		} catch (IOException e) {
			// Don't do anything here. Its a quite close !
		}
	}

}
