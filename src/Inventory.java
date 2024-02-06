import java.util.Objects;

public class Inventory extends AbstractInventory implements Originator{
    private Book[] books;

    private InventoryDecorator[] commands;

    private final Caretaker caretaker;

    public Inventory() {
        caretaker = new Caretaker();
    }

    public Memento save() {
        return new ConcreteMemento(this, caretaker);
    }

    public void recover(Memento memento) {
        ((ConcreteMemento) memento).restore();
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
        Book book = new Book(name, price);

        // check if book already exists
        for (Book b : books) {
            if (b.get_Name().equals(name)) {
                b.set_Quantity(b.get_Quantity() + 1);
            } else {
                Book[] newBooks = new Book[books.length + 1];
                System.arraycopy(books, 0, newBooks, 0, books.length);
                books = newBooks;
                books[books.length - 1] = book;
                book.set_ID(books.length);
            }
        }
    }

    public void sell_book(Integer id) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Quantity(b.get_Quantity() - 1);
            }
            else {
                System.out.println("Out of stock!");
            }
        }
    }

    public void add_copies(Integer id, Integer quantity) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Quantity(b.get_Quantity() + quantity);
            }
            else {
                System.out.println("Book not found!");
            }
        }
    }

    public void change_price(Integer id, Integer price) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Price(price);
            }
            else {
                System.out.println("Book not found!");
            }
        }
    }

    public void add_command(Command command) {
        // TODO
    }

    @Override
    public void execute() {
        // TODO
    }
}
