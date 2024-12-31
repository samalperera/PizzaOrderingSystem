import java.util.Scanner;

public class PizzaOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to Pizza Palace! Please enter your name (type 'exit' to quit): ");
        String userName = scanner.nextLine();
        if (shouldExit(userName)) {
            System.out.println("Thank you for visiting Pizza Palace! Goodbye!");
            return;
        }
        User user = new User(userName);

        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        OrderTracker orderTracker = new OrderTracker();
        orderTracker.addObserver(user); // Add user as an observer
        PaymentContext paymentContext = new PaymentContext();
        boolean running = true;

        System.out.println("Welcome, " + userName + "! Let's start your pizza journey.");

        while (running) {
            System.out.println("\nMain Menu (type 'exit' at any prompt to quit):");
            System.out.println("1. Create Custom Pizza");
            System.out.println("2. View Favorites");
            System.out.println("3. Place an Order");
            System.out.println("4. Track an Order");
            System.out.println("5. View Promotions");
            System.out.println("6. Leave Feedback");
            System.out.println("7. Logout");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();
            if (shouldExit(input)) break;

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:

                    Pizza.PizzaBuilder builder1 = new Pizza.PizzaBuilder();
                    PizzaCustomizationHandler crustHandler1 = new CrustHandler();
                    PizzaCustomizationHandler sauceHandler1 = new SauceHandler();
                    PizzaCustomizationHandler cheeseHandler1 = new CheeseHandler();
                    PizzaCustomizationHandler toppingsHandler1 = new ToppingsHandler();

                    crustHandler1.setNext(sauceHandler1);
                    sauceHandler1.setNext(cheeseHandler1);
                    cheeseHandler1.setNext(toppingsHandler1);

                    crustHandler1.handle(builder1);
                    Pizza customPizza = builder1.setName("Custom Pizza").build();
                    System.out.println("\nYour custom pizza: " + customPizza);
                    user.saveToFavorites(customPizza);
                    break;

                case 2:

                    System.out.println(userName + "'s Favorite Pizzas:");
                    user.viewFavorites();
                    break;

                case 3:

                    System.out.println("How would you like to order?");
                    System.out.println("1. Select from Favorites");
                    System.out.println("2. Create a New Pizza");
                    System.out.print("Choose an option: ");
                    String orderOptionInput = scanner.nextLine();
                    if (shouldExit(orderOptionInput)) break;

                    int orderOption;
                    try {
                        orderOption = Integer.parseInt(orderOptionInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Returning to the main menu.");
                        break;
                    }

                    Pizza selectedPizza;
                    if (orderOption == 1) {

                        if (user.getFavoritePizzaList().isEmpty()) {
                            System.out.println("No favorite pizzas available. Please create a pizza first.");
                            break;
                        }

                        System.out.println("Select a pizza from your favorites:");
                        user.viewFavorites();
                        System.out.print("Enter the number of the pizza: ");
                        String pizzaChoiceInput = scanner.nextLine();
                        if (shouldExit(pizzaChoiceInput)) break;

                        int pizzaChoice;
                        try {
                            pizzaChoice = Integer.parseInt(pizzaChoiceInput);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Returning to the main menu.");
                            break;
                        }

                        if (pizzaChoice <= 0 || pizzaChoice > user.getFavoritePizzaList().size()) {
                            System.out.println("Invalid choice. Returning to the main menu.");
                            break;
                        }

                        selectedPizza = user.getFavoritePizza(pizzaChoice);
                    } else if (orderOption == 2) {

                        Pizza.PizzaBuilder builder2 = new Pizza.PizzaBuilder();
                        PizzaCustomizationHandler crustHandler2 = new CrustHandler();
                        PizzaCustomizationHandler sauceHandler2 = new SauceHandler();
                        PizzaCustomizationHandler cheeseHandler2 = new CheeseHandler();
                        PizzaCustomizationHandler toppingsHandler2 = new ToppingsHandler();

                        crustHandler2.setNext(sauceHandler2);
                        sauceHandler2.setNext(cheeseHandler2);
                        cheeseHandler2.setNext(toppingsHandler2);

                        crustHandler2.handle(builder2);
                        selectedPizza = builder2.setName("Custom Pizza").build();
                    } else {
                        System.out.println("Invalid option. Returning to the main menu.");
                        break;
                    }

                    System.out.print("Enter the quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity <= 0) {
                        System.out.println("Quantity must be greater than 0.");
                        break;
                    }


                    double pizzaPrice = 15.00;
                    double subtotal = pizzaPrice * quantity;
                    double tax = subtotal * 0.10; // Assume 10% tax
                    double totalAmount = subtotal + tax;


                    System.out.println("\n--- Bill Summary ---");
                    System.out.println("Pizza: " + selectedPizza.getName());
                    System.out.println("Quantity: " + quantity);
                    System.out.printf("Subtotal: $%.2f\n", subtotal);
                    System.out.printf("Tax (10%%): $%.2f\n", tax);
                    System.out.printf("Total Amount: $%.2f\n", totalAmount);
                    System.out.println("--------------------");

                    System.out.println("\n--- Payment Stage ---");
                    System.out.println("Choose payment method:");
                    System.out.println("1. Credit Card");
                    System.out.println("2. Digital Wallet");
                    System.out.println("3. Cash");
                    System.out.print("Enter your choice: ");
                    int paymentMethod = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the amount to pay: ");
                    double amountPaid = Double.parseDouble(scanner.nextLine());

                    switch (paymentMethod) {
                        case 1 -> paymentContext.setStrategy(new CreditCardPayment());
                        case 2 -> paymentContext.setStrategy(new DigitalWalletPayment());
                        case 3 -> paymentContext.setStrategy(new CashPayment());
                        default -> {
                            System.out.println("Invalid payment method. Returning to the main menu.");
                            continue;
                        }
                    }

                    paymentContext.executePayment(amountPaid);


                    loyaltyProgram.addPoints((int) subtotal / 10);

                    int orderNumber = (int) (Math.random() * 100000);
                    System.out.println("\nOrder Confirmed! Your Order Number: #" + orderNumber);


                    Order order = new Order();
                    order.printStatus(); // Order Placed
                    orderTracker.setStatus("Order Placed: #" + orderNumber);

                    break;

                case 4:

                    System.out.println("Enter your order number to track: ");
                    String orderNumberInput = scanner.nextLine();
                    if (shouldExit(orderNumberInput)) break;

                    System.out.println("\nTracking Order #" + orderNumberInput + ":");
                    orderTracker.setStatus("Order Being Prepared");
                    orderTracker.setStatus("Out for Delivery");
                    orderTracker.setStatus("Delivered");
                    break;

                case 5:

                    Promotions.showCurrentPromotions();
                    break;

                case 6:

                    System.out.println("Leave your feedback:");
                    String feedback = scanner.nextLine();
                    System.out.print("Rate us (1-5): ");
                    int rating = Integer.parseInt(scanner.nextLine());
                    Feedback.collectFeedback(userName, feedback, rating);
                    break;

                case 7:

                    System.out.println("Logging out...");
                    System.out.print("Enter your name: ");
                    userName = scanner.nextLine();
                    user = new User(userName);
                    orderTracker.addObserver(user);
                    break;

                case 8:
                    System.out.println("Thank you for visiting Pizza Palace! Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static boolean shouldExit(String input) {
        return input.equalsIgnoreCase("exit");
    }
}
