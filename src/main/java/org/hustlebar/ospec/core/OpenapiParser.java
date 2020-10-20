package org.hustlebar.ospec.core;

import io.swagger.v3.oas.models.OpenAPI;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OpenapiParser {
    public OpenAPI parse(Openapi openapi) {
        return new OpenAPI();
    }
}
