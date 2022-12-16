package BootCampReview;

import BootCampReview.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.path.xml.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class SpartanXml extends TestBase {

    @Test
    public void test1(){

        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans");

        response.prettyPrint();


        XmlPath xmlPath = response.xmlPath();

        System.out.println(xmlPath.getString("List.item[0].name"));
    }
}
