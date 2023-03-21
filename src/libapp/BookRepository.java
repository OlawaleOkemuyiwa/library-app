package libapp;

import java.util.ArrayList;

public class BookRepository {
    private ArrayList<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book("36452", "The Dead of the Night", "Horror", null, "S.K Elton", 10, 7));
        books.add(new Book("92379", "The Walking Dead", "Historical ", null, "H.P. Anderson",5, 2));
        books.add(new Book("58753", "The Knight's Sword", "Fantasy", null, "F.E Anvil", 10, 6));
        books.add(new Book("67899", "Castle Siege", "Fantasy", null, "T.K Token", 11, 5));
        books.add(new Book("56790", "Night and day", "Fantasy", null, "J.K Rowling",9, 3));
        books.add(new Book("34564", "Castles and Crenellations", "Fantasy", null, "Chimamanda", 4, 1));
    }

    public Book findByIsbn(String isbn) {
        for (Book book: books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> findByTitle(String keyword) {
        ArrayList<Book> booksFound = new ArrayList<>();
        for (Book book: books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                booksFound.add(book);
            }
        }
        return booksFound;
    }
}
