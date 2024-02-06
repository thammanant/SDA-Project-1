public class ConcreteMemento implements Memento {
    private Inventory inventory;
    private final Caretaker caretaker;

    public ConcreteMemento(Inventory inventory, Caretaker caretaker) {
        this.inventory = inventory;
        this.caretaker = caretaker;
    }

    @Override
    public void restore() {
        Memento lastMemento = caretaker.get_History();
        if (lastMemento instanceof ConcreteMemento lastConcreteMemento) {
            Inventory lastInventory = lastConcreteMemento.getInventory();
            // Restore inventory state
            this.inventory = lastInventory;
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
