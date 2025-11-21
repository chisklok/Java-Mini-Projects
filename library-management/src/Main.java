import model.Book;
import service.LibraryService;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LibraryService lib = new LibraryService();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book\n2. Search\n3. Borrow\n4. Exit");
            String c = in.nextLine();

            switch (c) {
                case "1":
                    System.out.print("ID: ");
                    String id = in.nextLine();
                    System.out.print("Title: ");
                    String title = in.nextLine();
                    System.out.print("Author: ");
                    String author = in.nextLine();
                    lib.addBook(new Book(id, title, author));
                    break;

                case "2":
                    System.out.print("Keyword: ");
                    String k = in.nextLine();
                    lib.search(k).forEach(b -> 
                        System.out.println(b.getId() + " | " + b.getTitle() + " - " + b.getAuthor())
                    );
                    break;

                case "3":
                    System.out.print("Book ID: ");
                    lib.borrow(in.nextLine());
                    break;

                default: return;
            }
        }
    }
}
