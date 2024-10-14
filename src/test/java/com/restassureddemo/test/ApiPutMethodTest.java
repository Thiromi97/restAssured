package com.restassureddemo.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiPutMethodTest {

    @Test
    public void updateUser(){
        String endpoint = "https://reqres.in/api/users/2";
        String body = """
                "id": 2,
                "email": "weaver@reqres.in",
                "first_name": "Janet",
                "last_name": "Weaver",
                "avatar": "https://reqres.in/img/faces/2-image.jpg"
                """;
        var response = given().body(body).when().put(endpoint).then();
        response.log().body();
    }
}
