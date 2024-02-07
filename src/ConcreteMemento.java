import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConcreteMemento implements Memento, Serializable {
    private final List<Book> booksSnapshot;

    private final List<Command> CommandsSnapshot;

    public ConcreteMemento(Inventory inventory) {
        // Create a deep copy of the list of books in the inventory
        //command snapshot
        this.CommandsSnapshot = new ArrayList<>();
        this.booksSnapshot = new ArrayList<>();
        for (Book book : inventory.get_books()) {
            this.booksSnapshot.add(new Book(book.get_ID(), book.get_Name(), book.get_Price(), book.get_Quantity()));
        }
        this.CommandsSnapshot.addAll(inventory.get_commands());
    }

    @Override
    public void restore(Inventory inventory) {
        inventory.set_books(new ArrayList<>(booksSnapshot));
        inventory.set_commands(new ArrayList<>(CommandsSnapshot));
    }
}
