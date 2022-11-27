package week3;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BasicAuth {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.87.65.105:7000";
    }


    // basic auth
    @Test
    public void test1() {
        Response response = given().auth().basic("user","user")
                .accept(ContentType.JSON)
                .when().get("/api/spartans");

        System.out.println("response.statusCode() = " + response.statusCode());
    }

    @Test
    public void test2(){

        String addSpartan = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Watson\",\n" +
                "  \"phone\": 1598563210\n" +
                "}";

        Response response = given().auth().basic("editor","editor")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and().body(addSpartan)
                .when().post("/api/spartans");

        System.out.println("response.statusCode() = " + response.statusCode());
    }

    // 401  --> who are you?
    // 403 --> what can you do?

    @Test
    public void test3(){
        Response response = given().auth().basic("admin","admin")
                .accept(ContentType.JSON)
                .when().delete("/api/spartans/101");

        System.out.println("response.statusCode() = " + response.statusCode());
    }
}
