package org.hustlebar.ospec.framework.model;

public class Tuple {
    private String key;
    private String value;

    public Tuple() {}
    public Tuple(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String key() { return this.key; }
    public String value() { return this.value; }
}
