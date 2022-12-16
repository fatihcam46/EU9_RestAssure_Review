package BootCampReview;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class HamcrestMathcers extends TestBase {

    @Test
    public void test1() {

        given().accept(ContentType.JSON)
                .when().get("/api/spartans/20")
                .then().statusCode(200)
                .and().body("name", is("Lothario")
                        , "gender", is("Male")
                        , "id", is(greaterThan(10)));
    }

    @Test
    public void test2() {
        List<String> names = given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .extract().jsonPath().getList("name");

        System.out.println(names.size());
        assertThat(names, hasSize(343));
        assertThat(names, hasItem("Lothario"));
        assertThat(names, everyItem(not(nullValue())));
    }
}
