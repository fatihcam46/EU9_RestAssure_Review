package week2;

import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class JsonPathZipCode {

    @BeforeAll
    public static void setUp(){
        baseURI = "https://api.zippopotam.us";
    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/us/90210");

        response.prettyPrint();

        // use jsonpath method, get county name and state name

        JsonPath jsonPath = response.jsonPath();

        // get country name
        System.out.println(jsonPath.getString("country"));

        // get state name
        System.out.println(jsonPath.getString("places[0].state"));

    }


    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/us/ma/belmont");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getDouble("places[0].longitude"));
//        jsonPath.getString(places[0]["place name"])

    }

    @Test
    public void test3(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/us/va/fairfax");

        response.prettyPrint();
    }
}
