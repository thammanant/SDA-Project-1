public class FindBookCommand extends InventoryDecorator{
    private String name;
    private Integer id;
    private Inventory inventory;


    public FindBookCommand(Inventory inventory, String name){
        this.inventory = inventory;
        this.name = name;
    }

    public FindBookCommand(Inventory inventory, Integer id){
        this.inventory = inventory;
        this.id = id;
    }

    @Override
    public void execute() {
        if (name != null) {
            inventory.get_book_by_name(name);
        } else if (id != null) {
            inventory.get_book_by_id(id);
            
        } else {
            System.out.println("Invalid input");
        }
    }

    @Override
    public String toString() {
        return "FindBookCommand{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public String get_description() {
        return inventory.get_description() + "FindBookCommand";
    }
}
