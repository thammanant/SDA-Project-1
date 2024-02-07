import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory extends AbstractInventory implements Originator{
    private List<Book> books = new ArrayList<>();

    private List<InventoryDecorator> commands;

    private final Caretaker caretaker;

    public Inventory() {
        caretaker = new Caretaker();
    }

    // Method to save the current state
    public void save() {
        Memento memento = new ConcreteMemento(this);
        caretaker.add(memento);
    }

    // Method to recover the state to the latest saved state
    public void recover() {
        Memento latestSnapshot = caretaker.get_History();
        if (latestSnapshot != null) {
            latestSnapshot.restore(this);
        }
    }


    public Book get_book_by_id(Integer id) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                return b;
            }
        }
        return null;
    }

    public Book get_book_by_name(String name) {
        for (Book b : books) {
            if (b.get_Name().equals(name)) {
                return b;
            }
        }
        return null;
    }

    public void add_book(String name, Integer price) {

        // Check if book already exists
        for (Book b : books) {
            if (b.get_Name().equals(name)) {
                b.set_Quantity(b.get_Quantity() + 1);
                return; // Return after updating the quantity
            }
        }

        // Book doesn't exist, add it to the array
        Book new_book = new Book(name, price);
        new_book.set_ID(books.size() + 1);
        books.add(new_book);
    }


    public void sell_book(Integer id) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Quantity(b.get_Quantity() - 1);
                return;
            }
        }
    }

    public void add_copies(Integer id, Integer quantity) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Quantity(b.get_Quantity() + quantity);
                return;
            }
        }
    }

    public void change_price(Integer id, Integer price) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Price(price);
                return;
            }
        }
    }

    // get all books
    public List<Book> get_books() {
        return books;
    }

    public String get_books_with_quantity_and_price() {
        StringBuilder result = new StringBuilder();
        for (Book b : books) {
            result.append("ID ").append(b.get_ID()).append(" ,Name-> ").append(b.get_Name()).append(" ,Quantity-> ").append(b.get_Quantity()).append(" ,Price-> ").append(b.get_Price()).append("\n");
        }
        return result.toString();
    }

    public void set_books(List<Book> books) {
        this.books = new ArrayList<>(books); // Deep copy the books list
    }

    public void add_command(Command command) {
        // TODO
    }

    @Override
    public void execute() {
        // TODO
    }
}