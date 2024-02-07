import java.util.ArrayList;
import java.util.List;

public class ConcreteMemento implements Memento {
    private final List<Book> booksSnapshot;

    private final List<Command> CommandsSnapshot;

    public ConcreteMemento(Inventory inventory) {
        // Create a deep copy of the list of books in the inventory
        //commandsnapshot
        this.CommandsSnapshot = new ArrayList<>();
        this.booksSnapshot = new ArrayList<>();
        for (Book book : inventory.get_books()) {
            this.booksSnapshot.add(new Book(book.get_ID(), book.get_Name(), book.get_Price(), book.get_Quantity()));
        }
        for (Command command : inventory.get_commands()) {
            this.CommandsSnapshot.add(command);
        }
    }

    @Override
    public void restore(Inventory inventory) {
        inventory.set_books(new ArrayList<>(booksSnapshot));
        inventory.set_commands(new ArrayList<>(CommandsSnapshot));
    }
}
