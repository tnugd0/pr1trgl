import java.io.*;
import java.util.*;

public class BookManager {
    ArrayList<Book> booklist;
    public BookManager() {
        booklist = new ArrayList<>();
    }


    public ArrayList<Book> getBooks(){
        return booklist;
    }

    public void loadFromFile()  {
        System.out.println("Loading books......");
        try {
            File file = new File("books.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
                String line = sc.nextLine();
                if (line.isEmpty()) continue;
                int id = Integer.parseInt(line.substring(0, 5).trim());
                String name = line.substring(6, 51).trim();
                double price = Double.parseDouble(line.substring(51).trim());
                Book book = new Book(id, name, price);
                booklist.add(book);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }

    }

    
    public void printBooks(ArrayList<Book> books) {
        if (!books.isEmpty()) {
            System.out.printf("%-5s %-45s %-10s\n", "ID", "Name", "Price");
            for (int i = 0; i < books.size(); i++) {
                System.out.println(books.get(i));
            }
        } else {
            System.out.println("(empty)");
        }
    }

    public boolean add(Book book){
        booklist.add(book);
        return true;
    }

    public Book getBookById(int id){
        for (Book book: booklist){
            if (book.id == id){
                return book;
            }
        }
        return null;
    }
    public void remove(Book book){
        booklist.remove(book);
    }
    public void sortDescByPrice() {
        Collections.sort(booklist, new Comparator<Book>() {
            @Override
            public int compare(Book firstBook, Book secondBook) {
                return Double.compare(secondBook.price,firstBook.price);
            }
        });
    }
    public ArrayList<Book> searchByName(String keyword){
        ArrayList<Book> matchTheWord = new ArrayList<>();
        for (int x=0 ; x < booklist.size(); x ++){
            if (booklist.get(x).name.toLowerCase().contains(keyword.toLowerCase())){
                int id = booklist.get(x).id;
                String name = booklist.get(x).name;
                double price = booklist.get(x).price;
                Book book = new Book(id,name,price);
                matchTheWord.add(book);
            }
        }return matchTheWord;
    }
    public void saveToFile(){
        try {
            PrintWriter writer = new PrintWriter("books.txt");
            for (Book book: booklist){
                writer.printf("%5d %-45s %10.2f %n",book.id,book.name,book.price);
            }writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
