package com.restassureddemo.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiPostMethodTest {
    @Test
    public void createUsers(){
        String endpoint = "https://reqres.in/api/users";
        String body = """
                {
                 "email": "ffff@gmail.com",
                 "first_name": "thiromi",
                 "last_name" : "dasanayaka"
                }
                """;
        var response = given().body(body).when().post(endpoint).then();
        response.log().body();
    }
}
