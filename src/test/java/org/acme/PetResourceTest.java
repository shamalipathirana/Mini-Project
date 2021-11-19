package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class PetResourceTest {
    //Test case for get all pets
    @Test
    public void testPetViewEndpoint(){
        given()
                .when().get("data/pets")
                .then()
                .statusCode(200);
    }
    //Test case for add pet
    @Test
    public void testPetAddEndpoint(){
        given()
                .header("Content-Type","application/json")
                .body("{\r\n    \"name\":\"Tilly\",\r\n  \"age\":2,\r\n   \"type\":\"Cat\"\r\n}")
                .when().post("data/pets/add")
                .then()
                .statusCode(200)
                .body("petId",notNullValue())
                .body("petAge",equalTo(8))
                .body("petName",equalTo("Tilly"))
                .body("petType",equalTo("Cat"));
    }

    @Test
    public void testPetAddEndpointUnsuccess(){
        given()
                .header("Content-Type","application/json")
                .body("{\r\n    \"name\":\"Tilly\",\r\n  \"type\":\"Cat\"\r\n}")
                .when().post("data/pets/add")
                .then()
                .statusCode(200)
                .body("successful",equalTo(false));
    }

    @Test
    public void testPetUpdateEndpoint(){
        given()
                .header("Content-Type","application/json")
                .pathParam("petId",1)
                .body("{\n \"name\":\"Poppy\"\n }")
                .when().put("data/pets/edit/{petId}")
                .then()
                .statusCode(200)
                .body("petId",equalTo(1))
                .body("petAge",notNullValue())
                .body("petName",equalTo("Poppy"))
                .body("petType",notNullValue());
    }

    @Test
    public void testPetDeleteEndpoint(){
        given()
                .header("Content-Type","application/json")
                .pathParam("petId",1)
                .when().delete("data/pets/delete/{petId}")
                .then()
                .statusCode(200)
                .body("successful",equalTo(true));
    }
}
