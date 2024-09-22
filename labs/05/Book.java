public class Book extends Item {
    private int isbn_number;
    private String author;
    Book book;
//Constructors
    Book () {
        super();
    }
    Book (String title, int isbn_number, String author) {
        super(title);
        this.isbn_number = isbn_number;
        this.author      = author;
    }
//Getters
    int    getIsbn_number () { return isbn_number; }
    String getAuthor      () { return author;      }
//Setters
    void setIsbn_number (int isbn_number) { this.isbn_number = isbn_number;}
    void setAuthor      (String author)   { this.author = author;}
//Methods
    String getListing() {
        return "Book Name - " + getTitle()       + "\n" +
                "Author - "   + getAuthor()      + "\n" +
                "ISBN # - "   + getIsbn_number() + "\n";
    }
}
