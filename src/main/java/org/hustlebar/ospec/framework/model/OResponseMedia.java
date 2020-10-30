package org.hustlebar.ospec.framework.model;

public class OResponseMedia {
    private String media;
    private String schemaRef;
    private String exampleRef;

    public String media() {
        return this.media;
    }
    public OResponseMedia media(String media) {
        this.media = media;
        return this;
    }
}
