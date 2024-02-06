public abstract class InventoryDecorator extends Inventory {
    Inventory inventory;
    InventoryDecorator command;

    @Override
    public void execute() {
        // TODO
    }

    public abstract String toString();

    public abstract String get_description();

}
