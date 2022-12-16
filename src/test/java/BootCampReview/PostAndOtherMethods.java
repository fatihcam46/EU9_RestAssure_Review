package BootCampReview;

import BootCampReview.PojoClasses.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PostAndOtherMethods extends TestBase {

    /*
    post a new spartan, we need body
    we have 3 ways to provide that body
    1. stirng
    2, map
    3. object
     */


    // body in string
    @Test
    public void test1(){
        String newSpartan = "{\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"name\": \"Zeynep\",\n" +
                "  \"phone\": 12365547895\n" +
                "}";

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(newSpartan)
                .when().post("/api/spartans");

        System.out.println(response.statusCode());
    }

    // body in map
    @Test
    public void test2(){
        Map<String, Object> newSpartan = new HashMap<>();
        newSpartan.put("name","Zeynep");
        newSpartan.put("gender","Female");
        newSpartan.put("phone",12365547895L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(newSpartan)
                .when().post("/api/spartans");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    // body in custom class object
    @Test
    public void test3(){
        SingleSpartan newSpartan = new SingleSpartan();
        newSpartan.setGender("Female");
        newSpartan.setName("Zeynep");
        newSpartan.setPhone(12365547895L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(newSpartan)
                .when().post("/api/spartans");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    // patch body in class object
    @Test
    public void test4(){
        Patch newSpartan = new Patch();
        newSpartan.setPhone(12365547895L);



        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(newSpartan)
                .when().patch("/api/spartans/407");

        System.out.println(response.statusCode());
    }


}
