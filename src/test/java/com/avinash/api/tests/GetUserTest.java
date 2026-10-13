package com.avinash.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserTest {

    @Test
    public void getUserTest() {

        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1");

        System.out.println("Response:");
        System.out.println(response.asPrettyString());

        System.out.println("Status Code: " + response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertEquals(response.jsonPath().getInt("id"), 1);

        Assert.assertNotNull(response.jsonPath().getString("name"));
    }
}