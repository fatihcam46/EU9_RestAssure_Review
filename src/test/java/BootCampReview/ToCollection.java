package BootCampReview;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class ToCollection extends TestBase{

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/30");

        response.prettyPrint();

        Map<String, Object> s30 = response.as(Map.class);
        System.out.println(s30);

        System.out.println(s30.get("name"));
    }

    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        List<Map<String, Object>> allSpartans = response.as(List.class);
        response.prettyPrint();
        System.out.println(allSpartans);

    }
}
