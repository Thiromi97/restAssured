package com.restassureddemo.test;

import com.restassureddemo.models.Product;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProductTest {
    @Test
    public void createProduct(){
        String endpoint = "https://mocki.io/v1/cebd8c82-dd48-462b-bc0a-d466ac908920";
        Product product = new Product(
                23,
                "Water Bottle",
                "nice for everyday use",
                90.99,
                89,
                "School items"
        );
        var response = given().body(product).when().post(endpoint).then();
        response.log().body();
    }
}
