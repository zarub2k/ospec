package org.hustlebar.ospec.specs.packages;

import org.hustlebar.ospec.framework.core.OSpecification;
import org.hustlebar.ospec.framework.model.OInfo;
import org.hustlebar.ospec.framework.model.OServer;
import org.hustlebar.ospec.framework.model.Openapi;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ManagePackages implements OSpecification {
    @Override
    public Openapi getOpenapi() {
        return new Openapi()
            .info(getInfo())
            .servers(getServers());
    }

    @Override
    public OInfo getInfo() {
        return new OInfo()
            .title("webMethods API Portal - Manage packages API")
            .description("APIs allows to manage packages in webMethods API Portal")
            .version("10.7");
    }

    @Override
    public List<OServer> getServers() {
        List<OServer> servers = new ArrayList<>();
        servers.add(new OServer().url("api.webmethodscloud.com").description("Access for production"));
        return servers;
    }
}
