import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private final List<Memento> history = new ArrayList<>();

    public void add(Memento memento) {
        history.add(memento);
    }

    public Memento get_History() {
        return history.getLast();
    }
}