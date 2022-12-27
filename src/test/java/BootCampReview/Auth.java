package BootCampReview;
//10
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.awt.image.*;

import static io.restassured.RestAssured.given;

public class Auth {

//auth().basic
    @Test
    public void test1(){
        String url = "http://3.87.65.105:7000";

        Response response = given().accept(ContentType.JSON)
                .and().auth().basic("user","user")  //.and().auth().basic("user","user") without this 401 status code
                .when().get(url + "/api/spartans");

        System.out.println(response.statusCode());//200
    }
//----------------------------bearer token use------------------------------------------------------------
    @Test
    public void test2(){

        String token = " Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjMyIiwiYXVkIjoic3R1ZGVudC10ZWFtLW1lbWJlciJ9.707Ay2oDj1faPC3-ElIbC0TzYlndsaMDjT_SQtm9DZM";
        Response response = given().accept(ContentType.JSON)
                .and().header("Authorization",token)  //header   not query param
                .when().get("http://api.qa2.bookit.cydeo.com/api/campuses");

        System.out.println(response.statusCode());//200
    }
}
