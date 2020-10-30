package org.hustlebar.ospec.framework.model;

public class OExample<T> {
    private String name;
    private T sample;

    public String name() {
        return this.name;
    }
    public OExample<T> name(String name) {
        this.name = name;
        return this;
    }

    public T sample() {
        return this.sample;
    }
    public OExample<T> sample(T sample) {
        this.sample = sample;
        return this;
    }
}
