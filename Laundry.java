import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// services.add(new Service(1, "Cuci Lipat", 6000));
// services.add(new Service(2, "Cuci Setrika", 8000));
// services.add(new Service(3, "Setrika", 5000));

public class Laundry {

    private List<Customer> customers;
    private List<Service> services;
    private List<Cashier> cashiers;
    // private List<Order> orders;
    private static int counterCustomers = 1;
    private static int counterServices = 1;
    private static int counterCashiers = 1;
    private static int counterOrders = 1;
    private static int counterOrderDetails = 1;

    public Laundry() {
        customers = new ArrayList<>();
        services = new ArrayList<>();
        cashiers = new ArrayList<>();
        // orders = new ArrayList<>();
    }

    private static String getCurrentDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    private static String generateId(String type) {
        String dateNow = getCurrentDate();

        switch (type) {
            case "customer":
                return dateNow + "CUS" + String.format("%04d", counterCustomers++);
            case "service":
                return dateNow + "SVC" + String.format("%04d", counterServices++);
            case "cashier":
                return dateNow + "CSH" + String.format("%04d", counterCashiers++);
            case "order":
                return dateNow + "ORD" + String.format("%04d", counterOrders++);
            case "orderdetail":
                return dateNow + "ORT" + String.format("%04d", counterOrderDetails++);
            default:
                throw new AssertionError();
        }
    }

    // Customer
    public void addCustomer(String name, String phoneNumber) {
        Customer foundCustomer = findCustByNameAndPhoneNumber(name, phoneNumber);
        if (foundCustomer != null) {
            System.out.println("Customer already exist");
        } else {
            String id = generateId("customer");

            Customer newCust = new Customer(id, name, phoneNumber);
            customers.add(newCust);

            System.out.println("Add Customer successfully");
        }
    }

    public void updateCustomer(String id, String newName, String newPhoneNumber) {
        Customer customer = findCustById(id);
        if (customer != null) {
            customer.setName(newName);
            customer.setPhoneNumber(newPhoneNumber);
            System.out.println("Update Customer successfully");
        } else {
            System.out.println("Customer not found");
        }
    }

    public void deleteCustomer(String id) {
        Customer foundCustomer = findCustById(id);
        if (foundCustomer != null) {
            customers.remove(foundCustomer);

            System.out.println("Delete Customer successfully");
        } else {
            System.out.println("Customer not found");
        }
    }

    public void displayCustomer() {
        if (!(customers.isEmpty())) {
            System.out.println("\nList Customers:");
            for (int i = 1; i <= customers.size(); i++) {
                System.out.println(customers.get(i - 1) + "\n");
            }
        } else {
            System.out.println("No Customer available");
        }
    }

    public Customer findCustById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public Customer findCustByNameAndPhoneNumber(String name, String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name) && customer.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return customer;
            }
        }
        return null;
    }

    // Service
    public void addService(String name, double price) {
        String id = generateId("service");

        Service newService = new Service(id, name, price);
        services.add(newService);
    }

    public void displayServices() {
        System.out.println("\nList of Services:");
        for (int i = 1; i <= services.size(); i++) {
            System.out.println("Service#" + i);
            System.out.println(services.get(i - 1) + "\n");
        }

    }

    // Cashier
    public void addCashiers(String name, String phoneNumber) {
        String id = generateId("cashier");

        Cashier newCashier = new Cashier(id, name, phoneNumber);
        cashiers.add(newCashier);
    }

    // Order
    // public void createOrder() {
    // LocalDate date = LocalDate.now();
    // System.out.println("Date: " + date);
    // System.out.println();
    // }

    // InvoiceOrder
    // public void createInvoiceOrder() {

    // }

}