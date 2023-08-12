package day9;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.*;
import utilities.BaseUrl;
import utilities.BaseUrlSpec;

import static io.restassured.RestAssured.given;

public class C18_HerokuPostPojo extends BaseUrlSpec {

    /*
     {
        "firstname": "Kemal",
        "lastname": "Sunal",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2008-01-01",
            "checkout": "2009-01-01"
        },
        "additionalneeds": "some laughter"
    }
     */


    @Test
    public void postBookingWithPojo() {

        // 1- Endpoint in BaseUrl and request body

        specHerokuapp.pathParam("pp1","booking");

        Bookingdates bookingdates= new Bookingdates("2008-01-01","2009-01-01");

        Booking requestBody = new Booking("Kemal","Sunal",111,true,bookingdates,"wi-fi");

        // 2- Expected data

        Herokupost expectedData = new Herokupost(24,requestBody);

        // 3- Sending the request and saving the response



        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(requestBody) // serialization
                .post("/{pp1}");


        response
                .then()
                .statusCode(200);

        Herokupost actualData = response.as(Herokupost.class);  // De-serialization

        Assert.assertEquals(expectedData.getBooking().getFirstname(),actualData.getBooking().getFirstname());
        Assert.assertEquals(expectedData.getBooking().getLastname(),actualData.getBooking().getLastname());
        Assert.assertEquals(expectedData.getBooking().getTotalprice(),actualData.getBooking().getTotalprice());
        Assert.assertEquals(expectedData.getBooking().getDepositpaid(),actualData.getBooking().getDepositpaid());
        Assert.assertEquals(expectedData.getBooking().getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());



    }
}
