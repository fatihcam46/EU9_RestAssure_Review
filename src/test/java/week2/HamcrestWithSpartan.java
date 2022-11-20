package week2;

import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;


public class HamcrestWithSpartan {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.87.65.105:8000";
    }


    @Test
    public void test1(){
        given().accept(ContentType.JSON)
                .when().get("/api/spartans/15")
                .then()
                .body("id",is(15)
                ,"name",is("Meta")
                ,"gender",equalTo("Female")
                ,"phone",is(1938695106));
    }

    @Test
    public void test2(){
        given().accept(ContentType.JSON)
                .when().get("/api/spartans/20")
                .then()
                .statusCode(200)
                .and()
                .contentType("application/json")
                .and()
                .body("id",is(20)
                        ,"name",is("Lothario")
                        ,"gender",equalTo("Male")
                        ,"phone",is(7551551687L));
    }

    @Test
    public void test3(){
        given().accept(ContentType.JSON)
                .and().queryParam("nameContains","m")
                .when().get("/api/spartans/search")
                .then()
                .and()
                .statusCode(200)
                .and()
                .contentType("application/json")
                .and()
                .body("content[0].name",is("Meade"))
                .body("content[1].gender",is("Male"));
    }

    @Test
    public void test4(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains","m")
                .when().get("/api/spartans/search")
                .then()
                .and()
                .statusCode(200)
                .and()
                .contentType("application/json")
                .and()
                .body("content[0].name",is("Meade"))
                .body("content[1].gender",is("Male"))
                .extract().response();

        response.prettyPrint();

        JsonPath jsonPath = given().accept(ContentType.JSON)
                .and().queryParam("nameContains","m")
                .when().get("/api/spartans/search")
                .then()
                .and()
                .statusCode(200)
                .and()
                .contentType("application/json")
                .and()
                .body("content[0].name",is("Meade"))
                .body("content[1].gender",is("Male"))
                .extract().jsonPath();



    }


}
