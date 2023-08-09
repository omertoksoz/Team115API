package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ApiCalls {

    // We will create dynamic methods for Response
    //This method will return response, we will use Matchers Class


    public static Response checkUserExistWithId(int id, int statusCode, String email, String first_name, String last_name) {

        Response response = given()
                .when()// body goes here
                .get(BaseUrl.reqresInUserId(id));

        response
                .then()
                .statusCode(statusCode)
                .contentType("application/json; charset=utf-8")
                .body("data.email", equalTo(email),
                        "data.first_name", equalTo(first_name),
                        "data.last_name", equalTo(last_name));

        return response;

    }


    public static Response checkUserExistWithIdJsonPath(int id, int statusCode, String email, String first_name, String last_name) {
        Response response = given()
                .when()// body goes here
                .get(BaseUrl.reqresInUserId(id));

        response
                .then()
                .statusCode(statusCode)
                .contentType("application/json; charset=utf-8");


        JsonPath jsonPath = response.jsonPath();

        // junit -> expected, actual
        Assert.assertEquals(email, jsonPath.getString("data.email"));
        Assert.assertEquals(first_name, jsonPath.getString("data.first_name"));
        Assert.assertEquals(last_name, jsonPath.getString("data.last_name"));

        return response;


    }


    public static Response allNamesListReqresIn(int statusCode, String name) {

        Response response = given()
                .when()
                .get(BaseUrl.reqresInUsers());

        response
                .then()
                .statusCode(statusCode)
                .contentType("application/json; charset=utf-8");

        JsonPath jsonPath = response.jsonPath();

        Assert.assertTrue(jsonPath.getList("data.first_name").contains(name));

        return response;


    }


    public static Response checkUserWIthIdHerokuapp(int id,
                                                    int statusCode,
                                                    String firstname,
                                                    String lastname,
                                                    int totalPrice,
                                                    boolean depositPaid,
                                                    String checkIn,
                                                    String checkOut) {

        Response response = given()
                .when()
                .get(BaseUrl.herokuappUserId(id));



        response
                .then()
                .assertThat()
                .statusCode(statusCode)
               .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo(firstname),
                        "lastname", equalTo(lastname),
                        "totalprice", equalTo(totalPrice),
                        "depositpaid", equalTo(depositPaid),
                        "bookingdates.checkin", equalTo(checkIn),
                        "bookingdates.checkout", equalTo(checkOut));

        return response;


    }


    public static Response deserializationBooking(int id,
                                              int statuscode,
                                              String firstname,
                                              String lastname,
                                              double totalprice,
                                              boolean depositpaid,
                                              String checkin,
                                              String checkout) {



        HashMap<String,Object> expectedData = new HashMap<>();

        HashMap<String, Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin", checkin);
        bookingdates.put("checkout",checkout);

        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingdates);


        Response response = given()
                .when()
                .get(BaseUrl.herokuappUserId(id));

        response.then()
                .statusCode(statuscode)
                .contentType("application/json; charset=utf-8");

        HashMap<String,Object> actualData = response.as(HashMap.class); // De-serialization is here

        // Assertion

        Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
       // Assert.assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));
        Assert.assertEquals(expectedData.get("checkin"),actualData.get("checkin"));
        Assert.assertEquals(expectedData.get("checkout"),actualData.get("checkout"));

        return response;
    }
}
