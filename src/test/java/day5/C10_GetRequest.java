package day5;

import org.junit.Test;
import utilities.ApiCalls;

import static utilities.ApiCalls.*;

public class C10_GetRequest {


    @Test
    public void id5ExistInReqresIn() {

        checkUserExistWithId(5,
                200,
                "charles.morris@reqres.in",
                "Charles",
                "Morris");
    }

    @Test
    public void id2ExistInRegresIn(){


        checkUserExistWithId(2,
                200,
                "janet.weaver@reqres.in",
                "Janet",
                "Weaver");
    }

    @Test
    public void nameExistReqresIn(){

        allNamesListReqresIn(200,"Emma");

        /// Break till 9:13 PM

    }

    @Test
    public void id10ExistInReqresIn(){

        checkUserExistWithIdJsonPath(10,200,"byron.fields@reqres.in","Byron","Fields");

    }


    @Test

    public void idHerokuapp(){

        checkUserWIthIdHerokuapp(510,
                200,
                "John",
                "Smith",
                111,
                true,
                "2018-01-01",
                "2019-01-01");
    }



}
