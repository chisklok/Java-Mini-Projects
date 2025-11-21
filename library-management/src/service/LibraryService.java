
package service;

import model.Book;
import util.JsonUtil;
import java.util.*;

public class LibraryService {
    private List<Book> books;

    public LibraryService() {
        books = JsonUtil.loadBooks();
    }

    public void addBook(Book b) {
        books.add(b);
        JsonUtil.saveBooks(books);
    }

    public List<Book> search(String keyword) {
        keyword = keyword.toLowerCase();
        List<Book> results = new ArrayList<>();

        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword) ||
                b.getAuthor().toLowerCase().contains(keyword)) {
                results.add(b);
            }
        }
        return results;
    }

    public void borrow(String id) {
        for (Book b : books) {
            if (b.getId().equals(id) && !b.isBorrowed()) {
                b.borrow();
                JsonUtil.saveBooks(books);
                return;
            }
        }
    }
}
