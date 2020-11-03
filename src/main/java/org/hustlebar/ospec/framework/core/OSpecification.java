package org.hustlebar.ospec.framework.core;

import org.hustlebar.ospec.framework.model.*;

import java.util.List;

public interface OSpecification {
    Openapi getOpenapi();
    OInfo getInfo();
    List<OServer> getServers();
    OComponent getComponent();
    List<OPath> getPaths();
}
