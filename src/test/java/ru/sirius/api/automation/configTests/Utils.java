package ru.sirius.api.automation.configTests;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static ru.sirius.api.automation.configTests.Endpoints.*;

public class Utils {
    public static String token = Utils.getString("src/test/java/ru/rtkit/crm/b2o/models/token");


    public static String getString(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

   /* public static String getContractUnid(String bodyContract){

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .relaxedHTTPSValidation()
                .when()
                .baseUri(BASE_URI)
                .body(bodyContract)
                .post(CONTRACT_CREATE)
                .then().extract().body().path("fldDocumentUNID").toString();
    }*/



    @Step ("Отправка POST запроса")
    public static ValidatableResponse postReq (String body, String path, int statusCode){

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .relaxedHTTPSValidation()
                .when()
                .baseUri(BASE_URI)
                .body(body)
                .post(path)
                .then().assertThat().statusCode(statusCode).log().all();
    }

    @Step ("Отправка PATCH запроса")
    public static ValidatableResponse patchReq (String body, String path, int statusCode){

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .baseUri(BASE_URI)
                .when()
                .body(body)
                .patch(path)
                .then().assertThat().statusCode(statusCode).log().all();
    }


    @Step
    @DisplayName("Отправка PATCH запроса с невалидным телом запроса")
    public static ValidatableResponse patchReqInvalidBody(String path, int statusCode){

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .baseUri(BASE_URI)
                .when()
                .body("body")
                .patch(path)
                .then().assertThat().statusCode(statusCode).log().all();
    }

    @Step
    @DisplayName("Отправка PATCH запроса с невалидным токеном")
    public static ValidatableResponse patchReqForbidden(String path, int statusCode){

        return given()
                .header("Authorization", "token")
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .baseUri(BASE_URI)
                .when()
                .body("body")
                .patch(path)
                .then().assertThat().statusCode(statusCode).log().all();
    }

    @Step
    @DisplayName("Отправка POST запроса с параметром")
    public static ValidatableResponse postReqWithParam (String paramValue, String body, String path, int statusCode){

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .relaxedHTTPSValidation()
                .when()
                .baseUri(BASE_URI)
                .pathParam("unid", paramValue)
                .body(body)
                .post(path)
                .then().assertThat().statusCode(statusCode);
    }

    @Step
    @DisplayName("Отправка POST запроса с параметром")
    public static ValidatableResponse postReqWithParamWithoutBody (String paramValue, String path, int statusCode){

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .relaxedHTTPSValidation()
                .when()
                .baseUri(BASE_URI)
                .pathParam("unid", paramValue)
                //.body(body)
                .post(path)
                .then().assertThat().statusCode(statusCode);
    }




}
