package org.hustlebar.ospec.framework.core;

import org.hustlebar.ospec.framework.model.OInfo;
import org.hustlebar.ospec.framework.model.OServer;
import org.hustlebar.ospec.framework.model.Openapi;

import java.util.List;

public interface OSpecification {
    Openapi getOpenapi();
    OInfo getInfo();
    List<OServer> getServers();
}
