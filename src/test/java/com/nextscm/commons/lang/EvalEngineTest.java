package com.nextscm.commons.lang;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.junit.Test;

public class EvalEngineTest {

	@Test
	public void testGetEngine() {
		ScriptEngine engine = EvalEngine.getEngine();
		assertEquals("jdk.nashorn.api.scripting.NashornScriptEngine", engine.getClass().getName());
	}

	@Test
	public void testFormat() {
		Map<String, String> parmas = new HashMap<String, String>();
		String script = "#totalCount > 10 ? #totalCount : #minCount";
		parmas.put("totalCount", "15");
		parmas.put("minCount", "5");
		String fullScript = EvalEngine.format(script, parmas);
		assertEquals("15 > 10 ? 15 : 5", fullScript);
	}

	@Test
	public void testEval() throws ScriptException {
		int value = (Integer) EvalEngine.eval("1+2");
		assertEquals(3, value);
	}

	@Test
	public void testEvalWithParams() throws ScriptException {
		Map<String, String> parmas = new HashMap<String, String>();
		String script = "#totalCount > 10 ? #totalCount : #minCount";
		parmas.put("totalCount", "15");
		parmas.put("minCount", "5");
		int value = (Integer) EvalEngine.eval(script, parmas);
		assertEquals(15, value);
	}

}
