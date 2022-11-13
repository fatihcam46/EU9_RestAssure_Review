package week1;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;

public class PathMethod {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://54.167.52.69:8000/api/spartans";
    }

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/10");

//        System.out.println("response.statusCode() = " + response.statusCode());
//        response.prettyPrint();

        System.out.println(response.path("id").toString());
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

        int id = response.path("id");
        String name = response.path("name").toString();
        String gender = response.path("gender").toString();
        Long phone = response.path("phone");

        Assertions.assertEquals(id,10);
        Assertions.assertEquals(gender,"Female");
    }

}
