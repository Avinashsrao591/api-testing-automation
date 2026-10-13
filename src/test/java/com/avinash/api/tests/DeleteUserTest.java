package com.avinash.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest {

    @Test
    public void deleteUserTest() {

        Response response = RestAssured
                .given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/users/1");

        System.out.println("Status Code: " + response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}