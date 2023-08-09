package utilities;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

public class TestData {


    public static HashMap<String, Object> getBookingData() {

        HashMap<String, Object> purpleCow = new HashMap<>();

        HashMap<String, Object> checkInOUt = new HashMap<>();

        checkInOUt.put("checkin", "2018-01-01");
        checkInOUt.put("checkout", "2019-01-01");

        purpleCow.put("firstname", "John");
        purpleCow.put("lastname", "Smith");
        purpleCow.put("totalprice", 111.0);
        purpleCow.put("depositpaid", true);
        purpleCow.put("additionalneeds", "Breakfast");
        purpleCow.put("bookingdates", checkInOUt);

        return purpleCow;
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
}
