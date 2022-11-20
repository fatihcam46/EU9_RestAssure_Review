package week2;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PathMethodReview {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.87.65.105:8000";
    }

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/15");

        System.out.println(response.statusCode());
        response.prettyPrint();

        System.out.println(response.path("phone").toString());
        System.out.println(response.path("name").toString());
    }

    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

//        response.prettyPrint();
        System.out.println(response.path("name").toString());
        System.out.println(response.path("id").toString());

        System.out.println(response.path("name[9]").toString());
    }

    @Test
    public void test3(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains","m")
                .when().get("/api/spartans/search");

//        response.prettyPrint();
        System.out.println(response.path("content.phone[0]").toString());
        List<String> names = response.path("content.name");
    }

}
