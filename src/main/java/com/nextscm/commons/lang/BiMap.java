package com.nextscm.commons.lang;

import java.util.HashMap;
import java.util.Set;

public class BiMap<K, V> {

	private HashMap<K, V> to;
	private HashMap<V, K> fro;

	/**
	 * Represents a bidirectional Mapping using a key-to-value and a value-to-key HashMap
	 * Fetching non-existing values returns null
	 */
	public BiMap() {
		to = new HashMap<>();
		fro = new HashMap<>();
	}

	/**
	 * Adds a pair of values mapped bidirectionally
	 * @param key Key for the mapping
	 * @param value Value corresponding to key for the mapping
	 */
	public void add(K key, V value) {
		to.put(key, value);
		fro.put(value, key);
	}

	/**
	 * Returns the value corresponding to a key
	 * @param key Key f the key-to-value mapping
	 * @return Value corresponding to a key
	 */
	public V getTo(K key) {
		return to.get(key);
	}

	/**
	 * Returns the key corresponding to a value
	 * @param value Key in the value-to-key mapping
	 * @return Key corresponding to a value
	 */
	public K getFro(V value) {
		return fro.get(value);
	}

	/**
	 * @return Set of all values in the BiMap object
	 */
	public Set<V> getValues() {
		return fro.keySet();
	}

	/**
	 *
	 * @return Set of all keys in the BiMap object
	 */
	public Set<K> getKeys() {
		return to.keySet();
	}

}
