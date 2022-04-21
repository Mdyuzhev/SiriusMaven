package ru.sirius.api.automation.tests.pets;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sirius.api.automation.configTests.Utils;

import static io.restassured.RestAssured.given;
import static ru.sirius.api.automation.configTests.Endpoints.*;

@DisplayName("Мои автотесты для API")
public class MyTestsMDyuzhev {
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

    String petBody = Utils.getString("src/test/java/ru/sirius/api/automation/models/pet.json");

    @Test
    public void addPet() {
        given()

                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(petBody)
                .post(CREATE_PET)
                .then()
                .assertThat().statusCode(200);
                //.log().all();
    }

    @Test
    public void addPe1t() {
        Utils.postReq(petBody,CREATE_PET,200);
    }



}
