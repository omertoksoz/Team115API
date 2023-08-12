package pojo;

public class HerokuRequestBodyPojo {

    /*
    {
        "firstname": "Kemal",
        "lastname": "Sunal",
        "totalprice": 111,
        "depositpaid": true,
                          "bookingdates": {
                                             "checkin": "2008-01-01",
                                            "checkout": "2009-01-01"   -> A HerokuBookingdatesPojo object
                                                                    },
        "additionalneeds": "some laughter"
    }
     */


    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additionalneeds;
    private HerokuBookingdatesPojo bookindates;

    public HerokuRequestBodyPojo(String firstname, String lastname, int totalprice, boolean depositpaid, String additionalneeds, HerokuBookingdatesPojo bookindates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds = additionalneeds;
        this.bookindates = bookindates;
    }

    public HerokuRequestBodyPojo() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public HerokuBookingdatesPojo getBookindates() {
        return bookindates;
    }

    public void setBookindates(HerokuBookingdatesPojo bookindates) {
        this.bookindates = bookindates;
    }

    @Override
    public String toString() {
        return "HerokuRequestBodyPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", additionalneeds='" + additionalneeds + '\'' +
                ", bookindates=" + bookindates +
                '}';
    }
}
