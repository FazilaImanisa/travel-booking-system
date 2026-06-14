import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TravelApp {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public TravelApp() {
        flights.add(new Flight("GA-101", "Jakarta", "Bali", "2025-12-01", 20, 1500000));
        flights.add(new Flight("JT-202", "Jakarta", "Bali", "2025-12-01", 15, 1200000));
        flights.add(new Flight("ID-303", "Jakarta", "Surabaya", "2025-12-01", 10, 900000));
        flights.add(new Flight("GA-102", "Jakarta", "Bali", "2025-08-01", 40, 950000));
        flights.add(new Flight("QG-201", "Surabaya", "Jakarta", "2025-08-02", 60, 780000));
        flights.add(new Flight("QG-202", "Surabaya", "Bali", "2025-08-02", 30, 600000));
        flights.add(new Flight("ID-301", "Bali", "Jakarta", "2025-08-03", 45, 900000));
        flights.add(new Flight("JT-401", "Jakarta", "Medan", "2025-08-04", 55, 1100000));

        hotels.add(new Hotel("H001", "Bali Sunset Hotel", "Bali", "2025-12-01", "2025-12-03", 8, 750000));
        hotels.add(new Hotel("H002", "Bali Garden Resort", "Bali", "2025-12-01", "2025-12-03", 5, 1200000));
        hotels.add(new Hotel("H003", "Surabaya City Hotel", "Surabaya", "2025-12-01", "2025-12-03", 10, 600000));
        hotels.add(new Hotel("H004", "Grand Hyatt", "Bali", "2025-12-01", "2025-12-03", 6, 2500000));
        hotels.add(new Hotel("H005", "Aston Marina", "Jakarta", "2025-12-01", "2025-12-03", 7, 900000));
        hotels.add(new Hotel("H006", "Kuta Resort", "Bali", "2025-12-01", "2025-12-03", 4, 1200000));
    }

    public void run() {
        boolean running = true;

        while (running) {
            showMenu();

            int choice = getMenuChoice();

            switch (choice) {
                case 1 -> searchFlights();
                case 2 -> searchHotels();
                case 3 -> bookFlight();
                case 4 -> bookHotel();
                case 5 -> cancelReservation();
                case 6 -> viewReservations();
                case 7 -> {
                    System.out.println("Thank you for using Travel Booking System.");
                    running = false;
                }
                default -> System.out.println("Invalid menu. Please try again.");
            }

            System.out.println();
        }
    }

    private void showMenu() {
        System.out.println("===== Travel Booking System =====");
        System.out.println("1. Search Flight");
        System.out.println("2. Search Hotel");
        System.out.println("3. Book Flight");
        System.out.println("4. Book Hotel");
        System.out.println("5. Cancel Reservation");
        System.out.println("6. View Reservations");
        System.out.println("7. Exit");
    }

    private void searchFlights() {
        System.out.print("Origin: ");
        String origin = scanner.nextLine();

        System.out.print("Destination: ");
        String destination = scanner.nextLine();

        List<Flight> results = flights.stream()
                .filter(flight -> flight.getOrigin().equalsIgnoreCase(origin)
                        && flight.getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());

        System.out.println("\nAvailable Flights:");

        if (results.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }

        results.forEach(System.out::println);
    }

    private void searchHotels() {
        System.out.print("Location: ");
        String location = scanner.nextLine();

        System.out.print("Check-in Date (YYYY-MM-DD): ");
        String checkIn = scanner.nextLine();

        System.out.print("Check-out Date (YYYY-MM-DD): ");
        String checkOut = scanner.nextLine();

        List<Hotel> results = hotels.stream()
                .filter(hotel -> hotel.getLocation().equalsIgnoreCase(location)
                        && hotel.getCheckInDate().equals(checkIn)
                        && hotel.getCheckOutDate().equals(checkOut))
                .collect(Collectors.toList());

        System.out.println("\nAvailable Hotels:");

        if (results.isEmpty()) {
            System.out.println("No hotels available.");
            return;
        }

        results.forEach(System.out::println);
    }

    private void bookFlight() {
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();

        Flight selectedFlight = null;

        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                selectedFlight = flight;
                break;
            }
        }

        if (selectedFlight == null) {
            System.out.println("Flight not found.");
            return;
        }

        if (selectedFlight.getAvailableSeats() <= 0) {
            System.out.println("No seats available for this flight.");
            return;
        }

        System.out.print("Passenger name: ");
        String passengerName = scanner.nextLine();

        System.out.print("Contact: ");
        String contact = scanner.nextLine();

        System.out.print("Number of Passengers: ");
        int passengerCount = Integer.parseInt(scanner.nextLine());

        if (passengerCount <= 0) {
            System.out.println("Passenger count must be more than 0.");
            return;
        }

        if (selectedFlight.getAvailableSeats() < passengerCount) {
            System.out.println("Not enough seats available.");
            return;
        }

        int confirmationNumber = ConfirmationUtil.generateConfirmationNumber();

        FlightReservation reservation = new FlightReservation(
                confirmationNumber,
                passengerName,
                contact,
                selectedFlight,
                passengerCount);

        selectedFlight.setAvailableSeats(selectedFlight.getAvailableSeats() - passengerCount);
        reservations.add(reservation);

        System.out.println("\nFlight booking successful!");
        System.out.println("Confirmation Number: " + confirmationNumber);
    }

    private void bookHotel() {
        System.out.print("Enter hotel ID: ");
        String hotelId = scanner.nextLine();

        Hotel selectedHotel = null;

        for (Hotel hotel : hotels) {
            if (hotel.getHotelId().equalsIgnoreCase(hotelId)) {
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            System.out.println("Hotel not found.");
            return;
        }

        if (selectedHotel.getAvailableRooms() <= 0) {
            System.out.println("No rooms available for this hotel.");
            return;
        }

        System.out.print("Guest name: ");
        String guestName = scanner.nextLine();

        System.out.print("Contact: ");
        String contact = scanner.nextLine();

        int confirmationNumber = ConfirmationUtil.generateConfirmationNumber();

        System.out.print("Check In Date (YYYY-MM-DD): ");
        String checkIn = scanner.nextLine();

        System.out.print("Check Out Date (YYYY-MM-DD): ");
        String checkOut = scanner.nextLine();

        System.out.print("Number of Guests: ");
        int guests = Integer.parseInt(scanner.nextLine());

        HotelReservation reservation = new HotelReservation(
                confirmationNumber,
                guestName,
                contact,
                selectedHotel,
                checkIn,
                checkOut,
                guests);

        selectedHotel.decreaseRoom();
        reservations.add(reservation);

        System.out.println("\nHotel booking successful!");
        System.out.println("Confirmation Number: " + confirmationNumber);
    }

    private void cancelReservation() {
        System.out.print("Enter confirmation number: ");

        try {
            int confirmationNumber = Integer.parseInt(scanner.nextLine());

            Reservation foundReservation = null;

            for (Reservation reservation : reservations) {
                if (reservation.getConfirmationNumber() == confirmationNumber) {
                    foundReservation = reservation;
                    break;
                }
            }

            if (foundReservation == null) {
                throw new ReservationNotFoundException("Reservation not found.");
            }

            reservations.remove(foundReservation);

            if (foundReservation instanceof FlightReservation flightReservation) {
                flightReservation.getFlight().setAvailableSeats(
                        flightReservation.getFlight().getAvailableSeats() + flightReservation.getPassengerCount());
                System.out.println("Flight reservation cancelled successfully.");
                System.out.println("Cancelled flight: " + flightReservation.getFlight());
            } else if (foundReservation instanceof HotelReservation hotelReservation) {
                hotelReservation.getHotel().increaseRoom();
                System.out.println("Hotel reservation cancelled successfully.");
                System.out.println("Cancelled hotel: " + hotelReservation.getHotel());
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid confirmation number. Please enter numbers only.");
        } catch (ReservationNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }

        System.out.println("\n===== All Reservations =====");

        for (Reservation reservation : reservations) {
            reservation.display();
            System.out.println("----------------------------");
        }
    }

    private int getMenuChoice() {
        while (true) {
            try {
                System.out.print("Choose menu: ");

                int choice = Integer.parseInt(scanner.nextLine());

                if (choice < 1 || choice > 7) {
                    System.out.println("Please choose between 1 and 7.");
                    continue;
                }

                return choice;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
