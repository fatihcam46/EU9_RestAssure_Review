package BootCampReview;
//12
import io.restassured.http.*;
import io.restassured.module.jsv.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.io.*;

import static io.restassured.RestAssured.given;

public class SchemaValidator extends TestBase{


    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/9")
                .then().statusCode(200)
                .and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("singleSpartanSchema.json"))
                .extract().response();
//JsonSchemaValidator it is coming from json schema validation dependency
    }
//-----------------------------------------------------------------------
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/9")
                .then().statusCode(200)                      //path paste here    look single SpartanSchema from resources
                .and().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Laptop User\\Desktop\\PROGRAM\\ideaProjects\\EU9_RestAssure_Review\\src\\test\\resources\\singleSpartanSchema.json")))
                .extract().response();
    }
}
