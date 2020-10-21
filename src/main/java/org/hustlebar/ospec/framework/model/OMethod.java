package org.hustlebar.ospec.framework.model;

public class OMethod {
    private String name;
    private String summary;
    private String description;

    public OMethod() {}

    public String name() {
        return this.name;
    }
    public OMethod name(String name) {
        this.name = name;
        return this;
    }

    public String summary() {
        return this.summary;
    }
    public OMethod summary(String summary) {
        this.summary = summary;
        return this;
    }

    public String description() {
        return this.description;
    }
    public OMethod description(String description) {
        this.description = description;
        return this;
    }
}
