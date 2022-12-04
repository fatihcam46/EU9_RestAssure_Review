package week4;

import org.junit.jupiter.api.*;

public class Junit5Intro {

    @BeforeAll
    public static void first(){
        System.out.println("Run one time before everything");
    }

    @AfterAll
    public static void last(){
        System.out.println("Run one time after everything");

    }

    @BeforeEach
    public void beforeEveryTest(){
        System.out.println("Run one time before every test");

    }

    @AfterEach
    public void afterEveryTest(){
        System.out.println("Run one time after every test");

    }

    @Test
    public void test1(){
        System.out.println("This is test 1");
    }

    @Disabled
    @Test
    public void test2(){
        System.out.println("This is test 2");

    }


}
