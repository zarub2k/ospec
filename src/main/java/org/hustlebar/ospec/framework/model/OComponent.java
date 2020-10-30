package org.hustlebar.ospec.framework.model;

import java.util.ArrayList;
import java.util.List;

public class OComponent {
    private List<OSchema> schemas = new ArrayList<>();
    private List<OExample> examples = new ArrayList<>();
    private List<CResponse> responses = new ArrayList<>();

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

    public List<OExample> examples() {
        return this.examples;
    }
    public OComponent examples(List<OExample> examples) {
        this.examples = examples;
        return this;
    }
    public OComponent example(OExample example) {
        this.examples.add(example);
        return this;
    }

    public List<CResponse> responses() {
        return this.responses;
    }
    public OComponent responses(List<CResponse> responses) {
        this.responses = responses;
        return this;
    }
    public OComponent response(CResponse response) {
        this.responses.add(response);
        return this;
    }
}
