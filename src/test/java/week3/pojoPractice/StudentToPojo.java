package week3.pojoPractice;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class StudentToPojo {

    @BeforeAll
    public static void setUp(){
        baseURI = "https://api.training.cydeo.com";
    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id",15)
                .when().get("/student/{id}");

        System.out.println(response.statusCode());

        Student student15 = response.as(Student.class);
        System.out.println(student15);
//        System.out.println(student15.getFirstName());
    }
}
