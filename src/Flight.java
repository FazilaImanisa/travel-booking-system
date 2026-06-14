public class Flight {

    // Private fields (Encapsulation)
    private String flightNumber;
    private String origin;
    private String destination;
    private String date;
    private int availableSeats;
    private double pricePerSeat;

    // Constructor
    public Flight(String flightNumber,
                  String origin,
                  String destination,
                  String date,
                  int availableSeats,
                  double pricePerSeat) {

        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.availableSeats = availableSeats;
        this.pricePerSeat = pricePerSeat;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    // Compatibility getter
    public double getPrice() {
        return pricePerSeat;
    }

    // Setter
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Booking helpers
    public void decreaseSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    public void increaseSeat() {
        availableSeats++;
    }

    // Display
    @Override
    public String toString() {
        return String.format(
                "[%s] %s → %s | Tanggal: %s | Kursi: %d | Harga: Rp%,.0f/orang",
                flightNumber,
                origin,
                destination,
                date,
                availableSeats,
                pricePerSeat
        );
    }
}