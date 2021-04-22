/*
 * Copyright (c) 2021. Increff
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.increff.commons.lang;

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
