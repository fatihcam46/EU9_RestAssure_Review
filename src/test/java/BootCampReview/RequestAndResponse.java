package BootCampReview;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
//1
public class RequestAndResponse {

    @BeforeAll
    public static void setUp(){
        baseURI = "http://3.87.65.105:8000";
    };

    @Test
    public void test1(){

        String base_uri ="http://3.87.65.105:8000/api/spartans";

        Response response = given().accept(ContentType.JSON)   //1st we need object.create it
                .when().get(base_uri);
//        response.prettyPrint();  if I run ,I can see all spartan
        System.out.println(response.statusCode());//200
        System.out.println(response.contentType());//application/json
        System.out.println(response.headers().toString());//all headers
        System.out.println(response.headers().hasHeaderWithName("Keep-Alive"));//true
        System.out.println(response.header("Transfer-Encoding"));//chunked
    }
//-----------------------------------------------------------------------------
    @Test
    public void test2(){
//path param method
        baseURI = "http://3.87.65.105:8000";

//        Response response = given().accept(ContentType.JSON)
//                .when().get("/api/spartans/20");

     // providing id number using path param method
        Response response = given().accept(ContentType.JSON)
                        .and().pathParam("id",20)//key and value  : path param
                        .when().get("/api/spartans/{id}");

        Assertions.assertEquals(200,response.statusCode());
        response.prettyPrint();
/*{
    "id": 20,
    "name": "Lothario",
    "gender": "Male",
    "phone": 7551551687
}                        */
        System.out.println(response.body().asString().contains("Lothario"));//true

        //path method
        System.out.println(response.path("name").toString());//Lothario
        //our user story is saying: check name is it Lothario?  so we need  Assertions
        Assertions.assertEquals("Male",response.path("gender"));
    }
//---------------------------------------------------------------------------
    @Test
    public void test3(){
// query param method
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender","Male")
                .when().get("/api/spartans/search");

        System.out.println(response.statusCode());//200
        response.prettyPrint();//all spartans
                                             //we need to add  content[index number]
        System.out.println(response.path("content[0].name").toString());//Lavonne
    }
//--------------------------------------------------------------------
    @Test
    public void test4(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains","da")
                .when().get("/api/spartans/search");
//        response.prettyPrint();//every name include da
//jsonPath method
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getInt("totalElement"));//9

        // json path get list
        List<Map<String, Object>> contents = jsonPath.getList("content");
        System.out.println(contents.get(1).toString());//{id=68, name=Adda, gender=Female, phone=5361981152}

        // json path iterate method                                 iterate(it) all id number:68
        List<String> name = jsonPath.getList("content.findAll {it.id==68}.name");
        System.out.println("name = " + name);//name = [Adda]
    }
//------------------------------------------------------------------------
    // provide params in a map
    @Test
    public void test5(){
//        Response response = given().accept(ContentType.JSON)
//                .and().queryParam("nameContains","b")
//                .and().queryParam("gender","Female")
//                .when().get("/api/spartans/search");
//if we have ten line of parameter:  so that we use map
        Map<String, Object> params = new HashMap<>();
        params.put("nameContains","b");  //contains b
        params.put("gender","Female");   // gender female

        Response response = given().accept(ContentType.JSON)
                .and().queryParams(params)                //queryParams(params)   multiple query param at the same time
                .when().get("/api/spartans/search");
        response.prettyPrint();//printing on the console
    }
}
