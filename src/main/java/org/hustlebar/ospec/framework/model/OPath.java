package org.hustlebar.ospec.framework.model;

import java.util.ArrayList;
import java.util.List;

public class OPath {
    private String ctx;
    private String summary;
    private String description;
    private List<OParameter> parameters = new ArrayList<>();

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

    public List<OParameter> parameters() {
        return this.parameters;
    }
    public OPath parameters(List<OParameter> parameters) {
        this.parameters = parameters;
        return this;
    }
    public OPath parameter(OParameter parameter) {
        this.parameters.add(parameter);
        return this;
    }
}
