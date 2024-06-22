
// import java.util.ArrayList;
import java.util.Scanner;
// import java.time.LocalDate;

public class Main {
    private static final String LAUNDRY_NAME = "Laundry Express";
    private static final String LAUNDRY_ADDRESS = "Jl. Merdeka No. 1";
    private static final String LAUNDRY_PHONE = "08123456789";

    static Scanner scanner = new Scanner(System.in);
    static Laundry laundry = new Laundry();

    public static void main(String[] args) {
        while (true) {
            // Display laundry description
            System.out.println("=== Laundry Info ===");
            System.out.println("Name: " + LAUNDRY_NAME);
            System.out.println("Address: " + LAUNDRY_ADDRESS);
            System.out.println("Phone: " + LAUNDRY_PHONE);
            System.out.println();

            // ini function add cashier dr inputan
            System.out.println("Enter cashier name : ");
            String cashName = scanner.nextLine();

            System.out.println("Enter cashier phone number : ");
            String cashPhoneNumber = scanner.nextLine();

            laundry.addCashiers(cashName, cashPhoneNumber);

            // ini function add service langsung tanpa inputan
            laundry.addService("Cuci Kering", 6000);
            laundry.addService("Cuci Setrika", 8000);
            laundry.addService("Setrika", 5000);
            laundry.addService("Jaket", 10000);
            laundry.addService("Sprei", 20000);

            System.out.println("==========List Layanan===============");

            laundry.displayServices();

            System.out.println("Menu:");
            System.out.println("1. Menu Customer");
            System.out.println("2. Create Order");
            System.out.println("3. Create Invoice Order");
            System.out.print("Choose an option [0:Exit Application]: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    exitApplication();
                    break;
                case 1:
                    customerMenu();
                    break;
                case 2:
                    // laundry.createOrder();
                    // handleCreateOrder(scanner, customerService, orderService, services, addons,
                    // cashierName, cashierAddress, date);
                    break;
                case 3:
                    // laundry.createInvoiceOrder();
                    // handleCreateInvoice(scanner, orderService, cashierName, cashierAddress,
                    // date);
                    break;
                default:
                    System.out.println("Invalid option menu");
            }
        }
    }

    public static void customerMenu() {
        while (true) {
            System.out.println("\n============================== Customer Menu ==============================");
            System.out.println("1. Add Customer");
            System.out.println("2. Delete Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. View Customers");
            System.out.print("Choose an option [0:Exit Application]: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    return;
                case 1:
                    System.out.println("Enter customer name : ");
                    String custName = scanner.nextLine();

                    System.out.println("Enter customer phone number : ");
                    String custPhoneNumber = scanner.nextLine();

                    laundry.addCustomer(custName, custPhoneNumber);
                    break;
                case 2:
                    System.out.println("Enter customer id : ");
                    String custId = scanner.nextLine();

                    laundry.deleteCustomer(custId);
                    break;
                case 3:
                    System.out.println("Enter customer id");
                    String idCustUpdate = scanner.nextLine();

                    Customer findCust = laundry.findCustById(idCustUpdate);
                    if (findCust != null) {
                        System.out.println("Enter customer name : ");
                        String custNewName = scanner.nextLine();

                        System.out.println("Enter customer phone number : ");
                        String custNewPhoneNumber = scanner.nextLine();

                        laundry.updateCustomer(idCustUpdate, custNewName, custNewPhoneNumber);
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;
                case 4:
                    laundry.displayCustomer();
                    break;
                default:
                    break;
            }
        }
    }

    public static void exitApplication() {
        System.out.println("Exiting the program. Thank you!");
        System.exit(0);
    }

    // private static void handleCRUDCustomer(Scanner scanner, CustomerService
    // customerService) {
    // System.out.println("CRUD Customer:");
    // System.out.println("1. Add Customer");
    // System.out.println("2. List Customers");
    // System.out.println("3. Update Customer");
    // System.out.println("4. Delete Customer");
    // System.out.print("Choose an option: ");
    // int option = scanner.nextInt();
    // scanner.nextLine(); // consume newline

    // switch (option) {
    // case 1:
    // System.out.print("Enter customer name: ");
    // String name = scanner.nextLine();
    // customerService.addCustomer(name);
    // break;
    // case 2:
    // for (Customer customer : customerService.getCustomers()) {
    // System.out.println(customer);
    // }
    // break;
    // case 3:
    // System.out.print("Enter customer ID to update: ");
    // int updateId = scanner.nextInt();
    // scanner.nextLine(); // consume newline
    // System.out.print("Enter new customer name: ");
    // String newName = scanner.nextLine();
    // customerService.updateCustomer(updateId, newName);
    // break;
    // case 4:
    // System.out.print("Enter customer ID to delete: ");
    // int deleteId = scanner.nextInt();
    // customerService.deleteCustomer(deleteId);
    // break;
    // default:
    // System.out.println("Invalid option.");
    // }
    // }

    // private static void handleCreateOrder(Scanner scanner, CustomerService
    // customerService, OrderService orderService, ArrayList<Service> services,
    // ArrayList<Addon> addons, String cashierName, String cashierAddress, LocalDate
    // date) {
    // System.out.print("Enter customer ID for order: ");
    // int customerId = scanner.nextInt();
    // Customer customer = customerService.getCustomerById(customerId);
    // if (customer == null) {
    // System.out.println("Customer not found.");
    // return;
    // }

    // Order order = new Order(orderService.getNextOrderId(), customer);

    // // Select services
    // System.out.println("Select services (enter 0 to stop):");
    // while (true) {
    // for (Service service : services) {
    // System.out.println(service.getId() + ". " + service.getName() + " - " +
    // service.getPrice() + "/kg");
    // }
    // System.out.print("Choose a service by ID: ");
    // int serviceId = scanner.nextInt();
    // if (serviceId == 0) break;

    // Service selectedService = null;
    // for (Service service : services) {
    // if (service.getId() == serviceId) {
    // selectedService = service;
    // break;
    // }
    // }
    // if (selectedService == null) {
    // System.out.println("Invalid service ID.");
    // continue;
    // }

    // System.out.print("Enter quantity for " + selectedService.getName() + " (kg):
    // ");
    // int quantity = scanner.nextInt();
    // order.addService(selectedService, quantity);
    // }

    // // Add order to order service
    // orderService.addOrder(order);

    // // Payment
    // System.out.print("Enter payment amount: ");
    // double payment = scanner.nextDouble();
    // double total = order.calculateTotal();
    // double change = payment - total;

    // if (change < 0) {
    // System.out.println("Insufficient payment. Please pay at least: " + total);
    // } else {
    // order.setPayment(payment);
    // order.setChange(change);
    // System.out.println("Change: " + change);
    // }
    // }

    // private static void handleCreateInvoice(Scanner scanner, OrderService
    // orderService, String cashierName, String cashierAddress, LocalDate date) {
    // System.out.print("Enter order ID to create invoice: ");
    // int orderId = scanner.nextInt();
    // Order order = orderService.getOrderById(orderId);
    // if (order == null) {
    // System.out.println("Order not found.");
    // return;
    // }

    // // Print invoice
    // Invoice.printInvoice(order, LAUNDRY_NAME, LAUNDRY_ADDRESS, LAUNDRY_PHONE,
    // cashierName, cashierAddress, date);
    // }
}