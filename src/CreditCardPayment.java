import java.util.Scanner;

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("\n--- Credit Card Payment ---");

        System.out.print("Enter Cardholder Name: ");
        String cardHolderName = scanner.nextLine();


        System.out.print("Enter Card Number (16 digits): ");
        String cardNumber = scanner.nextLine();
        while (!isValidCardNumber(cardNumber)) {
            System.out.print("Invalid card number. Please enter a 16-digit card number: ");
            cardNumber = scanner.nextLine();
        }


        System.out.print("Enter Expiration Date (MM/YY): ");
        String expirationDate = scanner.nextLine();
        while (!isValidExpirationDate(expirationDate)) {
            System.out.print("Invalid expiration date. Please enter a valid date (MM/YY): ");
            expirationDate = scanner.nextLine();
        }


        System.out.print("Enter CVV Code (3 digits): ");
        String cvv = scanner.nextLine();
        while (!isValidCVV(cvv)) {
            System.out.print("Invalid CVV. Please enter a 3-digit code: ");
            cvv = scanner.nextLine();
        }


        System.out.printf("Processing payment of $%.2f using credit card...\n", amount);
        System.out.println("Payment Successful! Thank you for your purchase.");
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{16}");
    }


    private boolean isValidExpirationDate(String expirationDate) {
        return expirationDate.matches("(0[1-9]|1[0-2])/\\d{2}");
    }

    private boolean isValidCVV(String cvv) {
        return cvv.matches("\\d{3}");
    }
}
