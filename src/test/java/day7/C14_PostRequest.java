package day7;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import utilities.Authentication;
import utilities.BaseUrl;
import utilities.TestData;

import static io.restassured.RestAssured.given;

public class C14_PostRequest {

    @Test
    public void postJsonObjectHeroku(){

        JSONObject expectedData = TestData.createBookingData();

        // System.out.println(TestData.createBookingData().toString());

        Response response = given()
                .contentType("application/json; charset=utf-8")
                .header("Authorization","Bearer", Authentication.generateToken())
               // .auth()
                //.basic("admin","password123")
                .when()
                .body(expectedData.toString()) // it is JsonObject, must be sent as String
                .post(BaseUrl.createBookingUrl());

        response
                .then()
                .assertThat()
                .statusCode(200);

        //response.prettyPrint();
        JsonPath actualData = response.jsonPath();

        Assert.assertEquals(expectedData.getString("firstname"), actualData.getString("booking.firstname"));
        Assert.assertEquals(expectedData.getString("lastname"), actualData.getString("booking.lastname"));
        Assert.assertEquals(expectedData.getInt("totalprice"), actualData.getInt("booking.totalprice"));
        Assert.assertEquals(expectedData.getBoolean("depositpaid"), actualData.getBoolean("booking.depositpaid"));

        // Assert objects in objects

        Assert.assertEquals(expectedData.getJSONObject("bookingdates").getString("checkin"),
                actualData.getString("booking.bookingdates.checkin"));

        Assert.assertEquals(expectedData.getJSONObject("bookingdates").getString("checkout"),
                actualData.getString("booking.bookingdates.checkout"));





    }
}
