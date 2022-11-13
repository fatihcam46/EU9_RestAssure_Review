package week1;

import io.restassured.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

public class FirstTest {

    String baseUrl = "http://54.167.52.69:8000/api/spartans";

    @Test
    public void test1() {

        Response response = RestAssured.get(baseUrl);



        System.out.println("response.statusCode() = " + response.statusCode());

        response.prettyPeek();

        Assertions.assertEquals(200, response.statusCode());

//        response.prettyPrint();

    }
}
