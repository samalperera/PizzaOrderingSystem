class PreparingState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new DeliveredState());
    }

    @Override
    public void prev(Order order) {
        order.setState(new OrderPlacedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is being prepared.");
    }
}
