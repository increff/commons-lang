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
