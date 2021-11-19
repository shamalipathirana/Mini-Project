package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class PetTypeResourceTest {

    @Test
    public void testPetTypesViewEndpoint(){
        given()
                .when().get("data/pettypes")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPetTypesAddEndpoint(){
        given()
                .header("Content-Type","application/json")
                .body("{\r\n    \"petType\":\"Fish\",\r\n  \"petsQuantity\":8,\r\n }")
                .when().post("data/pettypes/add")
                .then()
                .statusCode(200)
                .body("petTypeId",notNullValue())
                .body("petType",equalTo("Fish"))
                .body("petsQuantity",equalTo(8));
    }

    @Test
    public void testPetTypeAddEndpointUnsuccess(){
        given()
                .header("Content-Type","application/json")
                .body("{\r\n  \"petsQuantity\":8,\r\n }")
                .when().post("data/pettypes/add")
                .then()
                .statusCode(200)
                .body("successful",equalTo(false));
    }

    @Test
    public void testPetTypeUpdateEndpoint(){
        given()
                .header("Content-Type","application/json")
                .pathParam("petTypeId",1)
                .body("{\n \"petsQuantity\":5\n }")
                .when().put("data/pettypes/edit/{petTypeId}")
                .then()
                .statusCode(200)
                .body("petTypeId",equalTo(1))
                .body("petsQuantity",equalTo(5))
                .body("petType",notNullValue());
    }

    @Test
    public void testPetTypeDeleteEndpoint(){
        given()
                .header("Content-Type","application/json")
                .pathParam("petTypeId",2)
                .when().delete("data/pettypes/delete/{petTypeId}")
                .then()
                .statusCode(200)
                .body("successful",equalTo(true));
    }
}

