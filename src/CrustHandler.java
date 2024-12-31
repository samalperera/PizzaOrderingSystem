import java.util.Scanner;

class CrustHandler implements PizzaCustomizationHandler {
    private PizzaCustomizationHandler next;

    @Override
    public void setNext(PizzaCustomizationHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Pizza.PizzaBuilder builder) {
        Scanner scanner = new Scanner(System.in); // Import required here
        System.out.print("Enter crust type (Thin, Thick, Stuffed): ");
        builder.setCrust(scanner.nextLine());
        if (next != null) next.handle(builder);
    }
}
