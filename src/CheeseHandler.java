import java.util.Scanner;


class CheeseHandler implements PizzaCustomizationHandler {
    private PizzaCustomizationHandler next;

    @Override
    public void setNext(PizzaCustomizationHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Pizza.PizzaBuilder builder) {
        System.out.print("Enter cheese type (Mozzarella, Cheddar, Vegan): ");
        builder.setCheese(new Scanner(System.in).nextLine());
        if (next != null) next.handle(builder);
    }
}
