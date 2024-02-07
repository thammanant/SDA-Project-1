public class Book {
    private String name;
    private Integer price;
    private Integer ID;
    private Integer quantity;

    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
        // TODO implement ID generation
    }

    public Book(Integer ID, String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ID = ID;
    }

    public String get_Name() {
        return name;
    }

    public Integer get_Price() {
        return price;
    }

    public Integer get_ID() {
        return ID;
    }

    public Integer get_Quantity() {
        return quantity;
    }

    public void set_Name(String name) {
        this.name = name;
    }

    public void set_Price(Integer price) {
        this.price = price;
    }

    public void set_ID(Integer ID) {
        this.ID = ID;
    }

    public void set_Quantity(Integer quantity) {
        this.quantity = quantity;
    }
}
