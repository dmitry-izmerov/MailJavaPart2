package ru.demi.app.service;

import ru.demi.app.resources.TestResource;

/**
 * @author demi
 * @date 28.02.16
 */
public class ResourceService {
    TestResource testResource;

    public TestResource getTestResource() {
        return testResource;
    }

    public void setTestResource(TestResource testResource) {
        this.testResource = testResource;
    }
}
