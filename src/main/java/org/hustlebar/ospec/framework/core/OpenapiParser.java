package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.hustlebar.ospec.framework.model.OInfo;
import org.hustlebar.ospec.framework.model.OPath;
import org.hustlebar.ospec.framework.model.OServer;
import org.hustlebar.ospec.framework.model.Openapi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class OpenapiParser {
    @Inject
    PathHandler pathHandler;

    @Inject
    ComponentHandler componentHandler;

    public OpenAPI parse(Openapi openapi) {
        return new OpenAPI()
            .info(parseInfo(openapi))
            .servers(parserServers(openapi))
            .paths(pathHandler.handle(openapi))
            .components(componentHandler.handle(openapi));
    }

    private List<Server> parserServers(Openapi openapi) {
        List<OServer> oServers = openapi.servers();
        if (oServers == null || oServers.isEmpty()) {
            return null;
        }

        List<Server> servers = new ArrayList<>(oServers.size());
        for (OServer oServer: oServers) {
            servers.add(getServer(oServer));
        }

        return servers;
    }

    private Server getServer(OServer oServer) {
        return new Server()
            .url(oServer.url())
            .description(oServer.description());
    }

    private Info parseInfo(Openapi openapi) {
        OInfo oInfo = openapi.info();
        return new Info()
            .title(oInfo.title())
            .description(oInfo.description())
            .version(oInfo.version());
    }
}
