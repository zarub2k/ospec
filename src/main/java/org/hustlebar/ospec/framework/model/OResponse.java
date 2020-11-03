package org.hustlebar.ospec.framework.model;

import java.util.ArrayList;
import java.util.List;

public class OResponse {
    private int code;
    private String description;
    private String ref;

    private final List<Tuple> contents = new ArrayList<>();

    public OResponse() {}

    public int code() { return this.code; }
    public OResponse code(int code) {
        this.code = code;
        return this;
    }

    public String description() { return this.description; }
    public OResponse description(String description) {
        this.description = description;
        return this;
    }

    public String ref() {
        return this.ref;
    }
    public OResponse ref(String ref) {
        this.ref = ref;
        return this;
    }

    public List<Tuple> contents() { return this.contents; }
    public OResponse content(Tuple content) {
        this.contents.add(content);
        return this;
    }
}
