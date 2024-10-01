import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLot {
    private List<Ticket> tickets;
    private int capacity;
    private int ticketCounter = 0; // count the number of tickets issued
    private String[] parkingSpots = {"1A", "2A", "3A", "4A", "5A", "6A", "7A", "8A", "9A", "10A"}; // parking spots

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.tickets = new ArrayList<>();
    }

    public String checkIn(String licensePlate, String type) {
        if (tickets.size() >= capacity) {
            return "Parking lot is full.";
        }
        ticketCounter++;
        String ticketId = "TICKET-" + ticketCounter;
        String parkingSpot = parkingSpots[tickets.size()]; // assign parking spot
        Vehicle vehicle = new Vehicle(licensePlate, type);
        Ticket ticket = new Ticket(ticketId, vehicle, parkingSpot);
        tickets.add(ticket);
        return "Vehicle has been checked in. Ticket ID: " + ticketId + ", Parking Spot: " + parkingSpot;
    }

    public String checkOut(String ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId().equals(ticketId)) {
                tickets.remove(ticket);
                Date exitTime = new Date();
                long duration = (exitTime.getTime() - ticket.getEntryTime().getTime()) / (1000 * 60 * 60); // calculate hours
                int fee = calculateFee(duration, ticket.getVehicle().getType());
                return String.format("Ticket ID: %s, Entry Time: %s, Exit Time: %s, Fee: %d VND", 
                    ticketId, ticket.getEntryTime(), exitTime, fee);
            }
        }
        return "Ticket ID does not exist.";
    }

    private int calculateFee(long duration, String type) {
        int rate = type.equalsIgnoreCase("car") ? 20000 : 10000; // fee based on vehicle type
        return (int) (duration * rate);
    }
}
