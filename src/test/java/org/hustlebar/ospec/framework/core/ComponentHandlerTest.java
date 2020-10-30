package org.hustlebar.ospec.framework.core;

import io.quarkus.test.junit.QuarkusTest;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.Components;
import org.hustlebar.ospec.framework.model.OComponent;
import org.hustlebar.ospec.framework.model.OSchema;
import org.hustlebar.ospec.framework.model.Openapi;
import org.hustlebar.ospec.specs.packages.Package;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ComponentHandlerTest {
    @Inject
    ComponentHandler componentHandler;

    @Test
    public void testHandle() {
        Components components = componentHandler.handle(
                new Openapi()
                        .component(new OComponent().schema(new OSchema().name("Package").clazz(Package.class))));

        String pretty = Yaml.pretty(components);
        System.out.println(pretty);
    }
}
