public class Book {
    int id;
    String name; 
    double price;
    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String printFormat = "%5d %-45s %10.2f";
        String book = String.format(printFormat, id, name, price);
        return book;
    }
}
