package org.hustlebar.ospec.framework.model;

public class OInfo {
    private String title;
    private String description;
    private String version;

    public OInfo() {}

    public String title() {
        return this.title;
    }
    public OInfo title(String title) {
        this.title = title;
        return this;
    }

    public String description() {
        return this.description;
    }
    public OInfo description(String description) {
        this.description = description;
        return this;
    }

    public String version() {
        return this.version;
    }
    public OInfo version(String version) {
        this.version = version;
        return this;
    }
}
