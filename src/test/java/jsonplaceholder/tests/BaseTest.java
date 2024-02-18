package jsonplaceholder.tests;

import framework.Specifications;
import jsonplaceholder.Asserts;
import jsonplaceholder.helpers.PropertyConfig;

import jsonplaceholder.helpers.PropertyUsers;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected Asserts asserts;

    public BaseTest() {
        this.asserts = new Asserts();
    }

    @BeforeSuite
    public void onStart() {
        PropertyConfig.loadProperties("src/test/java/resources/config.properties");
        PropertyUsers.loadUsersJsonFile("src/test/java/resources/users.json");
        Specifications.baseURI(PropertyConfig.getUrl());
    }
}
