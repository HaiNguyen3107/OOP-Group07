import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ParkingLot {
    private List<Vehicle> parkedVehicles;
    private int totalSpaces;
    private int occupiedSpaces;

    
    public ParkingLot(int totalSpaces) {
        this.totalSpaces = totalSpaces;
        this.parkedVehicles = new ArrayList<>();
        this.occupiedSpaces = 0;
    }

    
    public void parkVehicle(Vehicle vehicle) {
        
    }

    
    public void unparkVehicle(String licensePlate) {
       
    }

   
    public void displayParkedVehicles() {
      
    }

   
    public int getAvailableSpaces() {
        return totalSpaces - occupiedSpaces;
    }
}
