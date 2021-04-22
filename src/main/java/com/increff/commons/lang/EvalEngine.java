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

import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Allows evaluation/execution of a script in ECMAScript/Javascript
 */
public class EvalEngine {

	private static ScriptEngine engine;

	/**
	 * Returns a ScriptEngine for executing Javascript code
	 * @return JavaScript ScriptEngine Object
	 */
	public static ScriptEngine getEngine() {
		if (engine == null) {
			ScriptEngineManager factory = new ScriptEngineManager();
			engine = factory.getEngineByName("JavaScript");
		}
		return engine;
	}

	/**
	 * Evaluates/Executes a provided JS Script
	 * @param script The JS script to be executed
	 * @return The value returned from the execution of the script
	 */
	public static Object eval(String script) throws ScriptException {
		return getEngine().eval(script);
}

	/**
	 * Evaluates/Executes a provided JS Script with params
	 * @param script The JS script to be executed
	 * @param params Additional params to be included during execution
	 * @return The value returned from the execution of the script
	 */
	public static Object eval(String script, Map<String, String> params) throws ScriptException {
		String fullScript = format(script, params);
		return eval(fullScript);
	}

	/**
	 * Formats a script code to include params required for script execution
	 * @param str The JS script to be formatted
	 * @param params The params required to be included
	 * @return Formatted String with script and params
	 */
	public static String format(String str, Map<String, String> params) {
		return params.entrySet().stream().reduce(str, (s, e) -> s.replace("#" + e.getKey(), e.getValue()),
				(s, s2) -> s);
	}
}
