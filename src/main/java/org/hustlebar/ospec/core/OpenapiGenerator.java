package org.hustlebar.ospec.core;

import io.swagger.v3.oas.models.OpenAPI;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class OpenapiGenerator {
    @Inject
    OpenapiParser openapiParser;
    public OpenAPI generate(Openapi openapi) {
        return openapiParser.parse(openapi);
    }
}
