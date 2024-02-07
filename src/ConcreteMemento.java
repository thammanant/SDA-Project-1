import java.util.ArrayList;
import java.util.List;

public class ConcreteMemento implements Memento {
    private final List<Book> booksSnapshot;

    public ConcreteMemento(Inventory inventory) {
        // Create a deep copy of the list of books in the inventory
        this.booksSnapshot = new ArrayList<>();
        for (Book book : inventory.get_books()) {
            this.booksSnapshot.add(new Book(book.get_ID(), book.get_Name(), book.get_Price(), book.get_Quantity()));
        }
    }

    @Override
    public void restore(Inventory inventory) {
        inventory.set_books(new ArrayList<>(booksSnapshot));
    }
}
