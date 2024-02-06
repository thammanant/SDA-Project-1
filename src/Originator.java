//public class Originator {
//    private Inventory inventory;
//
//    // Save the current state of the inventory to a memento
//    public Memento save() {
//        return new ConcreteMemento(inventory);
//    }
//
//    // Restore the state from a given memento
//    public void restore(Memento memento) {
//        memento.restore();
//    }
//
//    public void setInventory(Inventory inventory) {
//        this.inventory = inventory;
//    }
//
//    public Inventory getInventory() {
//        return inventory;
//    }
//}

public interface Originator {
    Memento save();
}