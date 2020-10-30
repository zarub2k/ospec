package org.hustlebar.ospec.framework.core;

import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.media.Schema;
import org.hustlebar.ospec.framework.model.OComponent;
import org.hustlebar.ospec.framework.model.OSchema;
import org.hustlebar.ospec.specs.packages.Package;
import org.hustlebar.ospec.specs.packages.PackageList;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SchemaHandlerTest {
    @Test
    public void testHandle() {
        Map<String, Schema> schemaMap = new SchemaHandler()
                .handle(new OComponent()
                    .schema(new OSchema().name("Package").clazz(Package.class))
                    .schema(new OSchema().name("PackageList").clazz(PackageList.class))
                );
        String pretty = Yaml.pretty(schemaMap);
        System.out.println(pretty);
    }
}
