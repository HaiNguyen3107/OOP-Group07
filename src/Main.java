import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot(10); // parking lot with 10 spots

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Check-in");
            System.out.println("2. Check-out");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("License Plate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.print("Vehicle Type (car/motorbike): ");
                    String type = scanner.nextLine();
                    System.out.println(parkingLot.checkIn(licensePlate, type));
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to check-out: ");
                    String ticketId = scanner.nextLine();
                    System.out.println(parkingLot.checkOut(ticketId));
                    break;

                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
