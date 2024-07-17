import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

class Order {
    private String id;
    private Customer customer;
    private Cashier cashier;
    private String date;
    private List<OrderDetail> orderDetails;
    private double totalPrice;
    private double paymentAmount;
    private double change;

    public Order(String id, Customer customer, Cashier cashier) {
        this.id = id;
        this.customer = customer;
        this.cashier = cashier;
        this.date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        this.orderDetails = new ArrayList<>();
        this.totalPrice = 0;
        this.paymentAmount = 0;
        this.change = 0;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public String getDate() {
        return date;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public void addOrderDetail(Service service, int quantity) {
        OrderDetail orderDetail = new OrderDetail(Laundry.generateId("orderdetail"), service, quantity);
        orderDetails.add(orderDetail);
    }
}
