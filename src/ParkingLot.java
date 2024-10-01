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
      
    }

    public String checkOut(String ticketId) {
        
    }

    private int calculateFee(long duration, String type) {
        
    }
}
