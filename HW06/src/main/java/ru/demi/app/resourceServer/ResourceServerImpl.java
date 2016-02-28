package ru.demi.app.resourceServer;

import ru.demi.app.resources.TestResource;

public class ResourceServerImpl implements ResourceServer {

    private TestResource testResource;

    public ResourceServerImpl() {}

    @Override
    public TestResource getTestResource() {
        return testResource;
    }

    @Override
    public void setTestResource(TestResource testResource) {
        this.testResource = testResource;
    }

    @Override
    public String getName() {
        return testResource.getName();
    }

    @Override
    public int getAge() {
        return testResource.getAge();
    }
}
