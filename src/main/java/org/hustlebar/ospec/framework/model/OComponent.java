package org.hustlebar.ospec.framework.model;

import java.util.ArrayList;
import java.util.List;

public class OComponent {
    private List<OSchema> schemas = new ArrayList<>();

    public List<OSchema> schemas() {
        return this.schemas;
    }
    public OComponent schemas(List<OSchema> schemas) {
        this.schemas = schemas;
        return this;
    }
    public OComponent schema(OSchema schema) {
        this.schemas.add(schema);
        return this;
    }
}
