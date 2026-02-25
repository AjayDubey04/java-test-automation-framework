package restassured.api.stepdefs;

import org.junit.Ignore;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetStepDefs {

	private Response res;
	private RequestSpecification rs;
	private String userName="createrajay229@btech.com";
	private String password="Ajay@66#";
	private String endpoint="/dev/api/contacts";

	@Given("^user is already entered url with endpoint and userName and passord$")
	public void login() {
		rs= RestAssured.given().baseUri("https://evsautomation.agilecrm.com").
				auth().basic(userName, password)
				.accept(ContentType.JSON).queryParam("page_size", "2");

	}

	@When("^user perform get http requriest$")
	public void getRequriest() {
		res=this.rs.when().get(endpoint);
		System.out.println("Statuc Code ==> "+res.getStatusCode());
		System.out.println(res.getBody().asPrettyString());
	}

	@Ignore
	@Then("^status code should be 200-ok$")
	public void verifyStatusCode() {
		res.then().statusCode(200);
		System.out.println("Expected Status Code Match with Acutal Status code");
	}

}
