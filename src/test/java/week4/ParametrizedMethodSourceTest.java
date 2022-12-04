package week4;

import io.restassured.http.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import utilities.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class ParametrizedMethodSourceTest extends SpartanTestBase {

    @ParameterizedTest
    @MethodSource("carBrands") // @ValueSource(strings = {"Honda", "Toyota", "Ford", "Tesla"})
    public void  test1(String name){
        System.out.println("My car is " + name);
    }

    public static List<String> carBrands(){
        List<String> names = Arrays.asList("Honda", "Toyota", "Ford", "Tesla");
        return names;
    }


    public static List<Integer> randomNums() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
        }
        System.out.println(numbers);
        return numbers;
    }

    @ParameterizedTest
    @MethodSource("randomNums")
    public void test2(int id){
        given().accept(ContentType.JSON)
                .and().pathParam("id", id)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200);
    }


}
