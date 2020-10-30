package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.examples.Example;
import org.hustlebar.ospec.framework.model.OComponent;
import org.hustlebar.ospec.framework.model.OExample;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ExampleHandler {
    public Map<String, Example> handle(OComponent oComponent) {
        return _handle(oComponent);
    }

    public Map<String, Example> _handle(OComponent oComponent) {
        List<OExample> oExamples = oComponent.examples();
        if (oExamples == null || oExamples.isEmpty()) {
            return null;
        }

        Map<String, Example> examples = new HashMap<>();
        for (OExample oExample: oExamples) {
            examples.put(oExample.name(), new Example().value(oExample.sample()));
        }

        return examples;
    }
}
