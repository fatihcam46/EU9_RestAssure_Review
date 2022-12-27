package BootCampReview;
//2
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class HamcrestMathcers extends TestBase {   //extends TestBase : taking URI from TestBase
//some kind of assertion tool>> it is easy method>>
    @Test
    public void test1() {
//we don't have to write separately  assertion method>>
        given().accept(ContentType.JSON)
                .when().get("/api/spartans/20")
                //validation part: starts then()
                .then().statusCode(200)
                .and().body("name", is("Lothario")   //is()  is coming from Hamcrest matchers
                        , "gender", is("Male")
                        , "id", is(greaterThan(10)));//, "id", is(greaterThan(10)));  you can add
        //.extract().response();   you can use

    }

    @Test
    public void test2() {
        List<String> names = given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .extract().jsonPath().getList("name");
        //.extract()  this list is a lot of names::list method::
// we can assert that>>>
        System.out.println(names.size());//433
      //  assertThat(names, hasSize(343));  //false --error   //hasSize()
        assertThat(names, hasItem("Lothario"));//true            hasItem()
        assertThat(names, everyItem(not(nullValue())));//true
    }
}
