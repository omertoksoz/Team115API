package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Authentication {



    public static String generateToken(){

        /*
        {
    "username" : "admin",
    "password" : "password123"
}
         */

        String username = "admin";
        String password = "password123";

        HashMap<String,Object> postBody = new HashMap<>();

        postBody.put("username",username);
        postBody.put("password",password);

        String url ="https://restful-booker.herokuapp.com/auth";

        Response response= given()
                .contentType("application/json")
                .body(postBody)
                .when()
                .post(url);

        JsonPath token = response.jsonPath();

        return token.getString("token");

    }
}
