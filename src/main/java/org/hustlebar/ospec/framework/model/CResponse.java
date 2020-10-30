package org.hustlebar.ospec.framework.model;

public class CResponse {
    private String name;
    private String description;
    private OResponseMedia media;

    public String name() {
        return this.name;
    }
    public CResponse name(String name) {
        this.name = name;
        return this;
    }

    public String description() {
        return this.description;
    }
    public CResponse description(String description) {
        this.description = description;
        return this;
    }

    public OResponseMedia media() {
        return this.media;
    }
    public CResponse media(OResponseMedia media) {
        this.media = media;
        return this;
    }
}
