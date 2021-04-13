package com.nextscm.commons.lang;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MemoryUtilTest {

    @Test
    public void testGetString(){
        assertNotNull(MemoryUtil.getString());
        System.out.println(MemoryUtil.getString());
        assertTrue(true);
    }

}
