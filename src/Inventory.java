public class Inventory extends AbstractInventory implements Originator{
    private Book[] books;

    private InventoryDecorator[] commands;

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

    public void add_book(String name, Integer price) {
        // TODO
    }

    public void sell_book(Integer id) {
        // TODO
    }

    

    public void add_copies(Integer id, Integer quantity) {
        // TODO
    }

    public void change_price(Integer id, Integer price) {
        // TODO
    }

    public void add_command(Command command) {
        // TODO
    }

    // Execute all commands
    @Override
    public void execute() {
        // TODO
    }
}
