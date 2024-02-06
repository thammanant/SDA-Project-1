public class SellBookCommand extends InventoryDecorator{
    public Integer id;
    

    public SellBookCommand(Integer id) {
        this.id = id;
    }
    @Override
    public void execute() {
        // TODO
        inventory.sell_book(id);
    }
}
