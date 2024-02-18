package framework;

import io.restassured.RestAssured;

public class Specifications {
    public static void baseURI(String url) {
        RestAssured.baseURI = url;
    }
}
