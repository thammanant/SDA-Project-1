public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        AddBookCommand addBookCommand1 = new AddBookCommand("Book1", 100);
        AddBookCommand addBookCommand2 = new AddBookCommand("Book2", 200);
        inventory.add_commands(addBookCommand1, addBookCommand2);
        inventory.save();

        AddBookCopiesCommand addBookCopiesCommand1 = new AddBookCopiesCommand(1, 10);
        SellBookCommand sellBookCommand1 = new SellBookCommand(1);

        inventory.add_commands(addBookCopiesCommand1, sellBookCommand1);
        inventory.recover();
        inventory.print_commands();
    }
}