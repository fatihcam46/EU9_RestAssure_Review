package week4;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import utilities.*;

import static io.restassured.RestAssured.given;

public class ParametrizedCSVSourceTest extends SpartanTestBase {

    @ParameterizedTest
    @CsvSource({"1,2,1",
            "3,4,81",
            "2,4,16"})
    public void test1(int a, int b, int c){
        Assertions.assertEquals(Math.pow(a,b), c);
    }


    @ParameterizedTest
    @CsvSource({"20,Lothario",
            "21, Mark",
            "22, Koenraad"})
    public void test2(int id, String name){
        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", id)
                .when().get("/api/spartans/{id}");

        Assertions.assertEquals(name,response.path("name"));

    }







}
