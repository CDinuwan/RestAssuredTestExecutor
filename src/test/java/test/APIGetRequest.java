package test;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.matcher.RestAssuredMatchers.*;
//import org.hamcrest.Matchers.*;
//import io.restassured.module.jsv.JsonSchemaValidator;
//import org.junit.Test;

public class APIGetRequest {

    @Test
    public void getListResources() {
        String endpoint="https://reqres.in/api/users?page=1";
        var response=given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getSingleUser() {
        String endpoint="https://reqres.in/api/users/";
        var response=
                given().
                        queryParam("id",2).when().
                get(endpoint).then();
        response.log().body();
    }

//    @Test
//    public void getpetfindByStatus() {
//        get("https://petstore.swagger.io/v2/pet/findByStatus").then().statusCode(200).assertThat()
//                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petfindByStatus.json"));
//    }
}
