package BootCampReview;
//11
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

        Response response = given().accept(ContentType.XML)  //XML format lets see
                .when().get("/api/spartans");

        response.prettyPrint();
/*
<List>
  <item>
    <id>1</id>
    <name>Lavonne</name>
    <gender>Male</gender>
.....
 */
        XmlPath xmlPath = response.xmlPath();      //List  under the .item index number name
        System.out.println(xmlPath.getString("List.item[0].name"));//Lavonne
    }
}
