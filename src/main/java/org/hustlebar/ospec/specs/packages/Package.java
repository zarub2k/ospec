package org.hustlebar.ospec.specs.packages;

import java.util.List;

public class Package {
    private String id;
    private String name;
    private List<Plan> plans;
    public Package() {}

    public String getId() {
        return id;
    }
    public Package id(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public Package name(String name) {
        this.name = name;
        return this;
    }
}

