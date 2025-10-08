package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;

public class RequestSteps {
    private Request request;
    private Response response;
    private java.util.Map<String, String> testData;

    @Given("product details")
    public void product_details(io.cucumber.datatable.DataTable dataTable) {
        testData = dataTable.asMap(String.class, String.class);
        request = new Request();
        request.setName(testData.get("name"));
        Request.Data data = new Request.Data();
        data.setYear(Integer.parseInt(testData.get("year")));
        data.setPrice(Double.parseDouble(testData.get("price")));
        data.setCpu_model(testData.get("cpu"));
        data.setHard_disk_size(testData.get("disk"));
        request.setData(data);
    }

    @When("post the details to {string}")
    public void post_the_details(String url) {
        response = given()
            .contentType("application/json")
            .body(request)
            .when()
            .post(url.equals("base.url") ? ConfigReader.getProperty("base.url") : url);
    }

    @Then("validate the response")
    public void validate_the_response() {
        assertEquals(response.getStatusCode(), 200);
        response.then()
            .body("id", notNullValue())
            .body("name", equalTo(testData.get("name")))
            .body("data.year", equalTo(Integer.parseInt(testData.get("year"))))
            .body("data.price", equalTo(Float.parseFloat(testData.get("price"))))
            .body("data.cpu_model", equalTo(testData.get("cpu")))
            .body("data.hard_disk_size", equalTo(testData.get("disk")))
            .body("createdAt", notNullValue());
    }

    @Then("validate error response")
    public void validate_error_response() {
        assertEquals(response.getStatusCode(), 400);
    }
}