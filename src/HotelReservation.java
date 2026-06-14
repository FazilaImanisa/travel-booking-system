public final class HotelReservation extends Reservation {

    private Hotel hotel;
    private String checkIn;
    private String checkOut;
    private int guests;

    public HotelReservation(
            int confirmationNumber,
            String customerName,
            String contact,
            Hotel hotel,
            String checkIn,
            String checkOut,
            int guests) {

        super(confirmationNumber, customerName, contact);

        this.hotel = hotel;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public int getGuests() {
        return guests;
    }

    @Override
    public void display() {
        System.out.println("Hotel Reservation");
        System.out.println("Confirmation Number: " + getConfirmationNumber());
        System.out.println("Guest Name: " + getCustomerName());
        System.out.println("Contact: " + getContact());
        System.out.println("Hotel: " + hotel);
        System.out.println("Check In: " + checkIn);
        System.out.println("Check Out: " + checkOut);
        System.out.println("Guests: " + guests);
    }
}