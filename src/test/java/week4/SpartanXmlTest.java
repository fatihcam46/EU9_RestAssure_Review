package week4;

import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.path.xml.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import utilities.*;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SpartanXmlTest extends SpartanTestBase {

    @DisplayName("Get all spartan xml")
    @Test
    public void test1(){
        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans");

        XmlPath xmlPath = response.xmlPath();

        System.out.println(xmlPath.getString("List.item[0].name"));
        System.out.println(xmlPath.getString("List.item[1].name"));
    }

    @DisplayName("spartan xml assertion test")
    @Test
    public void test2(){
        given().accept(ContentType.XML)
                .when().get("/api/spartans")
                .then()
                .statusCode(200)
                .contentType("application/xml")
                .body("List.item[0].name",is("Tom"))
                .body("List.item[1].name",is("Jerry"));
    }

    @DisplayName("Get all spartan xml name list")
    @Test
    public void test3(){
        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans");

        XmlPath xmlPath = response.xmlPath();

        List<String> names = xmlPath.getList("List.item.name");
        System.out.println(names.size());
        System.out.println(names);

    }


}
