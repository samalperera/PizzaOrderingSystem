import java.util.Scanner;

class SauceHandler implements PizzaCustomizationHandler {
    private PizzaCustomizationHandler next;

    @Override
    public void setNext(PizzaCustomizationHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Pizza.PizzaBuilder builder) {
        System.out.print("Enter sauce type (Tomato, BBQ, Pesto): ");
        builder.setSauce(new Scanner(System.in).nextLine());
        if (next != null) next.handle(builder);
    }
}
