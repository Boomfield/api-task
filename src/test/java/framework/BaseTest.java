package framework;

import jsonplaceholder.Asserts;
import jsonplaceholder.helpers.PropertyConfig;
import jsonplaceholder.helpers.PropertyUsers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected SoftAssert softAssert;
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

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() {
        softAssert.assertAll();
    }
}
