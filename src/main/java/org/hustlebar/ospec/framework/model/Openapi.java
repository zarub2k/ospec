package org.hustlebar.ospec.framework.model;

import java.util.ArrayList;
import java.util.List;

public class Openapi {
    private String version;
    private OInfo info;
    private List<OServer> servers = new ArrayList<>();

    public Openapi() {}

    public String version() {
        return this.version;
    }
    public Openapi version(String version) {
        this.version = version;
        return this;
    }

    public OInfo info() {
        return this.info;
    }
    public Openapi info(OInfo info) {
        this.info = info;
        return this;
    }

    public List<OServer> servers() {
        return this.servers;
    }
    public Openapi servers(List<OServer> servers) {
        this.servers = servers;
        return this;
    }
    public Openapi server(OServer server) {
        this.servers.add(server);
        return this;
    }
}
