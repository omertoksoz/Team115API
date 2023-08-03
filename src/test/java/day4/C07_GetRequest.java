package day4;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import utilities.BaseUrlSpec;

import java.awt.geom.RectangularShape;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_GetRequest  extends BaseUrlSpec {


    @Test
    public void getReqresAll(){

        /*
         *** TC07:Send a GET Request to https://reqres.in/api/users
              and verify:
              The status code is 200
              The content type is application/json; charset=utf-8
              Verify that the following exists in data
              email is tracey.ramos@reqres.in
              first_name is Tracey
              last_name is Ramos
              avatar is https://reqres.in/img/faces/6-image.jpg

             {
                "id": 6,
                "email": "tracey.ramos@reqres.in",
                "first_name": "Tracey",
                "last_name": "Ramos",
                "avatar": "https://reqres.in/img/faces/6-image.jpg"
             }

         */

        // 1- End-point and request body

        specReqresIn.pathParams("pp1","api","pp2","users");

        // 2- Expected data

        // 3- Send the request and save the response

        Response response = given().spec(specReqresIn)
                                .when()
                                .get("/{pp1}/{users}");


        // 4- Assertions

        response
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body()


    }



    @Test
    public void getBooking(){
        /*
        *** TC08:Send a GET Request to https://restful-booker.herokuapp.com/booking/433
     and verify:
     The status code is 200
     The content type is application/json; Charset=utf-8
     firstname is John
     lastname is Smith
     totalprice is 111
     depositpaid is true
     bookingdates (checkin) is 2018-01-01
     bookingdates (checout) is 2019-01-01

        *  {
       "firstname": "John",
       "lastname": "Smith",
       "totalprice": 111,
       "depositpaid": true,
       "bookingdates": {
           "checkin": "2018-01-01",
           "checkout": "2019-01-01"
       },
       "additionalneeds": "Breakfast"
   }


         */



    }
}
