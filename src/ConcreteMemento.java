class ConcreteMemento implements Memento {
    private Inventory inventory;

    public ConcreteMemento(Inventory inventory) {
        this.inventory = inventory;
    }

//    public String restore() {
//        return inventory;
//    }

    public void restore() {
        System.out.println("Restoring inventory: " + inventory);
    }

}