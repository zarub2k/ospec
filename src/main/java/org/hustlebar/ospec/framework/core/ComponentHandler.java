package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.hustlebar.ospec.framework.model.OComponent;
import org.hustlebar.ospec.framework.model.Openapi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;

@ApplicationScoped
public class ComponentHandler {
    @Inject
    SchemaHandler schemaHandler;

    public Components handle(Openapi openapi) {
        return _handle(openapi);
    }

    private Components _handle(Openapi openapi) {
        OComponent oComponent = openapi.component();
        if (oComponent == null) {
            return null;
        }

        return new Components()
            .schemas(getSchemas(oComponent))
            .examples(getExamples(oComponent))
            .responses(getResponses(oComponent))
            .parameters(getParameters(oComponent));
    }

    private Map<String, Parameter> getParameters(OComponent oComponent) {
        return null;
    }

    private Map<String, ApiResponse> getResponses(OComponent oComponent) {
        return null;
    }

    private Map<String, Example> getExamples(OComponent oComponent) {
        return null;
    }

    private Map<String, Schema> getSchemas(OComponent component) {
        return schemaHandler.handle(component);
    }
}
