package org.hustlebar.ospec.framework.model;

public class OSchema {
    private String name;
    private Class clazz;

    public String name() {
        return this.name;
    }
    public OSchema name(String name) {
        this.name = name;
        return this;
    }

    public Class clazz() {
        return this.clazz;
    }
    public OSchema clazz(Class clazz) {
        this.clazz = clazz;
        return this;
    }
}
