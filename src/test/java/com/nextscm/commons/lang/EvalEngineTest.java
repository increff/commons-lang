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
