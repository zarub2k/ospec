package org.hustlebar.ospec.framework.model;

public class OParameter {
    private String name;
    private String description;
    private String mode;
    private boolean required;

    public OParameter() {}

    public String name() {
        return this.name;
    }
    public OParameter name(String name) {
        this.name = name;
        return this;
    }

    public String description() {
        return this.description;
    }
    public OParameter description(String description) {
        this.description = description;
        return this;
    }

    public String mode() {
        return this.mode;
    }
    public OParameter mode(String mode) {
        this.mode = mode;
        return this;
    }

    public boolean required() {
        return this.required;
    }
    public OParameter required(boolean required) {
        this.required = required;
        return this;
    }
}
