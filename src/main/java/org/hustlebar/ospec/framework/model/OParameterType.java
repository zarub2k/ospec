package org.hustlebar.ospec.framework.model;

public enum OParameterType {
    Query("query"),
    Header("header"),
    Path("path"),
    Cookie("cookie");

    private final String value;
    OParameterType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
