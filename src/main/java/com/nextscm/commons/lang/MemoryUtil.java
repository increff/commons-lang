package com.nextscm.commons.lang;

/**
 * Returns Runtime JVM memory statistics (Max, Total, Used, Unused)
 */
public class MemoryUtil {

	private static final int MB = 1024 * 1024;

	/**
	 * @return A formatted string representing JVM Max, Total, Used and Free Memory
	 */
	public static String getString() {
		// Getting the runtime reference from system
		Runtime runtime = Runtime.getRuntime();
		long maxMemory = runtime.maxMemory() / MB;
		long totalMemory = runtime.totalMemory() / MB;
		long usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / MB;
		long freeMemory = runtime.freeMemory() / MB;

		return "Memory[MB] Max:" + maxMemory + ", Total:" + totalMemory + ", Used:" + usedMemory + ", Free:" + freeMemory;
	}
}
