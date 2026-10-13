package com.avinash.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUserTest {

    @Test
    public void updateUserTest() {

        String requestBody = """
                {
                    "name": "Avinash Rao Updated",
                    "username": "avinash_updated",
                    "email": "avinash.updated@example.com"
                }
                """;

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://jsonplaceholder.typicode.com/users/1");

        System.out.println("Response:");
        System.out.println(response.asPrettyString());

        System.out.println("Status Code: " + response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "Avinash Rao Updated"
        );

        Assert.assertEquals(
                response.jsonPath().getString("username"),
                "avinash_updated"
        );
    }
}