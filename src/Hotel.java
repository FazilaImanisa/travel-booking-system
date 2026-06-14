public class Hotel {

    private String hotelId;
    private String name;
    private String location;
    private String checkInDate;
    private String checkOutDate;
    private int availableRooms;
    private double pricePerNight;

    public Hotel(String hotelId, String name, String location,
                 String checkInDate, String checkOutDate,
                 int availableRooms, double pricePerNight) {

        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.availableRooms = availableRooms;
        this.pricePerNight = pricePerNight;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    // Booking helpers
    public void decreaseRoom() {
        if (availableRooms > 0) {
            availableRooms--;
        }
    }

    public void increaseRoom() {
        availableRooms++;
    }

    @Override
    public String toString() {
        return String.format(
                "%s | %s | %s | Check-in: %s | Check-out: %s | Rp%,.0f | Rooms: %d",
                hotelId,
                name,
                location,
                checkInDate,
                checkOutDate,
                pricePerNight,
                availableRooms
        );
    }
}