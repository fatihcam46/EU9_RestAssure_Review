package BootCampReview;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.specification.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;

public class SpectTestBase {

    @BeforeAll
    public static void setUp() {
        baseURI = "http://3.87.65.105:8000";
    }

    public RequestSpecification reqSpec = RestAssured.given().accept(ContentType.JSON)
            .pathParam("id",10);

    public ResponseSpecification resSpec = reqSpec.expect().statusCode(200);
}
