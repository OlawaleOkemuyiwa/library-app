package libapp;

public class Book {
    private String isbn;
    private String title;
    private String genre;
    private String description;
    private String author;
    private int quantity;
    private int numCheckedOut;

    public Book(String isbn, String title, String genre, String description, String author, int quantity, int numCheckedOut) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.author = author;
        this.quantity = quantity;
        this.numCheckedOut = numCheckedOut;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getNumCheckedOut() {
        return numCheckedOut;
    }

    public boolean checkOut() {
        if (numCheckedOut >= quantity) { //numChecked can only be increased if it is less than the quantity of books
            return false;
        }
        else {
            numCheckedOut++;
            return true;
        }
    }

    public boolean checkIn() {   //numChecked can only be decreased if it is greater than 0
        if (numCheckedOut <= 0) {
            return false;
        }
        else {
            numCheckedOut--;
            return true;
        }
    }
}
