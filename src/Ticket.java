import java.util.Date;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private Date entryTime;
    private String parkingSpot; // parking spot (e.g., 1A, 2A, etc.)

    public Ticket(String ticketId, Vehicle vehicle, String parkingSpot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = new Date(); // get the current time
        this.parkingSpot = parkingSpot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }
}
