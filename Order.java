// import java.util.ArrayList;

class Order {
    // private int id;
    // private Customer customer;
    // private ArrayList<OrderItem<Service>> services = new ArrayList<>();
    // private ArrayList<OrderItem<Addons>> addons = new ArrayList<>();
    // private double payment;
    // private double change;

    // public Order(int id, Customer customer) {
    // this.id = id;
    // this.customer = customer;
    // }

    // public int getId() {
    // return id;
    // }

    // public Customer getCustomer() {
    // return customer;
    // }

    // public void addService(Service service, int quantity) {
    // services.add(new OrderItem<>(service, quantity));
    // }

    // public void addAddon(Addons addon, int quantity) {
    // addons.add(new OrderItem<>(addon, quantity));
    // }

    // public ArrayList<OrderItem<Service>> getServices() {
    // return services;
    // }

    // public ArrayList<OrderItem<Addons>> getAddons() {
    // return addons;
    // }

    // public double calculateTotal() {
    // double total = 0;
    // for (OrderItem<Service> serviceItem : services) {
    // total += serviceItem.getItem().getPrice() * serviceItem.getQuantity();
    // }
    // for (OrderItem<Addons> addonItem : addons) {
    // total += addonItem.getItem().getPrice() * addonItem.getQuantity();
    // }
    // return total;
    // }

    // public void setPayment(double payment) {
    // this.payment = payment;
    // }

    // public double getPayment() {
    // return payment;
    // }

    // public void setChange(double change) {
    // this.change = change;
    // }

    // public double getChange() {
    // return change;
    // }
}

// class OrderService {
// private ArrayList<Order> orders = new ArrayList<>();
// private int nextOrderId = 1;

// public void addOrder(Order order) {
// orders.add(order);
// nextOrderId++;
// }

// public Order getOrderById(int id) {
// for (Order order : orders) {
// if (order.getId() == id) {
// return order;
// }
// }
// return null;
// }

// public int getNextOrderId() {
// return nextOrderId;
// }
// }