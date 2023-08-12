package pojo;

public class HerokuResponseBodyPojo {
    /*
    {
    "bookingid": 2685,
    "booking": {
        "firstname": "Kemal",
        "lastname": "Sunal",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2008-01-01",
            "checkout": "2009-01-01"
        },
        "additionalneeds": "some laughter"
    }
}
     */


    private int bookingid;
    private HerokuRequestBodyPojo booking;

    public HerokuResponseBodyPojo(int bookingid, HerokuRequestBodyPojo requestbody) {
        this.bookingid = bookingid;
        this.booking = requestbody;
    }


    public HerokuResponseBodyPojo() {
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public HerokuRequestBodyPojo getBooking() {
        return booking;
    }

    public void setBooking(HerokuRequestBodyPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "HerokuResponseBodyPojo{" +
                "bookingid=" + bookingid +
                ", requestbody=" + booking +
                '}';
    }
}
