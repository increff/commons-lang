package com.nextscm.commons.lang;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class InternerTest {

    @Test
    public void testIntern() {
        Interner<Person> interner = new Interner<>();
        List<Person> people = new ArrayList<>(getPersonCollection());
        assertEquals(people.get(0), interner.intern(people.get(0)));
        assertEquals(people.get(0), interner.intern(people.get(1)));
    }

    @Test
    public void testInternWithNull() {
        Interner<Person> interner = new Interner<>();
        assertNull(interner.intern(null));
    }

    @Test
    public void testInternerWith0Load() {
        try {
            new Interner<>(256, 0);
            fail();
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    public void testInternerWith0Capacity() {
        List<Person> people = new ArrayList<>(getPersonCollection());
        Interner<Person> interner = new Interner<>(0, 16);
        try {
            interner.intern(people.get(3));
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    public static final Collection<Person> getPersonCollection() {
        Collection<Person> list = new ArrayList<>();
        List<String> features = new ArrayList<>();
        features.add("feature1");
        features.add("feature2");
        features.add("feature3");
        list.add(new Person("aaa", 18, features));
        list.add(new Person("aaa", 18, features));
        list.add(new Person("bbb", 19, features));
        list.add(new Person("bbb", 18, features));
        list.add(new Person("ccc", 20, features));
        list.add(new Person("ddd", 21, features));
        return list;
    }

}
