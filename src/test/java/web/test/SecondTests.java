package web.test;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecondTests {

    //https://www.demoblaze.com/

    //https://formy-project.herokuapp.com/

    //api ---https://reqres.in/api-docs/#/default/get_users__id_
    //curl -X 'GET' \
    //  'https://reqres.in/api/users/4' \
    //  -H 'accept: application/json'

    @BeforeAll
    @DisplayName("Before All")
    public static void b_a_test() {
        System.out.println("before all NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    @BeforeEach
    @DisplayName("Before each")
    public void b_e_test() {
        System.out.println("before each XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
    @Test
    @Tag("test1")
    @DisplayName("Test 1")
    public void test1() {
        System.out.println("Test 1 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        step1();
        }

    @Test
    @Tag("test2")
    @DisplayName("Test 2")
    public void test2() {
        System.out.println("Test 2 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        step2();
    }


    @Test
    @Tag("test3")
    @DisplayName("Test 3")
    public void test3() {
        System.out.println("Test 3 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    @Step("My first step")
    public void step1(){
        System.out.println("calling first step ");
        step3();
    }

    @Step("My second step")
    public void step2(){
        System.out.println("calling second step ");
    }

    @Step("My third step")
    public void step3(){
        System.out.println("calling third step ");

    }

    }
