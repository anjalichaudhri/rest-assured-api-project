package RESTAssuredAutomation.RESTAssuredAutomation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.json.simple.JSONObject;

public class PutExamples {
	@Test
	public void testPut() {

		JSONObject request = new JSONObject();

		request.put("name", "Anjali");
		request.put("job", "QA");

		baseURI = "https://reqres.in/api";

		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void testPatch() {
		// this is to test the patch request

		JSONObject request = new JSONObject();

		request.put("name", "Anjali");
		request.put("job", "QA");

		baseURI = "https://reqres.in";

		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void testDelete() {
		//this is to test delete api data using rest assured
		
		baseURI = "https://reqres.in";

		when()
			.delete("/api/users/2")
		.then()
			.statusCode(204)
			.log().all();
	}

}
