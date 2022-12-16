package BootCampReview;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        baseURI = "http://3.87.65.105:8000";
    }
}

