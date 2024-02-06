public class Inventory extends AbstractInventory{
    private Book[] books;

    private InventoryDecorator[] commands;

    public void save() {
        // TODO
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
    @Override
    public void execute() {
        // TODO
    }

    public void recover() {
        // TODO
    }
}
