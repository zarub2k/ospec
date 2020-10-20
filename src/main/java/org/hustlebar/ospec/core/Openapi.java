package org.hustlebar.ospec.core;

public class Openapi {
    private String version;

    public Openapi() {}

    public String version() {
        return this.version;
    }

    public Openapi version(String version) {
        this.version = version;
        return this;
    }
}
