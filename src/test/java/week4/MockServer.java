package week4;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class MockServer {

    @Test
    public void test1(){
        String url = "https://490b925d-9cd7-4bcb-a23d-5902d876d4e8.mock.pstmn.io";

        Response response = given().accept(ContentType.JSON)
                .when().get(url + "/movies");

        System.out.println(response.statusCode());
        response.prettyPrint();

    }
}
