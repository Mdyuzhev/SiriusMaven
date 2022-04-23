package ru.sirius.api.automation.tests.testIt;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static ru.sirius.api.automation.configTests.Endpoints.BASE_URI;

public class TestIt {



    public static String getBtoken() {
        String login = "{\n" +
                "    \"password\": \"Qwerty123\",\n" +
                "\"providerId\": \"4d0ecd8d-f650-4a0e-8f99-38d7f8c5c3da\",\n" +
                "\"username\": \"admin\"\n" +
                "}";

        return given()
                .contentType(ContentType.JSON)
                .body(login)
                .post("http://localhost:80/api/account/login")
                .then().extract().body().path("access_token").toString();


    }

    public static void main(String[] args) {
        System.out.println(getBtoken());
    }



    @Test
    public void getTokenTestIt() {
        String login = "{\n" +
                "    \"password\": \"Qwerty123\",\n" +
                "\"providerId\": \"4d0ecd8d-f650-4a0e-8f99-38d7f8c5c3da\",\n" +
                "\"username\": \"admin\"\n" +
                "}";
        given()
                .contentType(ContentType.JSON)
                .body(login)
                .post("http://localhost:80/api/account/login")
                .then()
                .assertThat().statusCode(200)
                .log().all();

    }

    @Test
    public void addNewProject() {
        System.out.println(getBtoken());
        String login = "{\n" +
                "  \"description\": \"Проект для маленьких тестеров\",\n" +
                "  \"name\": \"Проект из идеи\"\n" +
                "}";
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + getBtoken())
                .body(login)
                .post("http://127.0.0.1/api/v2/projects")
                .then()
                .assertThat().statusCode(409)
                .log().all();
    }
}
