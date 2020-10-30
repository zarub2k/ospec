package org.hustlebar.ospec.framework.model;

public class CResponse {
    private String name;
    private String description;

    public String name() {
        return this.name;
    }
    public CResponse name(String name) {
        this.name = name;
        return this;
    }
}
