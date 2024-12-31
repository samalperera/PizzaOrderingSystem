import java.util.ArrayList;
import java.util.List;

class Feedback {
    private static final List<String> feedbackList = new ArrayList<>();


    public static void collectFeedback(String userName, String feedback, int rating) {
        String formattedFeedback = "User: " + userName + " | Feedback: " + feedback + " | Rating: " + rating + "/5";
        feedbackList.add(formattedFeedback);
        System.out.println("Thank you for your feedback!");
    }


    public static void displayFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            System.out.println("\n--- Feedback ---");
            for (String feedback : feedbackList) {
                System.out.println(feedback);
            }
        }
    }
}
