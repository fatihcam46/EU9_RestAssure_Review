package week3;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.awt.geom.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutPatchDelete {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.87.65.105:8000";
    }


    // put
    @Test
    public void test1(){

        String updateSpartan = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Watson\",\n" +
                "  \"phone\": 1598563210\n" +
                "}";
        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(updateSpartan)
                .when().put("/api/spartans/100");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    // patch

    @Test
    public void test2(){
        String partialUpdate = "{\"name\":\"Oscar\"}";

        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(partialUpdate)
                .when().patch("/api/spartans/100");

        System.out.println(response.statusCode());
    }

    // delete
    @Test
    public void test3(){
        Response response = given().accept(ContentType.JSON)
                .when().delete("/api/spartans/120");

        System.out.println(response.statusCode());
    }
}
