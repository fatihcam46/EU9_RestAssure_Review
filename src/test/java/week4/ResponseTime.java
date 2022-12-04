package week4;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utilities.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ResponseTime extends SpartanTestBase {

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then()
                .time( both(greaterThan(500L)).and(lessThan(1500L)))
                .extract().response();

        System.out.println(response.getTime());
    }
}
