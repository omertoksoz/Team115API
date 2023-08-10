package day7;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import utilities.BaseUrl;

import static io.restassured.RestAssured.given;

public class C15_GetFruits {


    @Test
    public void getAllFruits(){

        Response response = given()
                .when()
                .get(BaseUrl.getAllFruits());

        response.then()
                .statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void postFruit(){
        /*
        {
  "name": "Mangos,",
  "price": 2.79
}
         */

        JSONObject fruit = new JSONObject();
        fruit.put("name","elma");
        fruit.put("price",1.89);


        Response response = given().contentType("application/json").body(fruit)
                .when()
                .post(BaseUrl.getAllFruits());

        response.then()
                .statusCode(201)
                .contentType(ContentType.JSON);

        response.prettyPrint();





    }
}
