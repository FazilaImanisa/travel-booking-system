import java.util.Scanner;

public class TravelApp {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;

        while (running) {
            showMenu();

            System.out.print("Choose menu: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> System.out.println("Search Flight feature coming soon...");
                case "2" -> System.out.println("Search Hotel feature coming soon...");
                case "3" -> System.out.println("Book Flight feature coming soon...");
                case "4" -> System.out.println("Book Hotel feature coming soon...");
                case "5" -> System.out.println("Cancel Reservation feature coming soon...");
                case "6" -> System.out.println("View Reservations feature coming soon...");
                case "7" -> {
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
}