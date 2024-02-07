public class AddBookCommand extends InventoryDecorator{
    private String name;
    private Integer price;
    private Inventory inventory;

    public AddBookCommand(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public AddBookCommand(Inventory inventory, String name, Integer price) {
        this.inventory = inventory;
        this.name = name;
        this.price = price;
    }

    @Override
    public void execute() {
        if (inventory != null) {
            inventory.add_book(name, price);
        } else {
            System.out.println("Inventory is not initialized properly.");
        }
    }

    @Override
    public String toString() {
        return "AddBookCommand{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public String get_description() {
        return inventory.get_description() + "AddBookCommand";
    }
}
