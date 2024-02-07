public class AddBookCopiesCommand extends InventoryDecorator{
    private Integer id;
    private Integer quantity;
    private Inventory inventory;


    public AddBookCopiesCommand(Inventory inventory, Integer id, Integer quantity) {
        this.inventory = inventory;
        this.id = id;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        if(inventory != null){
            inventory.add_copies(id, quantity);
        } else {
            System.out.println("Inventory is not initialized properly.");
        }
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