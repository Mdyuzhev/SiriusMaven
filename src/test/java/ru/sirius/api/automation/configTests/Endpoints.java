package ru.sirius.api.automation.configTests;

public interface Endpoints {

    String BASE_URI = "http://petstore.swagger.io/v2/pet";
    String STATUS_AVAILABLE = "/findByStatus?status=available";
    String CREATE_PET = "https://petstore.swagger.io/v2/pet";
    String STATUS_SOLD = "/findByStatus?status=sold";
    String STATUS_PENDING = "/findByStatus?status=pending";

    String bodyPet = "\"src/test/java/ru/sirius/api/automation/models/pet.json\"";





}
