package com.example;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import java.util.UUID;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

@QuarkusTest
class GreetingResourceTest {

    // These tests use RestAssured, but feel free to use your favorite library.
    // https://rest-assured.io/

    @Test // By using the QuarkusTest runner, you instruct JUnit to start the application before the tests.
    void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200) // Check the HTTP response status code and content
                .body(is("Hello from Quarkus REST"));
    }

    @Test
    public void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
                .pathParam("name", uuid)
                .when().get("/hello/greeting/{name}")
                .then()
                .statusCode(200)
                .body(is("hello " + uuid));
    }
}