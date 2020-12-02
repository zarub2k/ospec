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
            .paths(getPaths())
            .component(getComponent());
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
    public OComponent getComponent() {
        return new OComponent()
            .schema(new OSchema().name("Package").clazz(Package.class))
            .schema(new OSchema().name("Plan").clazz(Plan.class))
            .schema(new OSchema().name("PackageList").clazz(PackageList.class))
            .example(new OExample<Package>().name("Package").sample(
                new Package().id("abc").name("Sample package")))
            .response(
                new CResponse().name("400").description("The request was unacceptable, due to invalid payload")
                    .media(new OResponseMedia().media("application/json").schemaRef("Error").exampleName("400").exampleRef("400"))
            );
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
            .method(
                new OMethod().name("get").summary("Get all the packages available in the system")
                    .parameter(new OParameter().name("page").mode(OParameterType.Query.value()).description("Defines the page number for the data").required(false))
                    .response(new OResponse().code(200).description("Packages fetched successfully").ref("PackageList"))
            )
            .method(
                new OMethod().name("post").summary("Create a package with the given data")
                    .request(new ORequest().description("Create package payload").content(new Tuple("application/json", "Package")))
                    .response(new OResponse().code(201).description("Package created successfully").ref("CreatedResponse"))
                    .response(new OResponse().code(400).description("Package payload is not correct").ref("400"))
            );
    }

    private OPath packagesWithId() {
        return new OPath()
            .ctx("/packages/{id}")
            .parameter(new OParameter().name("id").mode(OParameterType.Path.value()).description("Unique identifier of a package").required(true))
            .method(new OMethod().name("get").summary("Get the details of a package by the given id"))
            .method(new OMethod().name("put").summary("Update a package with the given data"))
            .method(new OMethod().name("delete").summary("Delete a package with the given id"));
    }
}
