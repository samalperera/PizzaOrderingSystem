abstract class PizzaDecorator {
    protected final Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getName() {
        return pizza.getName();
    }
}
