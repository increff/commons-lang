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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

/**
 * Utility class with methods to convert collections to maps, lists, etc
 */
public class CollectionUtil {

	/**
	 * Convert a Collection of objects into a HashMap based on a given mapper
	 * @param collection Collection to be converted
	 * @param mapper Mapping to be used to determine the key in the HashMap
	 * @return HashMap generated from Collection
	 */
	public static <T, K> HashMap<K, T> toMap(Collection<T> collection, Function<T, K> mapper) {
		HashMap<K, T> map = new HashMap<>();
		for (T t : collection) {
			map.put(mapper.apply(t), t);
		}
		return map;
	}

	/**
	 * Collects values from given list of objects, based on given mapper
	 * @param list Collection of objects from which to collect values
	 * @param mapper mapper to define what values must be collected
	 * @return Collection of specified values
	 */
	public static <O, V> Collection<V> toList(Collection<O> list, Function<O, V> mapper) {
		Collection<V> result = new ArrayList<V>(list.size());
		for (O obj : list) {
			V value = mapper.apply(obj);
			result.add(value);
		}
		return result;
	}

	/**
	 * Collects and merge fields which are lists of values from given list of objects, based on mapper
	 * @param list Collection of objects from which to collect list of values
	 * @param mapper Mapper to define what list of values must be collected
	 * @return Collection of specified values merged into a continuous list
	 */
	public static <O, V> Collection<V> merge(Collection<O> list, Function<O, Collection<V>> mapper) {
		int count = 0;
		for (O obj : list) {
			count += mapper.apply(obj).size();
		}
		Collection<V> result = new ArrayList<V>(count);
		for (O obj : list) {
			Collection<V> value = mapper.apply(obj);
			result.addAll(value);
		}
		return result;
	}

	/**
	 * Merge two Collections into a single list
	 * @param list1 First Collection to be merged
	 * @param list2 Second Collection to be merged
	 * @return Merged list of elements
	 */
	public static <O> Collection<O> merge(Collection<O> list1, Collection<O> list2) {
		Collection<O> result = new ArrayList<O>(list1.size() + list2.size());
		result.addAll(list1);
		result.addAll(list2);
		return result;
	}

	/**
	 * Merges a list of lists into a single list
	 * @param listOfLists List of lists to be merged
	 * @return Merged list of elements
	 */
	public static <O> List<O> merge(List<List<O>> listOfLists) {
		int count = 0;
		for (List<O> list : listOfLists) {
			count += list.size();
		}
		List<O> result = new ArrayList<O>(count);
		for (List<O> list : listOfLists) {
			result.addAll(list);
		}
		return result;
	}

	/**
	 * Find duplicated values (except first occurrence) in a Collection based on a Comparator
	 * @param list List to scan for duplicate
	 * @param comparator Comparator to specify field to be used for duplicate checking
	 * @return Collection of duplicate values (except their first occurrence)
	 */
	public static <O> Collection<O> getDuplicates(Collection<O> list, Comparator<O> comparator) {
		Set<O> set = new TreeSet<O>(comparator);
		Collection<O> result = new ArrayList<O>();
		for (O obj : list) {
			if (!set.add(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	/**
	 * Returns Set of Unique values (and first occurrences of duplicated values) based on a Comparator
	 * @param list list to be scanned for unique values
	 * @param comparator Comparator to specify field to be used for duplicate checking
	 * @return Set of all unique values (including first occurrence of duplicate values)
	 */
	public static <O> Set<O> getUnique(Collection<O> list, Comparator<? super O> comparator) {
		TreeSet<O> set = new TreeSet<O>(comparator);
		set.addAll(list);
		return set;
	}

	/**
	 * Converts a java.util.Properties object into a HashMap
	 * @param properties Properties Object to be converted
	 * @return Mapping of Strings obtained from Properties object
	 */
	public static Map<String, String> toMap(Properties properties) {
		HashMap<String, String> map = new HashMap<>();
		for (Object key : properties.keySet()) {
			map.put(key.toString(), properties.get(key).toString());
		}
		return map;
	}

	/**
	 * Compares two Collections of String objects for equality
	 * @param s1 First Collection
	 * @param s2 Second Collection
	 * @return true if equal, false otherwise
	 */
	public static boolean equals(Collection<String> s1, Collection<String> s2) {
		return s1.containsAll(s2) && s2.containsAll(s1);
	}

}
