public class ChangeBookPriceCommand extends InventoryDecorator{
    public Integer id;
    public Integer price;

    public ChangeBookPriceCommand(Integer id, Integer price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public void execute() {
        // TODO
        inventory.change_price(id, price);
    }
}
