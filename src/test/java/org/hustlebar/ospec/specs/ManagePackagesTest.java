package org.hustlebar.ospec.specs;

import io.quarkus.test.junit.QuarkusTest;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import org.hustlebar.ospec.framework.core.OpenapiGenerator;
import org.hustlebar.ospec.framework.model.Openapi;
import org.hustlebar.ospec.specs.packages.ManagePackages;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ManagePackagesTest {
    @Inject
    ManagePackages managePackages;

    @Inject
    OpenapiGenerator generator;

    @Test
    public void testOpenapi() {
        Openapi openapi = managePackages.getOpenapi();
        OpenAPI api = generator.generate(openapi);
        String pretty = Yaml.pretty(api);
        System.out.println(pretty);
    }
}
