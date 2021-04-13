package com.nextscm.commons.lang;

import java.util.HashMap;

public class PrintUtil {

	/**
	 * Prints all entries of a HashMap on the console
	 * @param map HashMap to print
	 */
	public static void print(HashMap<?, ?> map){
		for (Object key : map.keySet()){
			System.out.println("Key: " + key + ", Value:" + map.get(key));
		}
	}
}
