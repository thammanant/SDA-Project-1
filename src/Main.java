public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.recover_file();
        System.out.println(inventory.get_books());

        AddBookCommand addBookCommand1 = new AddBookCommand(inventory,"Book1", 100);
        AddBookCopiesCommand addBookCopiesCommand1 = new AddBookCopiesCommand(inventory,1, 10);
        SellBookCommand sellBookCommand1 = new SellBookCommand(inventory,1);



        inventory.add_commands(addBookCommand1, addBookCopiesCommand1, sellBookCommand1);
        inventory.execute();
        System.out.println(inventory.get_books());
        System.out.println(inventory.get_books_with_quantity_and_price());
        inventory.print_commands();
        inventory.save();
        inventory.add_commands(addBookCommand1, addBookCopiesCommand1, sellBookCommand1);
        inventory.execute();
        System.out.println(inventory.get_books_with_quantity_and_price());
        inventory.recover();
        System.out.println(inventory.get_books_with_quantity_and_price());

    }
}