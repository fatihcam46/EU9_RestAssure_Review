package BootCampReview;

import BootCampReview.PojoClasses.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class POJO extends TestBase {

    // json --> java object   deserilization
    // java object --> json   serilization

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/50");

        response.prettyPrint();

        Map<String, Object> s50 = response.as(Map.class);
        SingleSpartan sp50 = response.as(SingleSpartan.class);

        System.out.println(sp50);
    }

    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender","Male")
                .when().get("/api/spartans/search");

        response.prettyPrint();

        SearchClass maleSpartans = response.as(SearchClass.class);
        System.out.println(maleSpartans);
    }
}
