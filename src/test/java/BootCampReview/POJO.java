package BootCampReview;
//5   //serialization  deserialization
import BootCampReview.PojoClasses.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class POJO extends TestBase {

    // json --> java object   deserialization
    // java object --> json   serialization
//json --> java object   deserialization    example
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/50");

        response.prettyPrint();
/*  response
{
    "id": 50,
    "name": "Jennica",
    "gender": "Female",
    "phone": 6986436734
}
 */
        Map<String, Object> s50 = response.as(Map.class);
        SingleSpartan sp50 = response.as(SingleSpartan.class);   //look SingleSpartan class from POJOClasses

        System.out.println(sp50);//SingleSpartan{id=50, name='Jennica', gender='Female', phone=6986436734}
    }
//-----------------------------------------------
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender","Male")
                .when().get("/api/spartans/search");

        response.prettyPrint();
/*
{
    "content": [
        {
            "id": 1,
            "name": "Lavonne",
...
 */
        SearchClass maleSpartans = response.as(SearchClass.class);////look SearchClass class from POJOClasses
        System.out.println(maleSpartans);
        //SearchClass(content=[SingleSpartan{id=1, name='Lavonne', gender='Male',....
    }
}
