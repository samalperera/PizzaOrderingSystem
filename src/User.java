import java.util.ArrayList;
import java.util.List;

class User implements Observer {
    private String name;
    private List<Pizza> favoritePizzas;

    public User(String name) {
        this.name = name;
        this.favoritePizzas = new ArrayList<>();
    }

    @Override
    public void update(String status) {
        System.out.println("Notification for " + name + ": " + status);
    }

    public void saveToFavorites(Pizza pizza) {
        favoritePizzas.add(pizza);
        System.out.println("Pizza saved to favorites!");
    }

    public void viewFavorites() {
        if (favoritePizzas.isEmpty()) {
            System.out.println("No favorite pizzas yet.");
        } else {
            System.out.println("Favorite Pizzas:");
            for (int i = 0; i < favoritePizzas.size(); i++) {
                System.out.println((i + 1) + ". " + favoritePizzas.get(i));
            }
        }
    }

    public Pizza getFavoritePizza(int index) {
        if (index > 0 && index <= favoritePizzas.size()) {
            return favoritePizzas.get(index - 1);
        } else {
            throw new IndexOutOfBoundsException("Invalid pizza choice.");
        }
    }

    public List<Pizza> getFavoritePizzaList() {
        return new ArrayList<>(favoritePizzas); // Return a copy of the list
    }
}
