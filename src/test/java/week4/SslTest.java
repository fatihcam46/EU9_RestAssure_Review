package week4;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class SslTest {

    @Test
    public void test1(){
        given().relaxedHTTPSValidation()
                .when().get("https://untrusted-root.badssl.com/").prettyPrint();
    }

    @Test
    public void keyStore(){

        // provide your secury key path, and password
        given()
                .keyStore("pathtofile","password")
                .when().get("https://untrusted-root.badssl.com/");

    }
}
