public class SellBookCommand extends InventoryDecorator{
    private Integer id;
    private Inventory inventory;

    public SellBookCommand(Inventory inventory,Integer id) {
        this.inventory = inventory;
        this.id = id;
    }
    @Override
    public void execute() {
        if(inventory != null){
            inventory.sell_book(id);
        } else {
            System.out.println("Inventory is not initialized properly.");
        }
    }
    @Override
    public String toString() {
        return "SellBookCommand{" +
                "id=" + id +
                '}';
    }
    @Override
    public String get_description() {
        return inventory.get_description() + "SellBookCommand";
    }
}
