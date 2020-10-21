package org.hustlebar.ospec.framework.core;

import io.quarkus.test.junit.QuarkusTest;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import org.hustlebar.ospec.framework.core.OpenapiGenerator;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class OpenapiGeneratorTest {
    @Inject
    OpenapiGenerator generator;

    @Test
    public void testGenerate() {
        OpenAPI openAPI = generator.generate(null);
        String yaml = Yaml.pretty(openAPI);
        System.out.println(yaml);
    }
}
