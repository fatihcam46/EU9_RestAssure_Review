package utilities;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;

public abstract class SpartanAuthTestBase {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://3.87.65.105:7000";

    }
}
