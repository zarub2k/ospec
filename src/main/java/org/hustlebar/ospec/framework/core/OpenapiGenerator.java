package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.OpenAPI;
import org.hustlebar.ospec.framework.model.Openapi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class OpenapiGenerator {
    @Inject
    OpenapiParser openapiParser;
    public OpenAPI generate(Openapi openapi) {
        return openapiParser.parse(openapi);
    }

//    public OpenAPI get(Class<T> clazz) {
//        Openapi openapi = null;
//        try {
//            OSpecification specification = clazz.newInstance();
//            openapi = new Openapi()
//                    .info(specification.getInfo())
//                    .servers(specification.getServers())
//                    .paths(specification.getPaths())
//                    .component(specification.getComponent());
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        return this.generate(openapi);
//    }
}
