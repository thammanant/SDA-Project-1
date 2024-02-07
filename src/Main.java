public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.recover();
        System.out.println(inventory.get_books());

        AddBookCommand addBookCommand1 = new AddBookCommand(inventory,"Book1", 100);
        AddBookCommand addBookCommand2 = new AddBookCommand(inventory,"Book2", 200);
        AddBookCommand addBookCommand3 = new AddBookCommand(inventory,"Book3", 300);
        AddBookCopiesCommand addBookCopiesCommand1 = new AddBookCopiesCommand(inventory,1, 10);
        SellBookCommand sellBookCommand1 = new SellBookCommand(inventory,1);
        FindBookCommand findBookCommand1 = new FindBookCommand(inventory,"Book1");
        ChangeBookPriceCommand changeBookPriceCommand1 = new ChangeBookPriceCommand(inventory,1, 150);



        inventory.add_commands(addBookCommand1,addBookCommand2, addBookCommand3, addBookCopiesCommand1, sellBookCommand1,findBookCommand1,changeBookPriceCommand1);
        inventory.print_commands();
        inventory.execute();
        inventory.save();
        System.out.println(inventory.get_books_with_quantity_and_price());


//        inventory.execute();
//        System.out.println(inventory.get_books_with_quantity_and_price());
        inventory.add_commands(addBookCommand1,addBookCommand2, addBookCommand3, addBookCopiesCommand1, sellBookCommand1,findBookCommand1,changeBookPriceCommand1);
        inventory.execute();
        System.out.println(inventory.get_books_with_quantity_and_price());
        inventory.recover();
        System.out.println(inventory.get_books_with_quantity_and_price());

    }
}