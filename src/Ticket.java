import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Ticket extends Vehicle {
    private boolean isMonthlyTicket;
    private LocalDateTime monthlyTicketExpiryDate;
    private static List<Ticket> tickets = new ArrayList<>();
    public Ticket(String licensePlate, String vehicleType, LocalDateTime entryTime, boolean isMonthlyTicket, LocalDateTime expiryDate) {
      
    }

    private void registerMonthlyTicket() {
        
    }
    @Override
    protected void calculateParkingFee() {
     
    }
    public static void displayAllTickets() {
       
    }
    @Override
    public String toString() {
        
    }
}
