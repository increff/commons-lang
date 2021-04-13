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

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertSame;

public class CollectionUtilTest {

    public static final Collection<Person> getPersonCollection() {
        Collection<Person> list = new ArrayList<>();
        List<String> features = new ArrayList<>();
        features.add("feature1");
        features.add("feature2");
        features.add("feature3");
        list.add(new Person("aaa", 18, features));
        list.add(new Person("bbb", 19, features));
        list.add(new Person("bbb", 18, features));
        list.add(new Person("ccc", 20, features));
        list.add(new Person("ddd", 21, features));
        return list;
    }

    @Test
    public void testToMap() {
        List<Person> list = (List<Person>) getPersonCollection();
        Map<String, Person> map = CollectionUtil.toMap(list, obj -> obj.getName());
        assertEquals(list.size() - 1, map.size());
        for (Person p : list) {
            assertTrue(map.containsKey(p.getName()));
        }
        assertSame(map.get("aaa"), list.get(0));
        assertSame(map.get("bbb"), list.get(2));
        assertSame(map.get("ccc"), list.get(3));
    }

    @Test
    public void testToList() {
        Collection<Person> list = getPersonCollection();
        Collection<Integer> ages = CollectionUtil.toList(list, obj -> obj.getAge());
        assertEquals(list.size(), ages.size());
        for (Person p : list) {
            assertTrue(ages.contains(p.getAge()));
        }
    }

    @Test
    public void testMerge1() {
        Collection<Person> list = getPersonCollection();
        Collection<String> features = CollectionUtil.merge(list, obj -> obj.getFeatures());
        int total = 0;
        for (Person p : list)
            total += p.getFeatures().size();
        assertEquals(total, features.size());
    }

    @Test
    public void testMerge2() {
        Collection<Person> list1 = getPersonCollection();
        Collection<Person> list2 = getPersonCollection();
        assertEquals(list1.size() + list2.size(), CollectionUtil.merge(list1, list2).size());
    }

    @Test
    public void testMerge3() {
        List<Person> list1 = new ArrayList<>(getPersonCollection());
        List<Person> list2 = new ArrayList<>(getPersonCollection());
        List<List<Person>> big = new ArrayList<>();
        big.add(list1);
        big.add(list2);
        Collection<Person> res = CollectionUtil.merge(big);
        assertEquals(list1.size() + list2.size(), res.size());
    }

    @Test
    public void testGetDuplicates() {
        Collection<Person> list = getPersonCollection();
        Collection<Person> dup = CollectionUtil.getDuplicates(list, new PersonComparator());
        assertEquals(1, dup.size());
    }

    @Test
    public void testGetUnique() {
        Collection<Person> list = getPersonCollection();
        Collection<Person> unique = CollectionUtil.getUnique(list, new PersonComparator());
        assertEquals(4, unique.size());
    }

    @Test
    public void testToMap1() {
        Properties properties = new Properties();
        properties.put("prop1", "val1");
        properties.put("prop2", "val2");
        properties.put("prop3", "val3");
        properties.put("prop4", "val4");
        Map<String, String> map = CollectionUtil.toMap(properties);
        assertEquals(map.size(), properties.size());
        for (Map.Entry<Object, Object> prop : properties.entrySet()) {
            assertTrue(map.containsKey(prop.getKey()));
            assertTrue(map.containsValue(prop.getValue()));
        }
    }

    @Test
    public void testEquals() {
        Collection<String> collection1 = getStringCollection();
        Collection<String> collection2 = getStringCollection();
        CollectionUtil.equals(collection1, collection2);
    }

    public Collection<String> getStringCollection() {
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("A");
        collection1.add("B");
        collection1.add("C");
        collection1.add("D");
        collection1.add("E");
        return collection1;
    }

    class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());

        }
    }


}

