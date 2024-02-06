public class FindBookCommand extends InventoryDecorator{
    public String name;
    public Integer id;

    public FindBookCommand(String name){
        this.name = name;
    }

    public FindBookCommand(Integer id){
        this.id = id;
    }

    @Override
    public void execute() {
        // TODO
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
