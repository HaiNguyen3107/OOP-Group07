public class Vehicle {
    private String vehicleID;
    private String vehicleType;
    private String licensePlate;
    private Date entryTime;
    private Date exitTime;

    public String getVehicleID() {
        return vehicleID;
    }

    public String getVehicleType() {
        return vehicleType;
    }
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    } 

}
