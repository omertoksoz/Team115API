package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlSpec {

  protected RequestSpecification specReqresIn;

  protected RequestSpecification specHerokuapp;

  protected RequestSpecification specDummy;



  @Before
    public void setUp(){

      specReqresIn = new RequestSpecBuilder().setBaseUri("https://reqres.in").build();

      specHerokuapp = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

      specDummy = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/api/v1").build();

  }

}
