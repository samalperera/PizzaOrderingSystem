class LoyaltyProgram {
    private int points;

    public LoyaltyProgram() {
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
        System.out.println("You earned " + points + " points! Total points: " + this.points);
    }

    public void redeemPoints() {
        if (this.points < 10) {
            System.out.println("You need at least 10 points to redeem.");
            return;
        }
        this.points -= 10; // Assume 10 points = $1 discount
        System.out.println("Redeemed 10 points! Remaining points: " + this.points);
    }

    public int getPoints() {
        return points;
    }
}
