public class Customer {
    private String id;
    private String name;
    private String phoneNumber;

    public Customer(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ID Customer: " + id + "\nCustomer Name: " + name + "\nPhone Number: " + phoneNumber;
    }
}

// class CustomerService {
// private ArrayList<Customer> customers = new ArrayList<>();
// private int nextId = 1;

// public void addCustomer(String name) {
// customers.add(new Customer(nextId++, name));
// }

// public ArrayList<Customer> getCustomers() {
// return customers;
// }

// public Customer getCustomerById(int id) {
// for (Customer customer : customers) {
// if (customer.getId() == id) {
// return customer;
// }
// }
// return null;
// }

// public void updateCustomer(int id, String name) {
// Customer customer = getCustomerById(id);
// if (customer != null) {
// customer.setName(name);
// }
// }

// public void deleteCustomer(int id) {
// customers.removeIf(customer -> customer.getId() == id);
// }
// }
