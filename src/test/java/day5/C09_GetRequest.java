package day5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.BaseUrl;

import static io.restassured.RestAssured.given;
import static utilities.BaseUrl.*;

public class C09_GetRequest {


    // 1- End-point and request body
    // My end point is in BaseUrl class - no request body

    // 2- I am preparing an expected data

    //3 - Send request and save response

    Response response = given()
                            .when()
                            .get(reqresInUsers());

    JsonPath jsonPath = response.jsonPath();

    @Test
    public void nameExistingInReqresIn(){

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");

      //  System.out.println(jsonPath.getList("data.first_name"));
        // Verify that Janet is in the name list

        Assert.assertTrue(jsonPath.getList("data.first_name").contains("Janet"));


    }

    @Test
    public void emailExistsInReqresIn(){

        response.then()
                .assertThat()
                .statusCode(200);

        Assert.assertTrue(jsonPath.getList("data.email").contains("eve.holt@reqres.in"));

    }

    @Test

    public void supportReqresInText(){ // for junit (expected, actual)

        Assert.assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",jsonPath.getString("support.text"));
    }

}
