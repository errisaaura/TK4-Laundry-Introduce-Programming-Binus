import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Laundry {

    private List<Customer> customers;
    private List<Service> services;
    private List<Cashier> cashiers;
    private List<Order> orders;
    private static int counterCustomers = 1;
    private static int counterServices = 1;
    private static int counterCashiers = 1;
    private static int counterOrders = 1;
    private static int counterOrderDetails = 1;

    public Laundry() {
        customers = new ArrayList<>();
        services = new ArrayList<>();
        cashiers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    private static String getCurrentDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static String generateId(String type) {
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
    //=========IMPLEMENT EXEPTION HANDLING============
    public void addCustomer(String name, String phoneNumber) {
        try {
            Customer foundCustomer = findCustByNameAndPhoneNumber(name, phoneNumber);
            if (foundCustomer != null) {
                throw new Exception("Customer already exists");
            } else {
                String id = generateId("customer");
                Customer newCust = new Customer(id, name, phoneNumber);
                customers.add(newCust);
                System.out.println("Add Customer successfully");
            }
        } catch (Exception e) {
            System.out.println("Error adding customer: " + e.getMessage());
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

    //==========IMPLEMENT LAMBDA EXPRESSION===========
    public void displayCustomer() {
        if (!customers.isEmpty()) {
            System.out.println("\nList Customers :");
            customers.forEach(customer -> System.out.println(customer + "\n"));
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
    //=========IMPLEMENT EXEPTION HANDLING============
    public void addService(String name, double price) {
        try {
            if (price <= 0) {
                throw new IllegalArgumentException("Price must be greater than zero");
            }
            String id = generateId("service");
            Service newService = new Service(id, name, price);
            services.add(newService);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid service price: " + e.getMessage());
        }
    }

    //==========IMPLEMENT LAMBDA EXPRESSION===========
    public void displayServices() {
        if (!services.isEmpty()) {
            System.out.println("\nList Services :");
            services.forEach(service -> System.out.println(service + "\n"));
        } else {
            System.out.println("No Customer available");
        }
    }

    // Cashier
    public void addCashiers(String name, String phoneNumber) {
        String id = generateId("cashier");

        Cashier newCashier = new Cashier(id, name, phoneNumber);
        cashiers.add(newCashier);
    }

    public Cashier findCashierById(String id) {
        for (Cashier cashier : cashiers) {
            if (cashier.getId().equals(id)) {
                return cashier;
            }
        }
        return null;
    }

    //==========IMPLEMENT LAMBDA EXPRESSION===========
    public void displayCashiers() {
        if (!cashiers.isEmpty()) {
            System.out.println("\nList Cashiers :");
            cashiers.forEach(cashier -> System.out.println(cashier + "\n"));
        } else {
            System.out.println("No Cashier available");
        }
    }

    // Order
    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order findOrderById(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public Service findServiceById(String id) {
        for (Service service : services) {
            if (service.getId().equals(id)) {
                return service;
            }
        }
        return null;
    }

    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            System.out.println("\nList of Orders:");
            for (Order order : orders) {
                System.out.println("Order ID: " + order.getId());
                System.out.println("Customer: " + order.getCustomer().getName());
                System.out.println("Cashier: " + order.getCashier().getName());
                System.out.println("Date: " + order.getDate());
            }
        }
    }

}