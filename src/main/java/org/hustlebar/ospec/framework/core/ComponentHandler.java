package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.Components;
import org.hustlebar.ospec.framework.model.OComponent;
import org.hustlebar.ospec.framework.model.OSchema;
import org.hustlebar.ospec.framework.model.Openapi;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ComponentHandler {
    public Components handle(Openapi openapi) {
        return _handle(openapi);
    }

    private Components _handle(Openapi openapi) {
        OComponent component = openapi.component();
        if (component == null) {
            return null;
        }

        //handle schemas

        //handle examples

        //handle responses

        //handle parameters

        return null;
    }

    private void _handleSchemas(OComponent component) {
        List<OSchema> schemas = component.schemas();
        if (schemas == null || schemas.isEmpty()) {
            return;
        }

        for (OSchema schema: schemas) {

        }
    }
}
