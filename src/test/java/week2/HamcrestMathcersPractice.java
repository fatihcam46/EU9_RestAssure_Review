package week2;

import groovy.json.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;



public class HamcrestMathcersPractice {

    @Test
    public void test1(){
        // mathcer
        // hamcrest

        MatcherAssert.assertThat(5,is(5));
//        MatcherAssert.assertThat(5,is(15));
        MatcherAssert.assertThat(String.valueOf(10),equals(10));
        MatcherAssert.assertThat("house",equals("house"));

        System.out.println("house".contains("hou"));
        System.out.println("house".equals("house"));
    }

    @Test
    public void test2(){

        assertThat(15,equalTo(15));
        assertThat(20,is(equalTo(20)));
        assertThat(25,is(not(20)));
        assertThat(25,is(greaterThan(20)));
    }

    @Test
    public void test3(){
        assertThat("this is a text",is("this is a text"));
        assertThat("this is a text",equalTo("this is a text"));
        assertThat("this is a text",is(equalTo("this is a text")));
        assertThat("this is a text",startsWith("this"));
        assertThat("this is a text",endsWith("text"));
        assertThat("this is a text",containsStringIgnoringCase("text"));

    }

    @Test
    public void test4(){
        List<Integer> nums = Arrays.asList(10,20,30,40,50);

        assertThat(nums,hasSize(5));
        assertThat(nums,hasItem(20));
        assertThat(nums,hasItems(10,20));

    }


}
