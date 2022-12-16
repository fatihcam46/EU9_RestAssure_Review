package BootCampReview;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RequestAndResponse {

    @BeforeAll
    public static void setUp(){
        baseURI = "http://3.87.65.105:8000";
    };



    @Test
    public void test1(){

        String base_uri ="http://3.87.65.105:8000/api/spartans";

        Response response = given().accept(ContentType.JSON)
                .when().get(base_uri);

//        response.prettyPrint();
        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.headers().toString());
        System.out.println(response.headers().hasHeaderWithName("Keep-Alive"));
        System.out.println(response.header("Transfer-Encoding"));
    }

    @Test
    public void test2(){

        baseURI = "http://3.87.65.105:8000";

//        Response response = given().accept(ContentType.JSON)
//                .when().get("/api/spartans/20");

        // providing id number using path param method
        Response response = given().accept(ContentType.JSON)
                        .and().pathParam("id",20)
                        .when().get("/api/spartans/{id}");

        Assertions.assertEquals(200,response.statusCode());
        response.prettyPrint();

        System.out.println(response.body().asString().contains("Lothario"));

        //path method
        System.out.println(response.path("name").toString());
        Assertions.assertEquals("Male",response.path("gender"));
    }

    @Test
    public void test3(){
        // qeury param method
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender","Male")
                .when().get("/api/spartans/search");

        System.out.println(response.statusCode());
        response.prettyPrint();

        System.out.println(response.path("content[0].name").toString());
    }

    @Test
    public void test4(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains","da")
                .when().get("/api/spartans/search");

//        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getInt("totalElement"));

        // json path get list
        List<Map<String, Object>> conents = jsonPath.getList("content");
        System.out.println(conents.get(1).toString());

        // json path iterate method
        List<String> name = jsonPath.getList("content.findAll {it.id==68}.name");
        System.out.println("name = " + name);
    }

    // provide params in a map
    @Test
    public void test5(){
//        Response response = given().accept(ContentType.JSON)
//                .and().queryParam("nameContains","b")
//                .and().queryParam("gender","Female")
//                .when().get("/api/spartans/search");

        Map<String, Object> params = new HashMap<>();
        params.put("nameContains","b");
        params.put("gender","Female");

        Response response = given().accept(ContentType.JSON)
                .and().queryParams(params)
                .when().get("/api/spartans/search");

        response.prettyPrint();
    }


}
