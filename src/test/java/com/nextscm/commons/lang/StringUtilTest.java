package com.nextscm.commons.lang;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void testConcat() {
        List<String> list = new ArrayList<>();
        list.add("TESTING");
        list.add("concat");
        list.add("method");
        list.add("currently...");
        String res = StringUtil.concat(list, " ");
        assertEquals(res, "TESTING concat method currently...");
        Set<String> set = new HashSet<>();
        set.add("Testing");
        set.add("using");
        set.add("map of");
        set.add("strings");
        res = StringUtil.concat(set, "\t");
        assertEquals(res, "map of\tusing\tstrings\tTesting");
        Collection<String> collection = null;
        try {
            StringUtil.concat(collection, "\n");
        } catch (NullPointerException e) {
            assertEquals(null, e.getMessage());
        }
        collection = new ArrayList<>();
        collection.add("");
        res = StringUtil.concat(collection, "\n");
        assertEquals(res, "");
    }

    @Test
    public void testIsEmpty() {
        String s = null;
        assertTrue(StringUtil.isEmpty(s));
        s = "";
        assertTrue(StringUtil.isEmpty(s));
        s = "In test of isEmpty() method of StringUtil";
        assertFalse(StringUtil.isEmpty(s));
        s = "       ";
        assertTrue(StringUtil.isEmpty(s));
        s = "\n" +
                "";
        assertTrue(StringUtil.isEmpty(s));
    }

}
