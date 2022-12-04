package week4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class ParametrizedCSVSourceTest {

    @ParameterizedTest
    @CsvSource({"1,2,1",
            "3,4,81",
            "2,4,16"})
    public void test1(int a, int b, int c){
        Assertions.assertEquals(Math.pow(a,b), c);
    }





}
