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
