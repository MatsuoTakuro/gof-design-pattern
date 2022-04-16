package Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        bookShelf.appendBook(new Book("East of Eden"));
        bookShelf.appendBook(new Book("Frankenstein"));
        bookShelf.appendBook(new Book("Gulliver's Travels"));
        bookShelf.appendBook(new Book("Hamlet"));

        Iterator<Book> bookShelfIterator = bookShelf.iterator();
        while (bookShelfIterator.hasNext()) {
            Book book = bookShelfIterator.next();
            System.out.println(book.getName());
        }
        System.out.println();

        for (Book book: bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}