class OrderDetail {
    private String id;
    private Service service;
    private int quantity;

    public OrderDetail(String id, Service service, int quantity) {
        this.id = id;
        this.service = service;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public Service getService() {
        return service;
    }

    public int getQuantity() {
        return quantity;
    }
}