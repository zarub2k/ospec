package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.hustlebar.ospec.framework.model.OMethod;
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
            paths.addPathItem(oPath.ctx(), getPathItem(oPath));
        }

        return paths;
    }

    private PathItem getPathItem(OPath oPath) {
        PathItem pathItem = new PathItem();
        List<OMethod> oMethods = oPath.methods();
        for (OMethod oMethod: oMethods) {
            addMethod(pathItem, oMethod);
        }

        return pathItem;
    }

    private void addMethod(PathItem pathItem, OMethod oMethod) {
        Operation operation = new Operation();
        switch (oMethod.name()) {
            case "get":
                pathItem.get(operation);
                break;

            case "post":
                pathItem.post(operation);
                break;

            case "put":
                pathItem.put(operation);
                break;

            case "delete":
                pathItem.delete(operation);
                break;
        }
    }
}
