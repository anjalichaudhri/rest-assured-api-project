package RESTAssuredAutomation.RESTAssuredAutomation;

import org.testng.Assert;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class AppTest {
	@Test
	public void test_1() {
		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println("status code: " + response.getStatusCode() + " Response Time: " + response.getTime());

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api";

		given().get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[1]", equalTo(8)).log().all();

	}
}