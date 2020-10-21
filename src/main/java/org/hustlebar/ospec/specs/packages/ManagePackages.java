package org.hustlebar.ospec.specs.packages;

import org.hustlebar.ospec.framework.core.OSpecification;
import org.hustlebar.ospec.framework.model.*;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ManagePackages implements OSpecification {
    @Override
    public Openapi getOpenapi() {
        return new Openapi()
            .info(getInfo())
            .servers(getServers())
            .paths(getPaths());
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

    @Override
    public List<OPath> getPaths() {
        List<OPath> paths = new ArrayList<>();
        paths.add(packages());
        paths.add(packagesWithId());
        return paths;
    }

    private OPath packages() {
        return new OPath()
            .ctx("/packages")
            .method(new OMethod().name("get").summary("Get all the packages available in the system"))
            .method(new OMethod().name("post").summary("Create a package with the given data"));
    }

    private OPath packagesWithId() {
        return new OPath()
            .ctx("/packages/{id}")
            .method(new OMethod().name("get").summary("Get the details of a package by the given id"))
            .method(new OMethod().name("put").summary("Update a package with the given data"))
            .method(new OMethod().name("delete").summary("Delete a package with the given id"));
    }
}
