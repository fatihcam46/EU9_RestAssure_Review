package week2;

import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class JsonPathMethod {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.87.65.105:8000";
    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/15");

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getInt("id"));
        System.out.println(jsonPath.getString("name"));
        System.out.println(jsonPath.getLong("phone"));
    }

    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getList("id"));
        System.out.println(jsonPath.getList("phone"));

        List<String> genders = jsonPath.getList("gender");
        System.out.println(genders);

        System.out.println(jsonPath.getString("name[4]"));
    }

    @Test
    public void test3(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains","m")
                .when().get("/api/spartans/search");

        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getLong("content.phone[0]"));
    }
}
