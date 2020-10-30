package org.hustlebar.ospec.framework.model;

public class OResponseMedia {
    private String media;
    private String schemaRef;
    private String exampleName;
    private String exampleRef;

    public String media() {
        return this.media;
    }
    public OResponseMedia media(String media) {
        this.media = media;
        return this;
    }

    public String schemaRef() {
        return schemaRef;
    }
    public OResponseMedia schemaRef(String schemaRef) {
        this.schemaRef = schemaRef;
        return this;
    }

    public String exampleName() {
        return this.exampleName;
    }
    public OResponseMedia exampleName(String exampleName) {
        this.exampleName = exampleName;
        return this;
    }

    public String exampleRef() {
        return this.exampleRef;
    }
    public OResponseMedia exampleRef(String exampleRef) {
        this.exampleRef = exampleRef;
        return this;
    }
}
