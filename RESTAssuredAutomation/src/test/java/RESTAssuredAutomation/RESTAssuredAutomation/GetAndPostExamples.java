package RESTAssuredAutomation.RESTAssuredAutomation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";

		given().get("/users?page=2").then().statusCode(200).body("data.first_name[4]", equalTo("George"))
				.body("data.first_name", hasItems("George", "Rachel"));

	}

	@Test
	public void testPost() {

		// create the request data in map
//		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject request = new JSONObject();

		request.put("name", "Anjali");
		request.put("job", "QA");

		baseURI = "https://reqres.in/api";

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();

	}
}
