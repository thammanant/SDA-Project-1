import java.util.ArrayList;
import java.util.List;

class Caretaker {
    private List<Memento> history = new ArrayList<>();

    public void add(Memento memento) {
        history.add(memento);
    }

}