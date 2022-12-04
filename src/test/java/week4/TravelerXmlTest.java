package week4;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TravelerXmlTest {

    @DisplayName("Traveler xml Test")
    @Test
    public void test1(){
        Response response = given().accept(ContentType.XML)
                .when().get("http://restapi.adequateshop.com/api/Traveler")
                .then().statusCode(200)
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",is("Developer"))
                .extract().response();

//        System.out.println(response.statusCode());
//        response.prettyPrint();

    }

    @DisplayName("Get one traveler test")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.XML)
                .when().get("http://restapi.adequateshop.com/api/Traveler/11134")
                .then().statusCode(200)
                .body("Travelerinformation.name",is("AS"))
                .body("Travelerinformation.email",is("qweqw@mail.ru"))
                .extract().response();

        response.prettyPrint();
    }
}
