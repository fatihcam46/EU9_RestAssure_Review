package BootCampReview;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RequestAndResponse {

    @Test
    public void test1(){

        String base_uri ="http://3.87.65.105:8000/api/spartans";

        Response response = given().accept(ContentType.JSON)
                .when().get(base_uri);

//        response.prettyPrint();
        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.headers().toString());
        System.out.println(response.headers().hasHeaderWithName("Keep-Alive"));
        System.out.println(response.header("Transfer-Encoding"));
    }

    @Test
    public void test2(){

        baseURI = "http://3.87.65.105:8000";

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/20");

        Assertions.assertEquals(200,response.statusCode());
        response.prettyPrint();

    }


}
