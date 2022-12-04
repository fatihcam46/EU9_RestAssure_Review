package week4;

import io.restassured.http.*;
import io.restassured.response.*;
import io.restassured.specification.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import utilities.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class ParametrizedCSVFileSourceTest extends SpartanTestBase {

    @ParameterizedTest
    @CsvFileSource(resources = "/SpartanDataPOST.csv",numLinesToSkip = 1)
    public void test1(String name, String gender, Long phone){
        Map<String, Object> newSpartans = new HashMap<>();
        newSpartans.put("name",name);
        newSpartans.put("gender",gender);
        newSpartans.put("phone",phone);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(newSpartans)
                .when().post("/api/spartans")
                .then().statusCode(201)
                .extract().response();

        Assertions.assertEquals("A Spartan is Born!", response.path("success"));



    }
}
