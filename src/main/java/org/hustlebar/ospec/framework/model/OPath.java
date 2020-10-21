package org.hustlebar.ospec.framework.model;

import java.util.ArrayList;
import java.util.List;

public class OPath {
    private String ctx;
    private String summary;
    private String description;

    private List<OMethod> methods = new ArrayList<>();

    public OPath() {}

    public String ctx() {
        return this.ctx;
    }
    public OPath ctx(String ctx) {
        this.ctx = ctx;
        return this;
    }

    public List<OMethod> methods() {
        return this.methods;
    }
    public OPath methods(List<OMethod> methods) {
        this.methods = methods;
        return this;
    }
    public OPath method(OMethod method) {
        this.methods.add(method);
        return this;
    }
}
