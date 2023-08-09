package utilities;

import java.util.HashMap;
import java.util.Objects;

public class TestData {


    public static HashMap<String, Object> getBookingData() {

        HashMap<String, Object> expectedData = new HashMap<>();

        HashMap<String, Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 111.0);
        expectedData.put("depositpaid", true);
        expectedData.put("additionalneeds", "Breakfast");
        expectedData.put("bookingdates", bookingdates);

        return expectedData;
    }
}
