package week4;

import io.restassured.http.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import utilities.*;

import static io.restassured.RestAssured.given;

public class ParametrizedValueSourceTest extends SpartanTestBase {

    // for integers
    @ParameterizedTest
    @ValueSource(ints = {10,20,30,40,50})
    public void test1(int number){
        System.out.println("number = " + number);
    }

    // for strings
    @ParameterizedTest
    @ValueSource(strings = {"Paris","London","Lizbon"})
    public void test2(String city){
        System.out.println("city name= " + city);
    }

    // get single spartan parametrized test
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void test3(int id){
        System.out.println(given().accept(ContentType.JSON)
                .and().pathParam("id", id)
                .when().get("/api/spartans/{id}")
                .then()
                .extract().response().path("name").toString());
    }

}
