import java.time.Duration;
import java.time.LocalDateTime;


public class Vehicle {
    private String licensePlate;
    private String vehicleType; 
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double parkingFee;
    public Vehicle(String licensePlate, String vehicleType, LocalDateTime entryTime) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.entryTime = entryTime;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
        calculateParkingFee();
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    public double getParkingFee() {
        return parkingFee;
    }
    protected void calculateParkingFee() {
        
    }
    @Override
    public String toString() {
        
    }
}
