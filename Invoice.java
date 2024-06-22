class Invoice {
//    public static void printInvoice(Order order, String laundryName, String laundryAddress, String laundryPhon , String cashierName, String cashierAddress, LocalDate date) {
//         System.out.println("=== Invoice ===");
//         System.out.println("Laundry: " + laundryName);
//         System.out.println("Address: " + laundryAddress);
//         System.out.println("Phone: " + laundryPhone);
//         System.out.println();
//         System.out.println("Cashier:");
//         System.out.println("Name: " + cashierName);
//         System.out.println("Address: " + cashierAddress);
//         System.out.println("Date: " + date);
//         System.out.println();
//         System.out.println("Customer:");
//         System.out.println("ID: " + order.getCustomer().getId());
//         System.out.println("Name: " + order.getCustomer().getName());
//         System.out.println();
//         System.out.println("Services:");
//         for (OrderItem<Service> serviceItem : order.getServices()) {
//             Service service = serviceItem.getItem();
//             System.out.println(service.getName() + " - " + service.getPrice() + "/kg - " + serviceItem.getQuantit() + " kg - " + (service.getPrice() * serviceItem.getQuantity()));
//         }
//         System.out.println();
//         System.out.println("Addons:");
//         for (OrderItem<Addon> addonItem : order.getAddons()) {
//             Addon addon = addonItem.getItem();
//             System.out.println(addon.getName() + " - " + addon.getPrice() + "/unit - " + addonItem.getQuantit() + " unit - " + (addon.getPrice() * addonItem.getQuantity()));
//         }
//         System.out.println();
//         double total = order.calculateTotal();
//         System.out.println("Total: " + total);
//         System.out.println("Payment: " + order.getPayment());
//         System.out.println("Change: " + order.getChange());
//     }

}