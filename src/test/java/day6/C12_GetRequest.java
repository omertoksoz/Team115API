package day6;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import utilities.ApiCalls;
import utilities.BaseUrl;
import utilities.TestData;

import static io.restassured.RestAssured.given;

public class C12_GetRequest {

    @Test
    public void bookingTestExpectedBodyJson(){



        JSONObject expectedData = TestData.getBookingDataJSON();

        Response response = given()
                .when()
                .get(BaseUrl.herokuappUserId(303));

        JSONObject actualData = new JSONObject(response.getBody().asString());

        // Why am I converting the response to JSONObject?
        // Because I can

        // Assertions

        Assert.assertEquals(expectedData.getString("firstname"),actualData.getString("firstname"));
        Assert.assertEquals(expectedData.getString("lastname"),actualData.getString("lastname"));
        Assert.assertEquals(expectedData.getInt("totalprice"),actualData.getInt("totalprice"));
        Assert.assertEquals(expectedData.getBoolean("depositpaid"),actualData.getBoolean("depositpaid"));

        JSONObject expectedbookingdates = expectedData.getJSONObject("bookingdates");


        JSONObject actualbookingdates = actualData.getJSONObject("bookingdates");

        Assert.assertEquals(expectedbookingdates.getString("checkin"),actualbookingdates.getString("checkin"));
        Assert.assertEquals(expectedbookingdates.getString("checkout"),actualbookingdates.getString("checkout"));

    }


    @Test
    public void bookingTestRequestBodyJson2(){

        ApiCalls.BookingJson(1677,200,"Jane","Doe",111,true,"2018-01-01","2019-01-01" );
       // ApiCalls.BookingJson(793,200,"John","Smith",111,true,"2018-01-01","2019-01-01" );


    }



}
