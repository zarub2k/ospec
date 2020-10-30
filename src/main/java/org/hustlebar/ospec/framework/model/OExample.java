package org.hustlebar.ospec.framework.model;

public class OExample implements IExample<OExample> {
    private String name;

    @Override
    public OExample get() {
        return this;
    }
}
