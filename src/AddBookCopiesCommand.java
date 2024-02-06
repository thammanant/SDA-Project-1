public class AddBookCopiesCommand extends InventoryDecorator{
    public Integer id;
    public Integer quantity;

    public AddBookCopiesCommand(Integer id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        // TODO
        inventory.add_copies(id, quantity);
    }

    @Override
    public String toString() {
        return "AddBookCopiesCommand{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public String get_description() {
        return inventory.get_description() + "AddBookCopiesCommand";
    }
    
}