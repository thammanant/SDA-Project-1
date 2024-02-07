public abstract class InventoryDecorator extends Inventory {
    Inventory inventory;

    @Override
    public void execute() {}

    public abstract String toString();

    public abstract String get_description();

}
