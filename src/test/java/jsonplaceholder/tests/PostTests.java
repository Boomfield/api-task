package jsonplaceholder.tests;

import framework.BaseTest;
import framework.CommonFunctions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jsonplaceholder.models.UserData;
import org.apache.http.HttpStatus;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostTests extends BaseTest {
    @Test
    public void testAllPosts() {
        Response response = given()
                .get("/posts")
                .then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.JSON)
                .extract()
                .response();

        asserts.verifyIdsAscendingOrder(response.jsonPath().getList("", UserData.class));
    }

    @Test
    @Parameters({"userId", "postId"})
    public void testGetValidPost(int userId, int postId) {
        Response response = given()
                .get("/posts/" + postId)
                .then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        UserData userData = response.as(UserData.class);

        softAssert.assertEquals(userData.getUserId(), userId);
        softAssert.assertEquals(userData.getId(), postId);
        softAssert.assertFalse(userData.getTitle().isEmpty());
        softAssert.assertFalse(userData.getBody().isEmpty());
    }

    @Test
    @Parameters({"postId"})
    public void testGetNonExistentPost(int postId) {
        given()
                .get("/posts/" + postId)
                .then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_NOT_FOUND)
                .body(equalTo("{}"));
    }

    @Test
    @Parameters({"userId"})
    public void testCreatePost(int userId) {
        String title = CommonFunctions.generateRandomString();
        String body = CommonFunctions.generateRandomString();

        UserData user = new UserData(userId, title, body);
        Response response = given()
                    .contentType(ContentType.JSON)
                    .body(user)
                .when()
                    .post("/posts")
                .then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body(notNullValue())
                .extract()
                .response();

        UserData userData = response.as(UserData.class);

        softAssert.assertEquals(userData.getTitle(), title);
        softAssert.assertEquals(userData.getBody(), body);
        softAssert.assertEquals(userData.getUserId(), userId);
        softAssert.assertNotNull(userData.getId());
    }
}
