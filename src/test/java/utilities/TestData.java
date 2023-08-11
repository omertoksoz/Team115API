package utilities;

import org.json.JSONObject;

import java.util.HashMap;

public class TestData {


    public static HashMap<String, Object> getBookingDataHashMap() {

        HashMap<String, Object> expectedHashMap = new HashMap<>();

        HashMap<String, Object> checkInOUt = new HashMap<>();

        checkInOUt.put("checkin", "2018-01-01");
        checkInOUt.put("checkout", "2019-01-01");

        expectedHashMap.put("firstname", "John");
        expectedHashMap.put("lastname", "Smith");
        expectedHashMap.put("totalprice", 111.0);
        expectedHashMap.put("depositpaid", true);
        expectedHashMap.put("additionalneeds", "Breakfast");
        expectedHashMap.put("bookingdates", checkInOUt);

        return expectedHashMap;
    }

    public static HashMap<String, Object> postBookingDataHashMap() {

        HashMap<String, Object> expectedHashMap = new HashMap<>();

        HashMap<String, Object> checkInOUt = new HashMap<>();

        checkInOUt.put("checkin", "2018-01-01");
        checkInOUt.put("checkout", "2019-01-01");

        expectedHashMap.put("firstname", "Sener");
        expectedHashMap.put("lastname", "Sen");
        expectedHashMap.put("totalprice", 1113);
        expectedHashMap.put("depositpaid", true);
        expectedHashMap.put("additionalneeds", "Cigkofte");
        expectedHashMap.put("bookingdates", checkInOUt);

        return expectedHashMap;
    }

    public static JSONObject getBookingDataJSON() {

        JSONObject expectedData = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdates);

        return expectedData;
    }

    public static JSONObject createBookingData(){

        JSONObject expectedData = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "2023-01-01");
        bookingdates.put("checkout", "2023-02-01");

        expectedData.put("firstname", "Kemal");
        expectedData.put("lastname", "Sunal");
        expectedData.put("totalprice", 999);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdates);

        return expectedData;
    }

    public static JSONObject requestBodyJsonObjectJsonPlaceHolder(){

        JSONObject requestBody = new JSONObject();


        requestBody.put("userId",1);
        requestBody.put("title","Magic Music Man");
        requestBody.put("body","Ulker");

        return requestBody;

    }

    public static JSONObject expectedJsonObjectJsonPlaceHolder(){

        JSONObject expectedData = new JSONObject();


        expectedData.put("userId",1);
        expectedData.put("title","Magic Music Man");
        expectedData.put("body","Ulker");
        expectedData.put("id",101);

        return expectedData;

    }


    public static HashMap<String,Object> requestBodyHashMapJsonPlaceHolder(){

        HashMap<String,Object> requestBody = new HashMap<>();

        requestBody.put("userId",1);
        requestBody.put("title","Magic Music Man");
        requestBody.put("body","Ulker");

        return requestBody;

    }

    public static HashMap<String,Object> expectedHashMapJsonPlaceHolder(){

        HashMap<String,Object> expectedData = new HashMap<>();

        expectedData.put("userId",1);
        expectedData.put("title","Magic Music Man");
        expectedData.put("body","Ulker");
        expectedData.put("id",1.0);


        return expectedData;

    }




}
