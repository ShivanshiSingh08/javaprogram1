import java.util.Scanner;

class BusReservationSystem {
    private String busName;
    private int totalSeats;
    private int availableSeats;
    
    public BusReservationSystem() {
        busName = "Karnataka Bus Service";
        totalSeats = 50;
        availableSeats = totalSeats;
    }
    
    public BusReservationSystem(String busName, int totalSeats) {
        this.busName = busName;
        this.totalSeats = totalSeats;
        availableSeats = totalSeats;
    }
    
    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("Sorry, no seats available.");
        }
    }
    
    public void bookSeats(int numSeats) {
        if (numSeats <= availableSeats) {
            availableSeats -= numSeats;
            System.out.println(numSeats + " seats booked successfully!");
        } else {
            System.out.println("Not enough seats available.");
        }
    }
    
    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
            System.out.println("Seat canceled successfully!");
        } else {
            System.out.println("No seats to cancel.");
        }
    }
    
    public void cancelSeats(int numSeats) {
        if (numSeats <= (totalSeats - availableSeats)) {
            availableSeats += numSeats;
            System.out.println(numSeats + " seats canceled successfully!");
        } else {
            System.out.println("Invalid number of seats to cancel.");
        }
    }
    
    public void displayAvailableSeats() {
        System.out.println("Available seats in " + busName + ": " + availableSeats);
    }
}

public class ReservationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusReservationSystem bus = new BusReservationSystem();
        
        System.out.println("Welcome to the Bus Reservation System!");
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Book a seat");
            System.out.println("2. Cancel a seat");
            System.out.println("3. Display available seats");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter the number of seats to book: ");
                    int numToBook = scanner.nextInt();
                    bus.bookSeats(numToBook);
                    break;
                    
                case 2:
                    System.out.println("Enter the number of seats to cancel: ");
                    int numToCancel = scanner.nextInt();
                    bus.cancelSeats(numToCancel);
                    break;
                    
                case 3:
                    bus.displayAvailableSeats();
                    break;
                    
                case 4:
                    System.out.println("Thank you for using the Bus Reservation System!");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
