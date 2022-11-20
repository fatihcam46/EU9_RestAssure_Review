package week2;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ResponseToMap {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.87.65.105:8000";
    }


    @Test
    public void test1(){
        Response response =  given().accept(ContentType.JSON)
                .when().get("/api/spartans/15");

        Map<String,Object> spartan15 = response.as(Map.class);

        System.out.println(spartan15.get("name"));
        System.out.println(spartan15.get("phone"));


    }

    @Test
    public void test2(){
        Response response =  given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        List<Map<String,Object>> allSpartans = response.as(List.class);
        System.out.println(allSpartans);
    }

    @Test
    public void test3(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains","m")
                .when().get("/api/spartans/search");

        Map<String,Object> allSpartans = response.as(Map.class);
        System.out.println(allSpartans);

        Map<Object,Object> allSpartans1 = response.as(Map.class);
        System.out.println(allSpartans1);


    }


}
