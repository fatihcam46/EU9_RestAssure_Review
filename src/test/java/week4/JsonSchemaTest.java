package week4;

import io.restassured.http.*;
import io.restassured.module.jsv.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utilities.*;

import java.io.*;

import static io.restassured.RestAssured.given;

public class JsonSchemaTest extends SpartanTestBase {


    @Test
    public void test1(){
        given().accept(ContentType.JSON)
                .when().get("/api/spartans/1")
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Zulpikar\\IdeaProjects\\EU9_RestAssure_Review\\src\\test\\java\\week4\\singleSpartanSchema.json")));
    }

    @Test
    public void test2(){
        given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("allSpartanSchema.json"));
    }

    @Test
    public void test3(){
        String newSpartan = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Jack\",\n" +
                "  \"phone\": 5269852147\n" +
                "}";

        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and().body(newSpartan)
                .when().post("/api/spartans")
                .then()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("postSpartanSchema.json"));
    }

}
