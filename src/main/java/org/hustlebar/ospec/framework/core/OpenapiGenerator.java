package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.OpenAPI;
import org.hustlebar.ospec.framework.model.Openapi;

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
