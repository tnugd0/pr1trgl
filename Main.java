import java.util.*;
public class Main {
    public static void main(String[] args)   {
        BookManager bookmanager = new BookManager();
        bookmanager.loadFromFile();
        System.out.println();
        Scanner sc;
        boolean isTrue = true;
        do{
            try{
                sc = new Scanner(System.in);
                displayMenu();
                System.out.print("Your choice: ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1: 
                        bookmanager.printBooks(bookmanager.getBooks());
                        break;
                    case 2:
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Enter ID: ");
                        try{
                            int id = Integer.parseInt(scanner.nextLine());
                            if (bookmanager.getBookById(id) == null){
                                System.out.print("Enter book name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter book price: ");
                                double price = Double.parseDouble(scanner.nextLine());
                                Book book = new Book(id,name,price);
                                bookmanager.add(book);
                                System.out.println("Added successfully");
                            } else {
                                System.out.println("Duplicated ID");
                            }
                        } catch (NumberFormatException e){
                            System.out.println("Invalid Input..... ");
                        }
                        break;
                    case 3:
                        try {
                            System.out.print("Enter book id: ");
                            int id3 = sc.nextInt();
                            sc.nextLine();
                            Book book3 = bookmanager.getBookById(id3);
                            if (book3 != null) {
                                System.out.print("Enter book name: ");
                                String name3 = sc.nextLine();
                                System.out.print("Enter book price: ");
                                double price3 = sc.nextDouble();
                                book3.setName(name3);
                                book3.setPrice(price3);
                                System.out.println("Updated successfully.");
                            } else {
                                System.out.println("Empty");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input!");
                            sc.nextLine();
                        }
                        break;
                    case 4:
                        sc = new Scanner(System.in);
                        System.out.print("Enter the Id: ");
                        try{
                            int removeId = Integer.parseInt(sc.nextLine());
                            if (bookmanager.getBookById(removeId) != null){
                                bookmanager.remove(bookmanager.getBookById(removeId));
                                System.out.println("Deleted successfully");
                            } else {
                                System.out.println("Invalid ID!");
                            }
                        } catch (NumberFormatException e){
                            System.out.println("Invalid input, please enter again");
                        }
                        break;
                    case 5:
                        sc = new Scanner(System.in);
                        System.out.print("Enter book's name: ");
                        String keyword = sc.nextLine();
                        ArrayList<Book> result = bookmanager.searchByName(keyword);
                        if (result.isEmpty()){
                            System.out.println("Not found");
                        } else{
                            bookmanager.printBooks(result);
                        }
                        break;
                    case 6: // sort by price
                        bookmanager.sortDescByPrice();
                        System.out.println("After sorting: ");
                        bookmanager.printBooks(bookmanager.getBooks());
                        break;
                    case 0: // save then exit
                        bookmanager.saveToFile();
                        System.out.println("Saving to file...");
                        System.out.println("Bye!");
                        isTrue = false;
                        break;
                    default:
                        System.out.println("Invalid input, Please choose again");
                }
            } catch (Exception e){
                System.out.println("Invalid input");
            }
        } while (isTrue);
    }
    public static void displayMenu(){
        int[] number = {1,2,3,4,5,6,0};
        String [] line = {"List all books.","Add a new book.","Edit book.","Delete a book.","Search books by name.","Sort books descending by price.","Save & exit."};
        System.out.println("-------------------------------------");
        for(int x =0; x < line.length; x ++){
            System.out.format(" %-2d %-31s %n",number[x],line[x]);
        }
        System.out.println("-------------------------------------");
    }
}
