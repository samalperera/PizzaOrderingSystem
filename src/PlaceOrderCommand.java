class PlaceOrderCommand implements Command {
    private final Order order;

    public PlaceOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("Order placed successfully!");
        order.printStatus();
    }
}
