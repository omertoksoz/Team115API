package day8;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import utilities.BaseUrl;
import utilities.TestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C16_PostJsonPlaceHolder {

@Test
    public void postResource(){
    /*
    Request body
     Expected body
     Actual data

Request body

{
"userId":2000,
"title":"Magic Music Man",
"body":"Ulker"
}

Expected Body

{
    "userId": 2000,
    "title": "Magic Music Man",
    "body": "Ulker",
    "id": 101
}



*/

    // 1- Endpoint is in BaseUrl and my requestbody is in TestData
    // 2- Expected data is in TestData
    // 3- Send the request and save the response


    Response response = given()
            .contentType(ContentType.JSON)
            .body(TestData.requestBodyJsonObjectJsonPlaceHolder())
            .when()
            .post(BaseUrl.jsonPlaceHolder());

    response.then()
            .statusCode(201)
            .contentType(ContentType.JSON);


    JSONObject expectedData = TestData.expectedJsonObjectJsonPlaceHolder();


    JsonPath actualData = response.jsonPath();



    // 4- Assertions

    assertEquals(expectedData.getJSONObject("map").getInt("userId"),actualData.getInt("map.userId"));
    assertEquals(expectedData.getJSONObject("map").getString("title"),actualData.getString("map.title"));
    assertEquals(expectedData.getJSONObject("map").getString("body"),actualData.getString("map.body"));





}

}
