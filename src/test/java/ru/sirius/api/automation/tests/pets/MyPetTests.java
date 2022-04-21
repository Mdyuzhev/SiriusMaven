package ru.sirius.api.automation.tests.pets;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static ru.sirius.api.automation.configTests.Endpoints.*;
import org.junit.jupiter.api.DisplayName;
import ru.sirius.api.automation.configTests.Utils;

@DisplayName("Мои тесты")
public class MyPetTests {
    @Test
    public void getPetByStatusAvailable() {
        given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .get(STATUS_AVAILABLE)
                .then()
                .assertThat().statusCode(200);

    }

    @Test
    public void getStatusSold(){
        Utils.getReq("sold");
    }

    @Test
    public void getStatusPending(){
        Utils.getReq("pending");
    }

    String petBody = Utils.getString("src/test/java/ru/sirius/api/automation/models/pet.json");
    @Test
    public void addPet() {
        given()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(petBody)
                .post(CREATE_PET)
                .then()
                .assertThat().statusCode(200)
                .log().all();

        String id = given()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(petBody)
                .post(CREATE_PET)
                .then().extract().jsonPath().get("id").toString();
        System.out.println(id);
    }
}
