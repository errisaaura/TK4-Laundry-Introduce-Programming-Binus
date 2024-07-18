public class Customer extends Person {
    public Customer(String id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
    }

    @Override
    public String toString() {
        return "ID Customer: " + getId() + "\nCustomer Name: " + getName() + "\nPhone Number: " + getPhoneNumber();
    }
}
