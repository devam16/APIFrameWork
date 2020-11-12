package stepDefinitions;

import static io.restassured.RestAssured.given;
import org.junit.Assert;

import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class commonStepDef extends Utils {

	RequestSpecification req;
	ResponseSpecification resSpec;
	Response res;
	static String pet_id;

	@Given("Add Pet Payload with {string} , {string}")
	public void add_pet_payload(String petName, String status) throws IOException {

		req = given().spec(getRequestSpecification()).body(TestDataBuild.addPetPayload(petName, status));
	}
	@Given("FindPetByStatus payload with status {string}")
	public void find_pet_by_status_payload_with_status(String statusExpected) throws IOException {
		req = given().spec(getRequestSpecification()).queryParam("status", statusExpected);
	}
	@Given("Update Pet Payload of {string} to {string}")
	public void update_pet_payload_of_to(String petName, String status) throws IOException {
		req = given().spec(getRequestSpecification()).body(TestDataBuild.addPetPayload(pet_id,petName, status));
	}
	@Given("Delete Pet Payload")
	public void delete_pet_payload() throws IOException {
		req = given().spec(getRequestSpecification()).header("api_key","special-key").pathParam("pet", pet_id);
	}
	@Given("FindPetByID payload with petID")
	public void find_pet_by_ID_payload_with_pet_ID() throws IOException {
		req = given().spec(getRequestSpecification()).pathParam("id", pet_id);
	}

	@When("User Calls {string} with {string} HTTP request")
	public void user_calls_with_post_http_request(String resource, String httpMethod) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println("The resource Url path : " + resourceAPI.getAPIResource());

		if (httpMethod.equalsIgnoreCase("POST")) {
			res = req.when().post(resourceAPI.getAPIResource());
		} else if (httpMethod.equalsIgnoreCase("GET")) {
			res = req.when().get(resourceAPI.getAPIResource());
		} else if (httpMethod.equalsIgnoreCase("DELETE")) {
			res = req.when().delete(resourceAPI.getAPIResource());
		} else if (httpMethod.equalsIgnoreCase("PUT")) {
			res = req.when().put(resourceAPI.getAPIResource());
		} else {
			System.out.println("HTTP Method Not Defined");
		}

	}
	
	@Then("User verifies the status of first {string} pets to be {string}")
	public void user_verifies_the_status_of_first_pets_to_be(String noOfPets, String status) {
		int n = Integer.parseInt(noOfPets);
		JsonPath path = new JsonPath(res.asString());
		for (int i = 1; i <= n; i++) {
			Assert.assertEquals(status, path.get("[" + i + "].status"));
		}
	}

	@Then("the API call is successful with status code {int}")
	public void the_api_call_is_successful_with_status_code(Integer statusCode) {
		Assert.assertEquals(Integer.toString(res.getStatusCode()), Integer.toString(statusCode));
	}

	@Then("{string} in the Response body is {string}")
	public void in_the_response_body_is(String key, String value) {
		assertEquals(getJsonPath(res, key), value);
		if(res.statusCode()==200){
		pet_id = getJsonPath(res, "id");
		}
	}


}
