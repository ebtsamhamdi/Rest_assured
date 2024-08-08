
package com.app;



import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestNew {


    @Test
    public void Test1(){
        given().baseUri("https://66b32df67fba54a5b7ebc8da.mockapi.io")
                .when().get("/api/v1/users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name",equalTo("Amos Wyman"),"name",hasItems("Jerald Aufderhar","Hugh Witting"));
    }

    @Test
    public void Test2(){
        String name= given().baseUri("https://66b32df67fba54a5b7ebc8da.mockapi.io")
                .when().get("/api/v1/users")
                .then().extract().response().path("[0].name");
        System.out.println(name);
    }

    @Test
    public void Test3(){
        given().baseUri("https://66b32df67fba54a5b7ebc8da.mockapi.io")
                .when().get("/api/v1/users")
                .then().log().ifValidationFails()
                .body("name",equalTo("Khaled"));
    }
}