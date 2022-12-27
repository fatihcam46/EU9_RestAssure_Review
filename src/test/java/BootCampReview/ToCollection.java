package BootCampReview;
//4
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class ToCollection extends TestBase{

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/30");

        response.prettyPrint();
/*    response:
{
    "id": 30,
    "name": "Melania",
    "gender": "Female",
    "phone": 8916944276
}                   lets write map class>>>
 */
        Map<String, Object> s30 = response.as(Map.class);
        System.out.println(s30);//{id=30, name=Melania, gender=Female, phone=8916944276}

        System.out.println(s30.get("name"));//Melania
    }
//-------------------------------------------------
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        response.prettyPrint();
 /*
 [
    {
        "id": 1,
        "name": "Lavonne",
        "gender": "Male",.....
  */
        List<Map<String, Object>> allSpartans = response.as(List.class);
        System.out.println(allSpartans);
        //[{id=1, name=Lavonne, gender=Male, phone=1236547892},....

    }
}
