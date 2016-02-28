package ru.demi.app.resourceServer;

import ru.demi.app.resources.TestResource;

public interface ResourceServer {

    TestResource getTestResource();

    void setTestResource(TestResource testResource);

    String getName();

    int getAge();
}
