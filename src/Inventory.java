import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

public class Inventory extends AbstractInventory implements Originator, Serializable{
    private List<Book> books = new ArrayList<>();
    private List<Command> commands = new ArrayList<>();

    private transient WriteToLog log = new WriteToLog();
    private final Caretaker caretaker;

    public Inventory() {
        caretaker = new Caretaker();
        
    }

    // Method to save the current state
    public void save() {
        Memento memento = new ConcreteMemento(this);
        caretaker.add(memento);
        ConcreteMemento re = new ConcreteMemento(this);
        String recoverFile = "recover.txt";
        try (FileOutputStream fileOutputStream = new FileOutputStream(recoverFile);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(re);
            log.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to recover the state to the latest saved state
    public void recover() {
        String recoverFile = "recover.txt";
        try {
            File file = new File(recoverFile);
            if (!file.exists()) {
                // If the file doesn't exist, create a new one
                System.out.println("Inventory file not found. Creating a new file.");
                if (file.createNewFile()) {
                    System.out.println("New inventory file created successfully.");
                } else {
                    System.err.println("Failed to create new inventory file.");
                    return;
                }
            }

            if (file.length() == 0) {
                // If the file is empty, don't read it
                System.err.println("Inventory file is empty. Skipping loading process.");
                return;
            }

            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                // Deserialize the memento object from the file
                ConcreteMemento memento = (ConcreteMemento) objectInputStream.readObject();
                memento.restore(this);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Inventory file not found. Skipping loading process.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error occurred during loading. Skipping loading process.");
        }


        // Read lines from file
        String[] lines = log.read();

        // Check if there are lines in the log
        if (lines.length > 0) {
            // Get the last line
            String lastLine = lines[lines.length - 1];

            // Find the index of the last opening bracket '[' and closing bracket ']'
            int startIndex = lastLine.lastIndexOf("[");
            int endIndex = lastLine.lastIndexOf("]");

            // Check if both brackets are found and startIndex is before endIndex
            if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
                // Extract the substring between the last '[' and ']'
                String commandsContent = lastLine.substring(startIndex + 1, endIndex);
                // Split the commands content by }, to get individual commands
                String[] commands = commandsContent.split("},");
                for (String command : commands) {
                    command += "}";
                    // Parse individual command
                    String[] parts = command.split("[{},]");
                    String commandType = parts[0];
                    // Remove whitespace from command type
                    commandType = commandType.trim();
                    switch (commandType) {
                        // Handle each command type accordingly
                        case "AddBookCommand":
                            String bookName = parts[1];
                            int price = Integer.parseInt(parts[2]);
                            add_commands(new AddBookCommand(this, bookName, price));
                            System.out.println("Added book: " + bookName + " with price: " + price);
                            break;
                        case "AddBookCopiesCommand":
                            int id = Integer.parseInt(parts[1]);
                            int quantity = Integer.parseInt(parts[2]);
                            add_commands(new AddBookCopiesCommand(this, id, quantity));
                            System.out.println("Added " + quantity + " copies of book with ID: " + id);
                            break;
                        case "SellBookCommand":
                            int sellId = Integer.parseInt(parts[1]);
                            add_commands(new SellBookCommand(this, sellId));
                            System.out.println("Sold book with ID: " + sellId);
                            break;
                        case "FindBookCommand":
                            String paramName = parts[1];
                            String paramValue = parts[2];
                            if (paramValue.equals("null")) {
                                add_commands(new FindBookCommand(this, paramName));
                                System.out.println("Found book by name: " + paramName);
                            } else {
                                int findId = Integer.parseInt(paramValue);
                                add_commands(new FindBookCommand(this, findId));
                                System.out.println("Found book by ID: " + findId);
                            }
                            break;
                        case "ChangeBookPriceCommand":
                            int changeId = Integer.parseInt(parts[1]);
                            int newPrice = Integer.parseInt(parts[2]);
                            add_commands(new ChangeBookPriceCommand(this, changeId, newPrice));
                            System.out.println("Changed price of book with ID: " + changeId + " to: " + newPrice);
                            break;

                        default:
                            System.out.println("Unsupported command type: " + commandType);
                    }
                }
            } else {
                System.out.println("Invalid log line format: " + lastLine);
            }
        } else {
            System.out.println("Log file is empty.");
        }


        // Execute commands
        this.execute();
        // Clear the log after successful execution
        log.clear();

    }


    public String get_description(){
        return commands.toString();
    }

    public Book get_book_by_id(Integer id) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                System.out.println("Name: " + b.get_Name() + "\nID: "+ b.get_ID() + "\nQuantity: " + b.get_Quantity() + "\nPrice: " + b.get_Price() + "\n");
                return b;
            }
        }
        return null;
    }

    public Book get_book_by_name(String name) {
        for (Book b : books) {
            if (b.get_Name().equals(name)) {
                System.out.println("Name: " + b.get_Name() + "\nID: " + b.get_ID() + "\nQuantity: " + b.get_Quantity() + "\nPrice: " + b.get_Price() + "\n");
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
                return;
            }
        }

        // Book doesn't exist, add it to the array
        Book new_book = new Book(name, price);
        new_book.set_ID(books.size() + 1);
        books.add(new_book);
    }


    public void sell_book(Integer id) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Quantity(b.get_Quantity() - 1);
                return;
            }
        }
    }

    public void add_copies(Integer id, Integer quantity) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Quantity(b.get_Quantity() + quantity);
                return;
            }
        }
    }

    public void change_price(Integer id, Integer price) {
        for (Book b : books) {
            if (Objects.equals(b.get_ID(), id)) {
                b.set_Price(price);
                return;
            }
        }
    }

    // get all books
    public List<Book> get_books() {
        return books;
    }

    // get all commands
    public List<Command> get_commands() {
        return commands;
    }

    public String get_books_with_quantity_and_price() {
        StringBuilder result = new StringBuilder();
        for (Book b : books) {
            result.append("ID ").append(b.get_ID()).append(" ,Name-> ").append(b.get_Name()).append(" ,Quantity-> ").append(b.get_Quantity()).append(" ,Price-> ").append(b.get_Price()).append("\n");
        }
        return result.toString();
    }

    public void set_books(List<Book> books) {
        this.books = new ArrayList<>(books); // set the books list
    }

    public void set_commands(List<Command> commands) {
        this.commands = new ArrayList<>(commands); // set the commands list
    }

    public void add_commands(Command... commands) {
        for (Command command : commands) {
            this.commands.add(command);
            log.write(get_description());
        }
    }

    public void print_commands(){
        System.out.println(get_description());
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
        commands.clear();
    }
}