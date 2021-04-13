package com.nextscm.commons.lang;

import java.util.Collection;
import java.util.Objects;

class Person {
    private String name;
    private int age;
    private Collection<String> features;

    public Person(String name, int age, Collection<String> features) {
        super();
        this.name = name;
        this.age = age;
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Collection<String> getFeatures() {
        return features;
    }

    public void setFeatures(Collection<String> features) {
        this.features = features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(features, person.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, features);
    }
}