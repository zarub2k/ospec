package org.hustlebar.ospec.framework.model;

public class OServer {
    private String url;
    private String description;

    public OServer() {}

    public String url() {
        return this.url;
    }
    public OServer url(String url) {
        this.url = url;
        return this;
    }

    public String description() {
        return this.description;
    }
    public OServer description(String description) {
        this.description = description;
        return this;
    }
}
