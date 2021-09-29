package ru.sirius.api.automation.tests.pets;


import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static ru.sirius.api.automation.configTests.Endpoints.BASE_URI;


@DisplayName("API для работы с заказами /api/orders")
public class PetTests {

    @Test
    public void getPetByStatusAvailable() {
        given()

                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .get("/findByStatus?status=available")
                .then()
                .assertThat().statusCode(200)
                .log().all();
    }

    @Test
    public void getPetByStatusSold() {
        given()

                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .get("/findByStatus?status=sold")
                .then()
                .assertThat().statusCode(200)
                .log().all();
    }

    @Test
    public void getPetByStatusSoldWithoutLog() {
        given()

                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .get("/findByStatus?status=sold")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void getPetByStatusSoldWithoutLogSirius() {
        given()

                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .get("/findByStatus?status=potercheno")
                .then()
                .assertThat().statusCode(200)
                .log().all();
    }

    @Test
    public void getPetByStatusSoldWithoutLogSirius1() {
        given()

                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .get("/findByStatus?status=potercheno1")
                .then()
                .assertThat().statusCode(200)
                .log().all();
    }

}
