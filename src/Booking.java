import java.util.List;

class Booking {
    private String bookingID;
    private String customerName;
    private String movieName;
    private String showTime;
    private List<String> selectedSeats;
    private double amount;

    public Booking(String bookingID, String customerName, String movieName, String showTime, List<String> selectedSeats, double amount) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.showTime = showTime;
        this.selectedSeats = selectedSeats;
        this.amount = amount;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public List<String> getSelectedSeats() {
        return selectedSeats;
    }

    public double getAmount() {
        return amount;
    }
}