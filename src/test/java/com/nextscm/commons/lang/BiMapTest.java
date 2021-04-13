package com.nextscm.commons.lang;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BiMapTest {

    BiMap<String, Integer> biMap;

    @Before
    public void init() {
        biMap = new BiMap<>();
        biMap.add("100", 1331);
        biMap.add("35689", 35689);
        biMap.add("908756", 908756);
        biMap.add("478", 478);
        biMap.add("73", 71);
        biMap.add("22764", 22764);
        biMap.add(null, 13);
    }

    @Test
    public void testAdd() {
        biMap.add("key", 1997);
    }

    @Test
    public void testGetTo() {
        assertEquals(478, biMap.getTo("478"), 0);
        assertNull(biMap.getTo("71"));
        assertEquals(13, biMap.getTo(null), 0);
    }

    @Test
    public void testGetFro() {
        assertEquals("22764", biMap.getFro(22764));
        assertNull(biMap.getFro(100));
        assertNull(biMap.getFro(13));
    }

    @Test
    public void testAddDuplicate() {
        biMap.add("key", 2001);
        assertEquals(2001, biMap.getTo("key"), 0);
        assertEquals("key", biMap.getFro(2001));
    }

    @Test
    public void testGetToGetFroInvalid() {
        assertNull(biMap.getTo("INVALID KEY"));
        assertNull(biMap.getFro(7777777));
    }

    @Test
    public void testGetKeys() {
        assertEquals(biMap.getKeys().size(), biMap.getValues().size());
    }

}
