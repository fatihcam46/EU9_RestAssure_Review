package week3;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import week2.pojo.Spartan;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostMethod {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.87.65.105:8000";
    }


    /*
    provide request body in 3 ways
    String
    Map
    POJO
     */


    // string
    @Test
    public void test1(){

        String addSpartan = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Watson\",\n" +
                "  \"phone\": 1598563210\n" +
                "}";

        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(addSpartan)
                .when().post("/api/spartans");

        System.out.println(response.statusCode()); // 201
        response.prettyPrint();
    }

    // map
    @Test
    public void test2(){
        Map<String, Object> addSpartanMap = new HashMap<>();
        addSpartanMap.put("gender","Female");
        addSpartanMap.put("name","Ayse");
        addSpartanMap.put("phone",8527419639L);

        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and().body(addSpartanMap)
                .when().post("/api/spartans");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    // pojo object
    @Test
    public void test3(){
        Spartan addSpartanPojo = new Spartan();
        addSpartanPojo.setName("Jamal");
        addSpartanPojo.setGender("Male");
        addSpartanPojo.setPhone(1478523698L);

        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and().body(addSpartanPojo)
                .when().post("/api/spartans");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

}
