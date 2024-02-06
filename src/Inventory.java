public class Inventory extends AbstractInventory implements Originator{
    private Book[] books;

    private Command[] commands;

    private Caretaker caretaker;

    public Inventory() {
        caretaker = new Caretaker();
    }

    public Memento save() {
        return new ConcreteMemento(this);
    }

    public void recover(Memento memento) {
        ((ConcreteMemento) memento).restore();
    }

    public Book get_book_by_id(Integer id) {
        // TODO
        return null;
    }

    public Book get_book_by_name(String name) {
        // TODO
        return null;
    }

    public void add_book(Book book) {
        // TODO
    }

    public void sell_book(Book book) {
        // TODO
    }

    public void add_copies(Book book, Integer quantity) {
        // TODO
    }

    public void change_price(Book book, Integer price) {
        // TODO
    }

    public void add_command(Command command) {
        // TODO
    }

    // Execute all commands
    public void execute() {
        // TODO
    }
}
