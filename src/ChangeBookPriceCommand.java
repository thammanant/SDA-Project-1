public class ChangeBookPriceCommand extends InventoryDecorator{
    private Integer id;
    private Integer price;
    private Inventory inventory;

    public ChangeBookPriceCommand(Integer id, Integer price) {
        this.id = id;
        this.price = price;
    }

    public ChangeBookPriceCommand(Inventory inventory, Integer id, Integer price) {
        this.inventory = inventory;
        this.id = id;
        this.price = price;
    }

    @Override
    public void execute() {
        if (inventory != null) {
            inventory.change_price(id, price);
        } else {
            System.out.println("Inventory is not initialized properly.");
            
        }
    }

    @Override
    public String toString() {
        return "ChangeBookPriceCommand{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    @Override
    public String get_description() {
        return inventory.get_description() + "ChangeBookPriceCommand";
    }
}
