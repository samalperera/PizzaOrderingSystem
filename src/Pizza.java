import java.util.List;

class Pizza {
    private final String crust;
    private final String sauce;
    private final String cheese;
    private final List<String> toppings;
    private final String name;

    private Pizza(PizzaBuilder builder) {
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pizza \"" + name + "\" [Crust: " + crust + ", Sauce: " + sauce +
                ", Cheese: " + cheese + ", Toppings: " + toppings + "]";
    }

    public static class PizzaBuilder {
        private String crust;
        private String sauce;
        private String cheese;
        private List<String> toppings;
        private String name;

        public PizzaBuilder setCrust(String crust) {
            this.crust = crust;
            return this;
        }

        public PizzaBuilder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder setCheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder setToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        public PizzaBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

