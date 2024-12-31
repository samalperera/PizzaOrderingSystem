class LeaveFeedbackCommand implements Command {
    private final String feedback;

    public LeaveFeedbackCommand(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public void execute() {
        System.out.println("Feedback submitted: " + feedback);
    }
}

