import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class ToppingsHandler implements PizzaCustomizationHandler {
    private PizzaCustomizationHandler next;

    @Override
    public void setNext(PizzaCustomizationHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Pizza.PizzaBuilder builder) {
        Scanner scanner = new Scanner(System.in); // Ensure Scanner is imported
        List<String> toppings = new ArrayList<>(); // Ensure List and ArrayList are imported
        System.out.println("Enter toppings (type 'done' to finish):");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            toppings.add(topping);
        }
        builder.setToppings(toppings);
        if (next != null) next.handle(builder);
    }
}
