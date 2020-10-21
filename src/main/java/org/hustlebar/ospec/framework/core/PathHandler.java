package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.hustlebar.ospec.framework.model.OPath;
import org.hustlebar.ospec.framework.model.Openapi;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PathHandler {
    public Paths handle(Openapi openapi) {
        return getPaths(openapi);
    }

    private Paths getPaths(Openapi openapi) {
        List<OPath> oPaths = openapi.paths();
        if (oPaths == null || oPaths.isEmpty()) {
            return null;
        }

        Paths paths = new Paths();
        for (OPath oPath: oPaths) {
            paths.addPathItem(null, null);
        }

        return paths;
    }

    private PathItem getPathItem(OPath oPath) {
        return null;
    }
}
