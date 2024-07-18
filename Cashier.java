public class Cashier extends Person {
    public Cashier(String id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
    }

    @Override
    public String toString() {
        return "ID Cashier: " + getId() + "\nCashier Name: " + getName() + "\nPhone Number: " + getPhoneNumber();
    }
}
