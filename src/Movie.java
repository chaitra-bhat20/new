class Movie {
    private String name;
    private String showTime;
    private double ticketPrice;

    public Movie(String name, String showTime, double ticketPrice) {
        this.name = name;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
    }

    public String getName() {
        return name;
    }

    public String getShowTime() {
        return showTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}