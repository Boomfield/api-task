package jsonplaceholder.tests;

import framework.BaseTest;
import io.restassured.http.ContentType;
import jsonplaceholder.helpers.PropertyUsers;
import jsonplaceholder.models.User;
import org.apache.http.HttpStatus;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserTests extends BaseTest {
    @Test
    @Parameters({"userId"})
    public void testGetUsers(int userId) {
        List<User> users = given()
                .get("/users")
                .then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.JSON)
                .extract()
                    .jsonPath()
                    .getList("", User.class);

        User user5 = users.get(4);
        softAssert.assertEquals(user5, PropertyUsers.getUserById(userId));
    }

    @Test
    @Parameters({"userId"})
    public void testGetUser5(int userId) {
        User user5 = given()
                .get("/users/" + userId)
                .then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.JSON)
                .extract()
                .response()
                .as(User.class);

        softAssert.assertEquals(user5, PropertyUsers.getUserById(userId));
    }
}
