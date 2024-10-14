package com.restassureddemo.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiDeleteMethodTest {

    @Test
    public void deleteTest(){
        String endpoint = "https://dummyjson.com/products";
        String body = """
                {
                "id" : "30"
                }
                """;
        var  response = given().body(body).when().delete(endpoint).then();
        response.log().body();
    }
}
