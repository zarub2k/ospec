package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.media.Schema;
import org.hustlebar.ospec.framework.model.OComponent;
import org.hustlebar.ospec.framework.model.OSchema;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class SchemaHandler {
    public Map<String, Schema> handle(OComponent oComponent) {
        return _handleSchema(oComponent);
    }

    private Map<String, Schema> _handleSchema(OComponent oComponent) {
        List<OSchema> oSchemas = oComponent.schemas();
        if (oSchemas == null || oSchemas.isEmpty()) {
            return null;
        }

        return getSchemas(oSchemas);
    }

    private Map<String, Schema> getSchemas(List<OSchema> oSchemas) {
        Map<String, Schema> schemas = new HashMap<>();
        for (OSchema oSchema: oSchemas) {
            schemas.put(oSchema.name(), getSchema(oSchema));
        }

        return schemas;
    }

    private Schema getSchema(OSchema oSchema) {
        return new Schema()
            .type("object");
    }
}
