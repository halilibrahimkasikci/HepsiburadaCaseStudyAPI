package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import util.Config;
import org.json.JSONObject;

import static org.testng.Assert.assertEquals;

public class PostRequest {

    @Test
    public void createBookingAndCheck() {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", Config.get("checkin"));
        bookingdates.put("checkout", Config.get("checkout"));

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", Config.get("firstname"));
        requestBody.put("lastname", Config.get("lastname"));
        requestBody.put("totalprice", Config.get("totalprice"));
        requestBody.put("depositpaid", Config.get("depositpaid"));
        requestBody.put("bookingdates", bookingdates);
        requestBody.put("additionalneeds", Config.get("additionalneeds"));

        Response response = RestAssured.given()
                .baseUri(Config.get("base.url")+ "/booking")
                .contentType(ContentType.JSON.withCharset("UTF-8"))
                .body(requestBody.toString())
                .post();
        assertEquals(response.getStatusCode(), 200, "Expected status code 200");

        int bookingId = response.then().extract().path("bookingid");

        Response getResponse = RestAssured.given()
                .baseUri(Config.get("base.url") + "/booking/" + bookingId)
                .get();
        response.then().log().all();
        assertEquals(getResponse.getStatusCode(), 200, "Expected status code 200");

        JsonPath getResponseBodyJsonPath = getResponse.jsonPath();
        assertEquals(Config.get("firstname"), getResponseBodyJsonPath.getString("firstname"));
        assertEquals(Config.get("lastname"), getResponseBodyJsonPath.getString("lastname"));
        assertEquals(Config.get("totalprice"), getResponseBodyJsonPath.getString("totalprice"));
        assertEquals(Config.get("depositpaid"), getResponseBodyJsonPath.getString("depositpaid"));
        assertEquals(Config.get("additionalneeds"), getResponseBodyJsonPath.getString("additionalneeds"));
        assertEquals(Config.get("checkin"), getResponseBodyJsonPath.getString("bookingdates.checkin"));
        assertEquals(Config.get("checkout"), getResponseBodyJsonPath.getString("bookingdates.checkout"));

    }
}
