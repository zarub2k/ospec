package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.hustlebar.ospec.framework.model.OMethod;
import org.hustlebar.ospec.framework.model.OParameter;
import org.hustlebar.ospec.framework.model.OPath;
import org.hustlebar.ospec.framework.model.Openapi;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
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

        //handle parameters
        pathItem.parameters(getParameters(oPath));
        return pathItem;
    }

    private List<Parameter> getParameters(OPath oPath) {
        List<OParameter> oParameters = oPath.parameters();
        if (oParameters == null || oParameters.size() == 0) {
            return null;
        }

        List<Parameter> parameters = new ArrayList<>(oParameters.size());
        for (OParameter oParameter: oParameters) {
            parameters.add(
                new Parameter()
                    .name(oParameter.name())
                    .description(oParameter.description())
                    .in(oParameter.mode())
                    .required(oParameter.required())
            );
        }

        return parameters;
    }

    private void addMethod(PathItem pathItem, OMethod oMethod) {
        Operation operation = new Operation()
            .summary(oMethod.summary())
            .description(oMethod.description());
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
