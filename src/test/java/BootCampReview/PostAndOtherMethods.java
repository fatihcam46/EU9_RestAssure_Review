package BootCampReview;
//8
import BootCampReview.PojoClasses.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PostAndOtherMethods extends TestBase {

    /*
    post a new spartan, we need body
    we have 3 ways to provide that body
    1. string
    2, map
    3. object
     */


    // 1st way: body in string    POST a new spartan
    @Test
    public void test1(){
        String newSpartan = "{\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"name\": \"Zeynep\",\n" +
                "  \"phone\": 12365547895\n" +
                "}";

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)//.and().contentType(ContentType.JSON) we need to add
                .and().body(newSpartan)
                .when().post("/api/spartans");

        System.out.println(response.statusCode());//201
    }
//------------------------------------------------------------------------
    // 2nd way: body in map
    @Test
    public void test2(){
        Map<String, Object> newSpartan = new HashMap<>();//create map object
        newSpartan.put("name","Zeynep");  //write one by one
        newSpartan.put("gender","Female");
        newSpartan.put("phone",12365547895L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(newSpartan)
                .when().post("/api/spartans");

        System.out.println(response.statusCode());//201
        response.prettyPrint();
        /*
        {
    "success": "A Spartan is Born!",
    "data": {
        "id": 526,
        "name": "Zeynep",
        "gender": "Female",
        "phone": 12365547895
    }
}
         */
    }
//------------------------------------------------------------------
    // 3rd way: body in custom class object
    @Test
    public void test3(){
        SingleSpartan newSpartan = new SingleSpartan();
        newSpartan.setGender("Female");             //.setGender
        newSpartan.setName("Zeynep");               //setName
        newSpartan.setPhone(12365547895L);              //setPhone

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(newSpartan)
                .when().post("/api/spartans");   //delete format>>   .when().delete(/api/spartan{id} )

        System.out.println(response.statusCode());//201
        response.prettyPrint();
        /*
        {
    "success": "A Spartan is Born!",
    "data": {
        "id": 527,
        "name": "Zeynep",
        "gender": "Female",
        "phone": 12365547895
    }
}
         */
    }
//-----------------------------------------------------------------------
    // patch body in class object   PATCH
    @Test
    public void test4(){
        Patch newSpartan = new Patch();              //Patch class look from PojoClasses
        newSpartan.setPhone(12365547895L);   //I am changing just phone :

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(newSpartan)
                .when().patch("/api/spartans/407");

        System.out.println(response.statusCode());//204
    }


}
