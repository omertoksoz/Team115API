package day9;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.JsonPlaceHolderPojo;
import utilities.BaseUrl;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

public class C17_JsanPlaceHolderPut {


   @Test
   public void jsonPlaceHolderPutPojo() {


       // 1- End-point and request body

        String url = BaseUrl.jsonPlaceHolder()+"/1";

       JsonPlaceHolderPojo requestBody = new JsonPlaceHolderPojo("Ahmet", "Merhaba", 1, 1);

       // 2 - Expected Data

       JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo("Ahmet", "Merhaba", 1, 1);

       // 3- Send the request and save the response

       Response response = given().contentType(ContentType.JSON)
                             .when().body(requestBody)  // java to json -> serialization , we used through gson library
                            .put(url);

       response
               .then()
               .statusCode(200);

       JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class); // De-Serialization


       assertEquals(expectedData.getBody(),actualData.getBody());
       assertEquals(expectedData.getTitle(),actualData.getTitle());
       assertEquals(expectedData.getId(),actualData.getId());
       assertEquals(expectedData.getUserId(),actualData.getUserId());

// Break till 8:50
   }


}
