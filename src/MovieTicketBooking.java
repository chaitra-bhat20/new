import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class MovieTicketBooking {
  public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  Theatre theatre = new Theatre();
  User frontDesk = new User("chaitra", "bhat");

//Login
System.out.println("Welcome to the Movie Ticket Booking System!");
boolean isLoggedIn = false;
for (int i = 0; i < 3; i++) {
  System.out.print("Enter username: ");
  String username = scanner.nextLine();
  System.out.print("Enter password: ");
  String password = scanner.nextLine();

  if (username.equals(frontDesk.getUsername()) && password.equals(frontDesk.getPassword())) {
      isLoggedIn = true;
      break;
  } else {
      System.out.println("Invalid username or password. Please try again.");
  }
}

if (!isLoggedIn) {
  System.out.println("Maximum login attempts reached. Exiting...");
  System.exit(0);
}

// Add sample movies
theatre.addMovie("2023-05-17", new Movie("KGF2", "10:00 AM", 300.0));
theatre.addMovie("2023-05-17", new Movie("RRR", "12:30 PM", 450));
theatre.addMovie("2023-05-18", new Movie("Guardians of the Galaxy Vol. 3", "03:00 PM", 250));
theatre.addMovie("2023-05-18", new Movie("The Kerala Story", "06:00 PM", 350));


// Movie ticket booking process
System.out.println("Welcome to the Movie Ticket Booking System!");
System.out.print("Enter the date (YYYY-MM-DD): ");
String date = scanner.nextLine();

theatre.displayAvailableMovies(date);

System.out.print("Enter the movie index: ");
int movieIndex = scanner.nextInt();
scanner.nextLine(); 

System.out.print("Enter your name: ");
String customerName = scanner.nextLine();

System.out.print("Enter the seat numbers (comma-separated): ");
String seatNumbersInput = scanner.nextLine();
List<String> seatNumbers = Arrays.asList(seatNumbersInput.split(","));

theatre.bookTicket(date, movieIndex - 1, customerName, seatNumbers);

System.out.print("Enter the booking ID: ");
String bookingID = scanner.nextLine();

theatre.viewBookingStatus(date, bookingID);

scanner.close();
}
}