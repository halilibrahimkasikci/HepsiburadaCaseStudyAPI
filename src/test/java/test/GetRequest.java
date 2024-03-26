package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import util.Config;


import static org.testng.Assert.assertEquals;

public class GetRequest {

    @Test
    public void listBooking() {
        Response response = RestAssured.given()
                .baseUri(Config.get("base.url") + "/booking")
                .contentType(ContentType.JSON)
                .get();
        response.then().log().all();

        assertEquals(response.getStatusCode(), 200, "Expected status code 200");
        response.then().assertThat().contentType(ContentType.JSON);
    }
}

