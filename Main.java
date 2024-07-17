import java.util.Scanner;

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

            // ini function add service langsung tanpa inputan
            laundry.addService("Cuci Kering", 6000);
            laundry.addService("Cuci Setrika", 8000);
            laundry.addService("Setrika", 5000);
            laundry.addService("Jaket", 10000);
            laundry.addService("Sprei", 20000);

            // laundry.addCustomer("errisa", "88"); //for testing

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
                    createOrder();
                    break;
                case 3:
                    createInvoiceOrder();
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
                    System.out.print("Enter customer name: ");
                    String custName = scanner.nextLine();

                    System.out.print("Enter customer phone number: ");
                    String custPhoneNumber = scanner.nextLine();

                    laundry.addCustomer(custName, custPhoneNumber);
                    break;
                case 2:
                    System.out.print("Enter customer id: ");
                    String custId = scanner.nextLine();

                    laundry.deleteCustomer(custId);
                    break;
                case 3:
                    System.out.print("Enter customer id: ");
                    String idCustUpdate = scanner.nextLine();

                    Customer findCust = laundry.findCustById(idCustUpdate);
                    if (findCust != null) {
                        System.out.print("Enter customer name: ");
                        String custNewName = scanner.nextLine();

                        System.out.print("Enter customer phone number: ");
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


    public static void createOrder() {
        System.out.print("Enter cashier name : ");
        String cashName = scanner.nextLine();

        System.out.print("Enter cashier phone number : ");
        String cashPhoneNumber = scanner.nextLine();

        laundry.addCashiers(cashName, cashPhoneNumber);
    
        laundry.displayCustomer();
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = laundry.findCustById(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        laundry.displayCashiers();
        System.out.print("Enter cashier ID: ");
        String cashierId = scanner.nextLine();
        Cashier cashier = laundry.findCashierById(cashierId);
        if (cashier == null) {
            System.out.println("Cashier not found!");
            return;
        }

        String idOrder = Laundry.generateId("order");

        Order newOrder = new Order(idOrder, customer, cashier);

        while (true) {
            laundry.displayServices();
            System.out.print("Enter service ID to add (or 'done' to finish): ");
            String serviceId = scanner.nextLine();
            if (serviceId.equalsIgnoreCase("done")) {
                break;
            }

            Service service = laundry.findServiceById(serviceId);
            if (service == null) {
                System.out.println("Service not found!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            newOrder.addOrderDetail(service, quantity);
        }

        // Display order details and total price
        System.out.println("\nOrder ID: " + newOrder.getId());
        System.out.println("Customer: " + newOrder.getCustomer().getName());
        System.out.println("Cashier: " + newOrder.getCashier().getName());
        System.out.println("Date: " + newOrder.getDate());
        System.out.println("\n=== Order Details ===");

        double totalPrice = 0;
        for (OrderDetail detail : newOrder.getOrderDetails()) {
            Service service = detail.getService();
            int quantity = detail.getQuantity();
            double price = service.getPrice() * quantity;
            totalPrice += price;
            System.out.println("Service: " + service.getName() + ", Quantity: " + quantity + ", Price: " + price);
        }

        System.out.println("\nTotal Price: " + totalPrice);

        System.out.print("Enter payment amount: ");
        double paymentAmount = scanner.nextDouble();
        scanner.nextLine();

        if (paymentAmount < totalPrice) {
            System.out.println("Insufficient payment amount. Order cannot be processed.");
            return;
        }

        double change = paymentAmount - totalPrice;
        newOrder.setPaymentAmount(paymentAmount);
        newOrder.setChange(change);

        System.out.println("Payment: " + paymentAmount);
        System.out.println("Change: " + change);

        laundry.addOrder(newOrder);

        
    }

    public static void createInvoiceOrder() {
        laundry.displayOrders();

        System.out.print("Enter order ID: ");
        String orderId = scanner.nextLine();
        Order order = laundry.findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found!");
            return;
        }

        System.out.println("========= Invoice =========");
        System.out.println("Laundry: " + LAUNDRY_NAME);
        System.out.println("Address: " + LAUNDRY_ADDRESS);
        System.out.println("Phone: " + LAUNDRY_PHONE);
        System.out.println();
        System.out.println("Order ID: " + order.getId());
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Cashier: " + order.getCashier().getName());
        System.out.println("Date: " + order.getDate()); 
        System.out.println();
        System.out.println("Services:");
        double total = 0;
        for (OrderDetail detail : order.getOrderDetails()) {
            System.out.println("- " + detail.getService().getName() + " x" + detail.getQuantity() + " = " + (detail.getService().getPrice() * detail.getQuantity()));
            total += detail.getService().getPrice() * detail.getQuantity();
        }
        System.out.println("Total: " + total);
        System.out.println("Payment: " + order.getPaymentAmount());
        System.out.println("Change: " + order.getChange());
        System.out.println("==================");
    }
}
