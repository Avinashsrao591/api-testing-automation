package com.avinash.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void createUserTest() {

        String requestBody = """
                {
                    "name": "Avinash Rao",
                    "username": "avinash",
                    "email": "avinash@example.com"
                }
                """;

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("https://jsonplaceholder.typicode.com/users");

        System.out.println("Response:");
        System.out.println(response.asPrettyString());

        System.out.println("Status Code: " + response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 201);

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "Avinash Rao"
        );

        Assert.assertEquals(
                response.jsonPath().getString("username"),
                "avinash"
        );
    }
}