public class Cashier {
    private String id;
    private String name;
    private String phoneNumber;

    public Cashier(String id, String name, String phoneNumber) {
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
        return "ID Cashier: " + id + "\nCashier Name: " + name + "\nPhone Number: " + phoneNumber;
    }

}
