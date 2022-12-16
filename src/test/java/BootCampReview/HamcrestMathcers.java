package BootCampReview;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class HamcrestMathcers extends TestBase {

    @Test
    public void test1() {

        given().accept(ContentType.JSON)
                .when().get("/api/spartans/20")
                .then().statusCode(200)
                .and().body("name", is("Lothario")
                        , "gender", is("Male"));

    }
}
