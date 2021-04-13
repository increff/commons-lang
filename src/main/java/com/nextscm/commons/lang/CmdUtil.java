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

package com.nextscm.commons.lang;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

//We keep the class name ending snippet as there are too many classes in the world ending with 'util'
/**
 * Allows the execution of operating system processes through provided commands
 */
public class CmdUtil {

	/**
	 * Runs an operating system command
	 * @param cmd List of Strings signifying external program to execute along with its arguments (if any)
	 * @param out Destination of process output, if execution successful
	 * @param error Destination of error output when it occurs
	 */
	public static void runCmd(String[] cmd, Redirect out, Redirect error) throws IOException, InterruptedException {
		int exitValue = runCmdProcess(cmd, out, error);
		if (exitValue == 0) {
			return;
		}
		String cmdName = cmd[0];
		throw new IOException("Error running command: " + cmdName + ", exitValue: " + exitValue);
	}
	
	public static int runCmdProcess(String[] cmd, Redirect out, Redirect error)
			throws IOException, InterruptedException {
		Process p = null;
		ProcessBuilder b = new ProcessBuilder(cmd);
		if (error != null) {
			b.redirectError(error);
		}
		if (out != null) {
			b.redirectOutput(out);
		}
		p = b.start();
		p.waitFor();
		return p.exitValue();
	}

}
