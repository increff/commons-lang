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

import java.util.Collection;

public class StringUtil {

	/**
	 * Concatenates a Collection of Strings, separated by a customer "separator" string
	 * @param lines Collection of Strings to concatenate
	 * @param separator String to be used as separator between lines
	 * @return Concatenated String
	 */
	public static String concat(Collection<String> lines, String separator) {
		// We use StringBuilder as it is non-thread safe and hence faster
		StringBuilder sbuff = new StringBuilder();
		for (String s : lines) {
			sbuff.append(separator).append(s);
		}
		return sbuff.substring(1);
	}

	/**
	 * Check if a String is null or empty
	 * @param s String to be checked
	 * @return true if String is empty/null, false otherwise
	 */
	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

}
