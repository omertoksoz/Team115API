package pojo;

public class Herokupost {

    private Integer bookingid;
    private Booking booking;

    /**
     * No args constructor for use in serialization
     *
     */
    public Herokupost() {
    }

    /**
     *
     * @param booking
     * @param bookingid
     */
    public Herokupost(Integer bookingid, Booking booking) {
        super();
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Herokupost.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("bookingid");
        sb.append('=');
        sb.append(((this.bookingid == null)?"<null>":this.bookingid));
        sb.append(',');
        sb.append("booking");
        sb.append('=');
        sb.append(((this.booking == null)?"<null>":this.booking));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
