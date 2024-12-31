interface PizzaCustomizationHandler {
    void setNext(PizzaCustomizationHandler next);
    void handle(Pizza.PizzaBuilder builder);
}
