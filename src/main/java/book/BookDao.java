package book;

import java.awt.print.Book;

public interface BookDao {
    boolean addBook(book book);
    boolean deleteBook(book book);
    boolean changeBook(book book);
    book getBook(book book);
    boolean borrowBook(book book);
    boolean returnBook(book book);
}
