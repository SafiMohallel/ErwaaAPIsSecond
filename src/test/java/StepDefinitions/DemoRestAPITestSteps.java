package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.junit.Assert;


import Utilities.PropertiesReader;

import java.net.URI;
import java.net.URISyntaxException;

public class DemoRestAPITestSteps {
	private Scenario scenario;
	private Response response;
	PropertiesReader propertiesReader = new PropertiesReader();
	static String mainURL;
	
	@Before
	public void before(Scenario scenarioVal) throws Exception {
		this.scenario = scenarioVal;
		mainURL = PropertiesReader.getValue("url");
	}

	@Given("GET all posts {string}")
	public void get_all_posts(String string) throws URISyntaxException {
		RequestSpecification req = RestAssured.given();
		response = req.when().get(mainURL+ new URI(string));
	}
	
	@Then("Response Code {string} is validated")
	public void response_code_is_validated(String string) {
		Assert.assertEquals(string, response.then().extract().statusCode() + "");
	}
	
	@Then("the total number of posts is {string}")
	public void the_total_number_of_posts_is(String string) {
		scenario.log("Response Received == " + response.asPrettyString());
		JSONArray resJson = new JSONArray(response.asString());
		Assert.assertEquals(string,resJson.length()+"");
	}
	
	@Given("GET single post {string}")
	public void get_single_post(String string) throws URISyntaxException {
		RequestSpecification req = RestAssured.given();
		response = req.when().get(mainURL+ new URI(string));
	}

	@Then("email is {string} is validated")
	public void email_is_is_validated(String string) {
		Assert.assertEquals(string, response.then().extract().path("email").toString());
	}
}
