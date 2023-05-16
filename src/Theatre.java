import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Theatre {
    private Map<String, List<Movie>> movieListings;
    private Map<String, List<Booking>> bookings;

    public Theatre() {
        movieListings = new HashMap<>();
        bookings = new HashMap<>();
    }

    public void addMovie(String date, Movie movie) {
        if (!movieListings.containsKey(date)) {
            movieListings.put(date, new ArrayList<>());
        }
        movieListings.get(date).add(movie);
    }

    public void displayAvailableMovies(String date) {
        if (movieListings.containsKey(date)) {
            List<Movie> movies = movieListings.get(date);
            System.out.println("Available Movies on " + date + ":");
            for (int i = 0; i < movies.size(); i++) {
                Movie movie = movies.get(i);
                System.out.println((i + 1) + ". " + movie.getName() + " - " + movie.getShowTime());
            }
        } else {
            System.out.println("No movies available on " + date);
        }
    }

    public void bookTicket(String date, int movieIndex, String customerName, List<String> seatNumbers) {
        if (movieListings.containsKey(date)) {
            List<Movie> movies = movieListings.get(date);
            if (movieIndex >= 0 && movieIndex < movies.size()) {
                Movie movie = movies.get(movieIndex);
                List<Booking> bookingsOnDate = bookings.getOrDefault(date, new ArrayList<>());
                if (checkSeatAvailability(bookingsOnDate, seatNumbers)) {
                    String bookingID = generateBookingID();
                    double amount = movie.getTicketPrice() * seatNumbers.size();
                    Booking booking = new Booking(bookingID, customerName, movie.getName(), movie.getShowTime(), seatNumbers, amount);
                    bookingsOnDate.add(booking);
                    bookings.put(date, bookingsOnDate);
                    System.out.println("Booking successful! Booking ID: " + bookingID);
                } else {
                    System.out.println("One or more seats are already booked. Please select different seats.");
                }
            } else {
                System.out.println("Invalid movie index.");
            }
        } else {
            System.out.println("No movies available on " + date);
        }
    }

    private boolean checkSeatAvailability(List<Booking> bookingsOnDate, List<String> seatNumbers) {
        for (Booking booking : bookingsOnDate) {
            if (Collections.disjoint(booking.getSelectedSeats(), seatNumbers)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public void viewBookingStatus(String date, String bookingID) {
        if (bookings.containsKey(date)) {
            List<Booking> bookingsOnDate = bookings.get(date);
            for (Booking booking : bookingsOnDate) {
                if (booking.getBookingID().equals(bookingID)) {
                    System.out.println("Booking ID: " + booking.getBookingID());
                    System.out.println("Customer Name: " + booking.getCustomerName());
                    System.out.println("Movie Name: " + booking.getMovieName());
                    System.out.println("Show Time: " + booking.getShowTime());
                    System.out.println("Selected Seats: " + booking.getSelectedSeats());
                    System.out.println("Amount: " + booking.getAmount());
                    return;
                }
            }
        }
        System.out.println("Booking not found.");
    }

    private String generateBookingID() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}