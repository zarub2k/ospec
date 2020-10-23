package org.hustlebar.ospec.framework.model;

import java.util.ArrayList;
import java.util.List;

public class ORequest {
    private String description;
    private final List<Tuple> contents = new ArrayList<>();

    public String description() { return this.description; }
    public ORequest description(String description) {
        this.description = description;
        return this;
    }

    public List<Tuple> contents() { return this.contents; }
    public ORequest content(Tuple content) {
        this.contents.add(content);
        return this;
    }
}
