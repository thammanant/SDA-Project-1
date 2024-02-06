public class AddBookCommand extends InventoryDecorator{
    public String name;
    public Integer price;

    public AddBookCommand(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void execute() {
        // TODO
        inventory.add_book(name, price);
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
