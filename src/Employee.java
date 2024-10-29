import java.util.*;


public class Employee {
    private String id;
    private String name;
    private String birthDate;
    private String gender;
    private String position;
    private String address;
    private String phoneNumber;
    private List<Employee> employees;

    public Employee(String id, String name, String birthDate, String gender, String position, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.position = position;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Employee() {
        employees = new ArrayList<>();
    }
    public void add(Employee employee) {
       
    }

    
    public void edit(String id, Employee newEmployeeData) {
        
    }

    
    public void delete(String id) {
        
    }

    
    public Employee find(String id) {
       
    }

    
    public void display() {
        
    }
    @Override
    public String toString() {
        
    }
}
