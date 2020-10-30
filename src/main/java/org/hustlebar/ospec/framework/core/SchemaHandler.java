package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.media.*;
import org.hustlebar.ospec.framework.model.OComponent;
import org.hustlebar.ospec.framework.model.OSchema;

import javax.enterprise.context.ApplicationScoped;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class SchemaHandler {
    public static final String SchemaBase = "#/components/schemas/";

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
            .type("object")
            .properties(getProperties(oSchema));
    }

    private Map<String, Schema> getProperties(OSchema oSchema) {
        Class clazz = oSchema.clazz();
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length == 0) {
            return null;
        }

        Map<String, Schema> properties = new HashMap<>();
        for (Field field: fields) {
            addField(properties, field);
        }

        return properties;
    }

    private void addField(Map<String, Schema> properties, Field field) {
        Type type = field.getGenericType();
        Schema schema = getSchema(type);
        if (schema != null) {
            properties.put(field.getName(), schema);
        }
    }

    private Schema getSchema(Type type) {
        Schema schema;
        if (type == String.class) {
            schema = new StringSchema();
        } else if (type == int.class) {
            schema = new IntegerSchema();
        } else if (type == boolean.class) {
            schema = new BooleanSchema();
        } else if (isList(type)) {
            schema = getListSchema(type);
        } else {
            schema = getCompositeSchema(type);
        }

        return schema;
    }

    private Schema getListSchema(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType)type;
        Type actualType = parameterizedType.getActualTypeArguments()[0];
        Schema schema = getSchema(actualType);

        return new ArraySchema()
                .items(schema);
    }

    private Schema<Object> getCompositeSchema(Type type) {
        String fullName = type.getTypeName();
        String name = fullName.substring(fullName.lastIndexOf(".") + 1);
        return new ObjectSchema().$ref(SchemaBase + name);
    }

    private void getCompositeListSchema(Field field) {

    }

    private boolean isList(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return parameterizedType.getRawType().getTypeName().equals(List.class.getName());
        }

        return false;
//        return type.getClass().getName().equals(List.class.getName());
    }
}
