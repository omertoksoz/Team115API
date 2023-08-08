package day5;

import org.junit.Test;
import utilities.ApiCalls;

import static utilities.ApiCalls.allNamesListReqresIn;
import static utilities.ApiCalls.checkUserExistWithId;

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

    }

}
