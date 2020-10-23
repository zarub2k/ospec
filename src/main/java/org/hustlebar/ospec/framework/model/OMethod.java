package org.hustlebar.ospec.framework.model;

import java.util.ArrayList;
import java.util.List;

public class OMethod {
    private String name;
    private String summary;
    private String description;
    private List<OParameter> parameters = new ArrayList<>();
    private List<OResponse> responses = new ArrayList<>();
    private ORequest request;

    public OMethod() {}

    public String name() {
        return this.name;
    }
    public OMethod name(String name) {
        this.name = name;
        return this;
    }

    public String summary() {
        return this.summary;
    }
    public OMethod summary(String summary) {
        this.summary = summary;
        return this;
    }

    public String description() {
        return this.description;
    }
    public OMethod description(String description) {
        this.description = description;
        return this;
    }

    public List<OParameter> parameters() {
        return this.parameters;
    }
    public OMethod parameters(List<OParameter> parameters) {
        this.parameters = parameters;
        return this;
    }
    public OMethod parameter(OParameter parameter) {
        this.parameters.add(parameter);
        return this;
    }

    public List<OResponse> responses() { return this.responses; }
    public OMethod responses(List<OResponse> responses) {
        this.responses = responses;
        return this;
    }
    public OMethod response(OResponse response) {
        this.responses.add(response);
        return this;
    }

    public ORequest request() { return this.request; }
    public OMethod request(ORequest request) {
        this.request = request;
        return this;
    }
}
