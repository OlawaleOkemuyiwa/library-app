package libapp;

import java.util.ArrayList;

public class LibraryApp {
    BookRepository bookRepo = new BookRepository();

    public void searchByIsbn(String isbn) {
        System.out.printf("Searching for books with ISBN %s.\n", isbn);
        Book book = bookRepo.findByIsbn(isbn);
        if (book != null) {
            System.out.printf("1 book found:\n\tTitle: %s\n\tGenre: %s\n\tAuthor: %s", book.getTitle(),book.getGenre(), book.getAuthor());
        } else {
            System.out.println("0 books found");
        }
        System.out.print("\n\n");
    }

    public void searchByTitle(String keyword) {
        System.out.printf("Searching for books with '%s' in their title...\n", keyword );
        ArrayList<Book> books =  bookRepo.findByTitle(keyword);
        char sign = books.size() > 0 ? ':' : '.';
        System.out.printf("%s book found%s \n", books.size(), sign);
        for (Book book: books) {
            System.out.printf("\tTitle: %s\n\tGenre: %s\n\tAuthor: %s\n\t---\n", book.getTitle(),book.getGenre(), book.getAuthor());
        }
        System.out.println();
    }

    public void checkoutBook(String isbn) {
        Book book = bookRepo.findByIsbn(isbn);
        if (book != null) {
            if (book.checkOut()) {
                System.out.println("Check out SUCCESSFUL: ");
                System.out.printf("\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n\n", book.getIsbn(), book.getTitle(), book.getGenre(), book.getAuthor());
            }
            else {
                System.out.println("check out FAILED: ");
                System.out.printf("\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n", book.getIsbn(), book.getTitle(), book.getGenre(), book.getAuthor());
                System.out.println("Reason: More books checked than recorded quantity.\n");
            }

        }
        else {
            System.out.println("Failed to check out book.");
            System.out.printf("Reason: There is no book with ISBN %s on record\n ", isbn);
        }
    }

    public void checkInBook(String isbn) {
        Book book = bookRepo.findByIsbn(isbn);
        if (book != null) {
            book.checkIn();
            System.out.println("Book checked in successfully:");
            System.out.printf("\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n\n", book.getIsbn(), book.getTitle(), book.getGenre(), book.getAuthor());
        }
        else {
            System.out.println("Failed to check in book.");
            System.out.printf("Reason: There is no book with ISBN %s on record\n ", isbn);
        }
    }
}
