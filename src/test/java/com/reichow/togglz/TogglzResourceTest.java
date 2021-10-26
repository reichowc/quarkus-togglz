package com.reichow.togglz;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TogglzResourceTest {

	@Test
	public void testHelloEndpoint() {
		given()
				.when().get("/togglz-resource/custom-feature")
				.then()
				.statusCode(200)
				.body(is("MY_CUSTOM_FEATURE: Active."));
	}
}
