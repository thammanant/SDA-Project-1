import java.util.ArrayList;
import java.util.List;

class Caretaker {
    private final List<Memento> history = new ArrayList<>();

    // Method to add a memento to history
    public void add(Memento inventory) {
        history.add(inventory);
    }

    // Method to get the latest memento
    public Memento get_History() {
        return history.isEmpty() ? null : history.getLast();
    }
}