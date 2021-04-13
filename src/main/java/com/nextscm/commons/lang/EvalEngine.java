package com.nextscm.commons.lang;

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
