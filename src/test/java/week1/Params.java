package week1;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

public class Params {

    String SpartanBaseUrl = "http://54.167.52.69:8000/api/spartans";

    @Test
    public void pathParams(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",45)
                .when().get(SpartanBaseUrl + "/{id}");

        System.out.println("response.statusCode() = " + response.statusCode());
    }
}
