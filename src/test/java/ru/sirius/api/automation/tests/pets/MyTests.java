package ru.sirius.api.automation.tests.pets;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static ru.sirius.api.automation.configTests.Endpoints.*;

@DisplayName("Мои автотесты для API")
public class MyTests {
    @Test
    public void getPetByStatusAvailable() {
        given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .get(STATUS_AVAILABLE)
                .then()
                .assertThat().statusCode(200);
                //.log().all();
    }

    String pet = "{\n" +
            "  \"id\": 0,\n" +
            "  \"category\": {\n" +
            "    \"id\": 0,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"doggie\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";
    @Test
    public void addPet() {
        given()

                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(pet)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat().statusCode(200)
                .log().all();
    }

}
