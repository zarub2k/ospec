package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.examples.Example;
import org.hustlebar.ospec.framework.model.OComponent;

import java.util.Map;

public class ExampleHandler {
    public Map<String, Example> handle(OComponent oComponent) {
        return _handle(oComponent);
    }

    public Map<String, Example> _handle(OComponent oComponent) {
        return null;
    }
}
