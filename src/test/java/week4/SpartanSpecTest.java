package week4;

import io.restassured.http.*;
import io.restassured.response.*;
import io.restassured.specification.*;
import org.junit.jupiter.api.*;
import utilities.*;

import static io.restassured.RestAssured.given;

public class SpartanSpecTest extends SpartanAuthTestBase {

    public RequestSpecification reqspec = given().accept(ContentType.JSON)
            .and().auth().basic("admin","admin");

    public ResponseSpecification resSpec = reqspec.expect().statusCode(200);

    @Test
    public void test1(){
        given().spec(reqspec)
                .when().get("api/spartans")
                .then().spec(resSpec);




    }
}
