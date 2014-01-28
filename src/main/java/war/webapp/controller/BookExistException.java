package war.webapp.controller;

public class BookExistException extends Exception {
    public BookExistException(final String message) {
        super(message);
    }
}
