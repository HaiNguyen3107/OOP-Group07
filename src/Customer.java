public class Customer {
    private int id;
    private String name;
    private String dob;
    private String gender;
    private String phoneNumber;
    private String address;
    private Vehicle vehicle;
    private Ticket ticket;

    public String getDetails() {

    }

    public void addCustomer(Customer customer) {
        customerDatabase.put(customer.getId(), customer);
    }

    public void removeCustomer(int customerId) {

    }

    public Customer findCustomerById(int customerId) {

    }

    public List<Customer> listAllCustomers() {

    }

    public void updateCustomer(Customer customer) {

    }

    public void associateVehicle(int customerId, Vehicle vehicle) {

    }
}