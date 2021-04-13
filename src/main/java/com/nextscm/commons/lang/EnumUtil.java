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

public class EnumUtil {

	/**
	 *
	 * @param keyEnum The Enum value for which to search
	 * @param targetEnumArray An array of Enum values in which to search
	 * @return Boolean, True if Enum value found in Array, False otherwise
	 */
	public static <T extends Enum<T>> boolean in(T keyEnum, T[] targetEnumArray) {
		for (Enum<?> expected : targetEnumArray) {
			if (expected.equals(keyEnum)) {
				return true;
			}
		}
		return false;
	}

}
