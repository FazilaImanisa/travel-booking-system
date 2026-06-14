public final class FlightReservation extends Reservation {

    private Flight flight;
    private int passengerCount;

    public FlightReservation(
            int confirmationNumber,
            String customerName,
            String contact,
            Flight flight,
            int passengerCount) {

        super(confirmationNumber, customerName, contact);

        this.flight = flight;
        this.passengerCount = passengerCount;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public void display() {
        System.out.println("Flight Reservation");
        System.out.println("Confirmation Number: " + getConfirmationNumber());
        System.out.println("Passenger Name: " + getCustomerName());
        System.out.println("Contact: " + getContact());
        System.out.println("Passengers: " + passengerCount);
        System.out.println("Flight: " + flight);
    }
}