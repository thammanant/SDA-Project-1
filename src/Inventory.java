import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory extends AbstractInventory implements Originator{
    private List<Book> books = new ArrayList<>();

    private List<Command> commands = new ArrayList<>();

    private final Caretaker caretaker;

    public Inventory() {
        caretaker = new Caretaker();
        
    }

    public Memento save() {
        return new ConcreteMemento(this, caretaker);
    }

    public void recover(Memento memento) {
        memento.restore();
    }

    public String get_description(){
        return commands.toString();
    }

    public Book get_book_by_id(Integer id) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                return b;
            }
        }
        return null;
    }

    public Book get_book_by_name(String name) {
        for (Book b : books) {
            if (b.get_Name().equals(name)) {
                return b;
            }
        }
        return null;
    }

    public void add_book(String name, Integer price) {

        // Check if book already exists
        for (Book b : books) {
            if (b.get_Name().equals(name)) {
                b.set_Quantity(b.get_Quantity() + 1);
                return; // Return after updating the quantity
            }
        }

        // Book doesn't exist, add it to the array
        Book new_book = new Book(name, price);
        books.add(new_book);
    }


    public void sell_book(Integer id) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Quantity(b.get_Quantity() - 1);
            }
        }
    }

    public void add_copies(Integer id, Integer quantity) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Quantity(b.get_Quantity() + quantity);
            }
            else {
                System.out.println("Book not found!");
            }
        }
    }

    public void change_price(Integer id, Integer price) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Price(price);
            }
            else {
                System.out.println("Book not found!");
            }
        }
    }

    // get all books
    public List<Book> get_books() {
        return books;
    }


    //get all books, its ID and quantity
    public String get_books_with_quantity() {
        StringBuilder sb = new StringBuilder();
        for (Book b : books) {
            sb.append("ID ").append(b.get_ID()).append(" : ").append(b.get_Name()).append(" --> ").append(b.get_Quantity()).append("\n");
        }
        return sb.toString();
    }

    public void set_books(List<Book> books) {
        this.books = books;
    }

    // public void add_command(Command commands) {
    //     // TODO
    //     for (Command command : commands){
    //         this.commands.add(command);
    //     }
    //     // commands.add(command);
    // }

    public void addCommands(Command... commands) {
        for (Command command : commands) {
            this.commands.add(command);
        }
    }

    public void print_commands(){
        System.out.println(get_description());
    }

    @Override
    public void execute() {
        // TODO
        for (Command command : commands) {
            command.execute();
        }
        commands.clear();
    }
}
