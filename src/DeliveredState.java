class DeliveredState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("The order is already delivered.");
    }

    @Override
    public void prev(Order order) {
        order.setState(new PreparingState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order has been delivered.");
    }
}
