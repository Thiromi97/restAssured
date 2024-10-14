package com.restassureddemo.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiGetMethodTest {

    @Test
    public void getCategories(){
        String endpoint = "https://fakestoreapi.com/products";
        var response = given()
                .when().
                    get(endpoint)
                .then()
                .assertThat().
                statusCode(200);
        response.log().body();
    }

    @Test
    public void getprodetails(){
        String endpoint = "https://fakestoreapi.com/products";
        var response = given()
                .when().
                get(endpoint)
                .then()
                .log()
                .body();
//        response.log().body();
    }

    @Test
    public void getProducts(){
        String endpoint = "https://fakestoreapi.com/products/2";
        var response =
                given().
//                        queryParam("id",2).//add query param to the request
                when().
                        get(endpoint).
                then();

        response.log().body();

    }

    @Test
    public void verifyFieldsOfResponse(){
        String endpoint = "https://reqres.in/api/users?page=2";
        var  response = given().when().get(endpoint).then().assertThat()
                .statusCode(200)
                .body("data.size()",equalTo(6))
                .body("data.id",everyItem(notNullValue())) // every id is not null
                .log().body();
    }

    @Test
    public void getTest() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.first_name",hasItems("Michael","Lindsay"))
                .log().body();
    }

    @Test
    public void getTest_7() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then().assertThat()
                .statusCode(200)
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .log().headers();
    }
}
